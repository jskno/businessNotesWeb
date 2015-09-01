package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DDBBThreadNote {
	
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
	

}
