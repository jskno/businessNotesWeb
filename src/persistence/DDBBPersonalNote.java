package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DDBBPersonalNote {
	
	private static final String INSERT_ALL = "insert into personal_note (NOTE_ID, REMAINDER_DATE " +
			"values (?,?)";
	private static final String SQL_READ="SELECT /*READ*/ * FROM personal_note WHERE NOTE_ID=?";
	private static final String SQL_DELETE="DELETE FROM personal_note WHERE NOTE_ID=?";
	
	private int noteId;
	private Date remainderDate;
	
	private int noteIdNull;
		
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	public Date getRemainderDate() {
		return remainderDate;
	}
	public void setRemainderDate(Date remainderDate) {
		this.remainderDate = remainderDate;
	}
	
	private int getNoteIdNull() {
		return noteIdNull;
	}
	public void setNoteIdNull() {
		this.noteIdNull = 2;
	}
	public boolean isNoteIdNull() {
		return getNoteIdNull() == 2;
	}
	public boolean isRemainderDateNull() {
		return remainderDate == null;
	}
	public void setRemainderDateNull() {
		this.remainderDate = null;
	}
	
	public void loadResult(ResultSet rs) throws SQLException {
		
		setNoteId(rs.getInt("NOTE_ID"));
		if(rs.wasNull()) {
			setNoteIdNull();
		}
		setRemainderDate(rs.getDate("REMAINDER_DATE"));
		if(rs.wasNull()) {
			setRemainderDateNull();
		}
	}
	
	public Integer insert(Connection connection) throws SQLException {
		
		Integer lastKey = null;
		final PreparedStatement ps = connection.prepareStatement(INSERT_ALL);
		int p=1;
		
		try
		{
			// SQL: NOTE_ID (INT):
			if (isNoteIdNull())
			{
				ps.setNull(p, java.sql.Types.NUMERIC);
			}
			else
			{
				ps.setInt(p, getNoteId());
			}
			p++;
			// SQL: REMAINDER_DATE (DATE):
			if (isRemainderDateNull())
			{
				ps.setNull(p, java.sql.Types.DATE);
			}
			else
			{
				ps.setDate(p, new Date(getRemainderDate().getTime()));
			}
			p++;
			ps.executeUpdate();
			
			lastKey = getNoteId();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ps.close();
		}
		return lastKey;
	}
	
	public static DDBBPersonalNote read(final Connection connection, int noteId)
			throws SQLException {
		
		final PreparedStatement ps = connection.prepareStatement(SQL_READ);
		ResultSet rs = null;
		int p = 1;
		try {
			ps.setInt(p, noteId);
			rs = ps.executeQuery();
			DDBBPersonalNote ddbbPersonalNote;
			if(rs.next()) {
				ddbbPersonalNote = new DDBBPersonalNote();
				ddbbPersonalNote.loadResult(rs);
			} else {
				ddbbPersonalNote = null;
			}
			return ddbbPersonalNote;
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
