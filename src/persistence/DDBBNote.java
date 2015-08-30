package persistence;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DDBBNote {
	
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
	
}
