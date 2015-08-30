package persistence;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DDBBPersonalNote {
	
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
}
