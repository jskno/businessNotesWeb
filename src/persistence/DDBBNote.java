package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DDBBNote {
	
	private static final String INSERT_ALL = "insert into note "
			+ "(USER_ID, CREATION_DATE, NOTE_TITLE, NOTE_TEXT)"
			+ " values (?,?,?,?)";
	private static final String SQL_READ="SELECT * FROM note WHERE NOTE_ID=?";
	private static final String SQL_DELETE="DELETE FROM note WHERE NOTE_ID=?";
	private static final String LAST_ID = "SELECT LAST_INSERT_ID()";
	
	private int userId;
	private int noteId;
	private Date creationDate;
	private String noteText;
	private String noteTitle;
	
	private int userIdNull;
	private int noteIdNull;
		
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getNoteText() {
		return noteText;
	}
	public void setNoteText(String noteText) {
		this.noteText = noteText;
	}
	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	
	public int getUserIdNull() {
		return userIdNull;
	}
	public void setUserIdNull() {
		this.userIdNull = 2;
	}
	public boolean isUserIdNull() {
		return getUserIdNull() == 2;
	}
	public int getNoteIdNull() {
		return noteIdNull;
	}
	public void setNoteIdNull() {
		this.noteIdNull = 2;
	}
	public boolean isNoteIdNull() {
		return getNoteIdNull() == 2;
	}
	public boolean isCreationDateNull() {
		return getCreationDate() == null;
	}
	public void setCreationDateNull() {
		this.creationDate = null;
	}
	public boolean isNoteTextNull() {
		return getNoteText() == null;
	}
	public void setNoteTextNull() {
		this.noteText = null;
	}
	public boolean isNoteTitleNull() {
		return getNoteTitle() == null;
	}
	public void setNoteTitleNull() {
		this.noteTitle = null;
	}
	
	public void loadResult(ResultSet rs) throws SQLException {
		
		setUserId(rs.getInt("USER_ID"));
		if(rs.wasNull()) {
			setUserIdNull();
		}
		setNoteId(rs.getInt("NOTE_ID"));
		if(rs.wasNull()) {
			setNoteIdNull();
		}
		setCreationDate(rs.getDate("CREATION_DATE"));
		setNoteTitle(rs.getString("NOTE_TITLE"));
		setNoteText(rs.getString("NOTE_TEXT"));
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
			if (isNoteIdNull())
			{
				ps.setNull(p, java.sql.Types.NUMERIC);
			}
			else
			{
				ps.setInt(p, getNoteId());
			}
			p++;
			// SQL: USER_ID (INT):
			if (isUserIdNull())
			{
				ps.setNull(p, java.sql.Types.NUMERIC);
			}
			else
			{
				ps.setInt(p, getNoteId());
			}
			p++;
			// SQL: CREATION_DATE (DATE):
			if (isCreationDateNull())
			{
				ps.setNull(p, java.sql.Types.DATE);
			}
			else
			{
				ps.setDate(p, new Date(getCreationDate().getTime()));
			}
			p++;
			// SQL: NOTE_TITLE (STRING):
			if (isNoteTitleNull())
			{
				ps.setNull(p, java.sql.Types.VARCHAR);
			}
			else
			{
				ps.setString(p, getNoteTitle());
			}
			p++;
			// SQL: NOTE_TEXT (STRING):
			if (isNoteTextNull())
			{
				ps.setNull(p, java.sql.Types.VARCHAR);
			}
			else
			{
				ps.setString(p, getNoteText());
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
	
	public static DDBBNote read(final Connection connection, int noteId)
			throws SQLException {
		
		final PreparedStatement ps = connection.prepareStatement(SQL_READ);
		ResultSet rs = null;
		int p = 1;
		try {
			ps.setInt(p, noteId);
			rs = ps.executeQuery();
			DDBBNote ddbbNote;
			if(rs.next()) {
				ddbbNote = new DDBBNote();
				ddbbNote.loadResult(rs);
			} else {
				ddbbNote = null;
			}
			return ddbbNote;
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
