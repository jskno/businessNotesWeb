package model;

import persistence.DDBBThreadNote;

public class ThreadNoteVO {
	
	private ThreadVO thread;
	private BusinessNoteVO note;
	
	public ThreadVO getThread() {
		return thread;
	}
	public void setThread(ThreadVO thread) {
		this.thread = thread;
	}
	public BusinessNoteVO getNote() {
		return note;
	}
	public void setNote(BusinessNoteVO note) {
		this.note = note;
	}
	
	public DDBBThreadNote getPersistenceObject() {
		DDBBThreadNote ddbbThreadNote = new DDBBThreadNote();
		if(getThread() != null) {
			ddbbThreadNote.setThreadId(getThread().getThreadId());
		} else {
			ddbbThreadNote.setThreadIdNull();
		}
		if(getNote() != null) {
			ddbbThreadNote.setNoteId(getNote().getNoteId());
		} else {
			ddbbThreadNote.setNoteIdNull();
		}
		return ddbbThreadNote;
	}

}
