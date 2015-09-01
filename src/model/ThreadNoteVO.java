package model;

import persistence.DDBBThreadNote;

public class ThreadNoteVO {
	
	private Integer threadId;
	private Integer noteId;
	
	public Integer getThreadId() {
		return threadId;
	}
	public void setThreadId(Integer threadId) {
		this.threadId = threadId;
	}
	public Integer getNoteId() {
		return noteId;
	}
	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}
	
	public DDBBThreadNote getPersistenceObject() {
		DDBBThreadNote ddbbThreadNote = new DDBBThreadNote();
		if(getThreadId() != null) {
			ddbbThreadNote.setThreadId(getThreadId());
		} else {
			ddbbThreadNote.setThreadIdNull();
		}
		if(getNoteId() != null) {
			ddbbThreadNote.setNoteId(getNoteId());
		} else {
			ddbbThreadNote.setNoteIdNull();
		}
		return ddbbThreadNote;
	}

}
