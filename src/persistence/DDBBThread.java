package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DDBBThread {
	
	private static final String INSERT_ALL = "insert into thread (THREAD_TITLE) values (?)";
	private static final String LAST_ID = "SELECT LAST_INSERT_ID()";
	private static final String SQL_READ="SELECT * FROM thread WHERE THREAD_ID=?";
	private static final String SQL_DELETE="DELETE FROM thread WHERE THREAD_ID=?";
	
	private int threadId;
	private String threadTitle;
	
	private int threadIdNull;
	
	public int getThreadId() {
		return threadId;
	}
	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}
	public String getThreadTitle() {
		return threadTitle;
	}
	public void setThreadTitle(String threadTitle) {
		this.threadTitle = threadTitle;
	}
	
	public int getThreadIdNull() {
		return threadIdNull;
	}
	public void setThreadIdNull() {
		this.threadIdNull = 2;
	}
	public boolean isThreadIdNull() {
		return getThreadIdNull() == 2;
	}
	public boolean isThreadTitleNull() {
		return threadTitle == null;
	}
	public void setThreadTitleNull() {
		this.threadTitle = null;
	}
	
	public void loadResult(ResultSet rs) throws SQLException {
		
		setThreadId(rs.getInt("THREAD_ID"));
		if(rs.wasNull()) {
			setThreadIdNull();
		}
		setThreadTitle(rs.getString("THREAD_TITLE"));
		if(rs.wasNull()) {
			setThreadTitleNull();
		}
		
	}
	
	public int insert(Connection connection) throws SQLException {
		
		int lastKey;		
		final PreparedStatement ps = connection.prepareStatement(INSERT_ALL);
		final Statement stmt = connection.createStatement();
		ResultSet rs = null;
		int p=1;
		
		try
		{
			// SQL: NOTE_ID (INT):
			if (isThreadTitleNull())
			{
				ps.setNull(p, java.sql.Types.VARCHAR);
			}
			else
			{
				ps.setString(p, getThreadTitle());
			}
			ps.executeUpdate();
			
			rs = stmt.executeQuery(LAST_ID);
			lastKey = rs.getInt(0);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ps.close();
			rs.close();
			stmt.close();
		}
			
		return lastKey;
	}
	
	public static DDBBThread read(final Connection connection, int threadId)
			throws SQLException {
		
		final PreparedStatement ps = connection.prepareStatement(SQL_READ);
		ResultSet rs = null;
		int p = 1;
		try {
			ps.setInt(p, threadId);
			rs = ps.executeQuery();
			DDBBThread ddbbThread;
			if(rs.next()) {
				ddbbThread = new DDBBThread();
				ddbbThread.loadResult(rs);
			} else {
				ddbbThread = null;
			}
			return ddbbThread;
		} finally {
			if(rs != null) {
				rs.close();
			}
			ps.close();
		}
	}
	
	public boolean delete(final Connection connection)
			throws java.sql.SQLException {
		
		PreparedStatement ps=connection.prepareStatement(SQL_DELETE);
		int p=1;
		try	{
			ps.setInt(p++, getThreadId());
			//ps.setLong(p++, this.myOptimistLock);
					
			if (ps.executeUpdate() <= 0) {
				throw new SQLException();
			}
		} finally {
			ps.close();
		}
		return true;
	}

}
