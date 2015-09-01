package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DDBBThreadNote {
	
	private static final String INSERT_ALL = "insert into thread_note (THREAD_ID, " +
			"NOTE_ID) values (?,?)";
	private static final String SQL_READ="SELECT * FROM thread_note WHERE THREAD_ID=? AND NOTE_ID=?";
	private static final String SQL_DELETE="DELETE FROM thread_note WHERE THREAD_ID=? AND NOTE_ID=?";
	
	private int threadId;
	private int noteId;
	
	private int threadIdNull;
	private int noteIdNull;
	
	public int getThreadId() {
		return threadId;
	}
	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
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
	public int getNoteIdNull() {
		return noteIdNull;
	}
	public void setNoteIdNull() {
		this.noteIdNull = 2;
	}
	public boolean isNoteIdNull() {
		return noteIdNull == 2;
	}
	
	public void loadResult(ResultSet rs) throws SQLException {
		
		setThreadId(rs.getInt("THREAD_ID"));
		if(rs.wasNull()) {
			setThreadIdNull();
		}
		setNoteId(rs.getInt("NOTE_ID"));
		if(rs.wasNull()) {
			setNoteIdNull();
		}
		
	}
	
	public void insert(Connection connection) throws SQLException {
		
		final PreparedStatement ps = connection.prepareStatement(INSERT_ALL);
		int p=1;
		
		try
		{
			// SQL: THREAD_ID (INT):
			if (isThreadIdNull())
			{
				ps.setNull(p, java.sql.Types.NUMERIC);
			}
			else
			{
				ps.setInt(p, getThreadId());
			}
			// SQL: NOTE_ID (INT):
			if (isNoteIdNull())
			{
				ps.setNull(p, java.sql.Types.NUMERIC);
			}
			else
			{
				ps.setInt(p, getNoteId());
			}
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ps.close();
		}
			
	}
	
	public static DDBBThreadNote read(final Connection connection, int threadId, int noteId)
			throws SQLException {
		
		final PreparedStatement ps = connection.prepareStatement(SQL_READ);
		ResultSet rs = null;
		int p = 1;
		try {
			ps.setInt(p, threadId);
			p++;
			ps.setInt(p, noteId);
			rs = ps.executeQuery();
			DDBBThreadNote ddbbThreadNote;
			if(rs.next()) {
				ddbbThreadNote = new DDBBThreadNote();
				ddbbThreadNote.loadResult(rs);
			} else {
				ddbbThreadNote = null;
			}
			return ddbbThreadNote;
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
			ps.setInt(p++, getNoteId());
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
