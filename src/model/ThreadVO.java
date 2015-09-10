package model;

import java.util.Date;
import java.util.List;

import persistence.DDBBThread;

public class ThreadVO {
	
	private Integer threadId;
	private String threadTitle;
	private Date creationDate;
	private List<BusinessNoteVO> notesList;
	
	public Integer getThreadId() {
		return threadId;
	}
	public void setThreadId(Integer threadId) {
		this.threadId = threadId;
	}
	public String getThreadTitle() {
		return threadTitle;
	}
	public void setThreadTitle(String threadTitle) {
		this.threadTitle = threadTitle;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public List<BusinessNoteVO> getNotesList() {
		return notesList;
	}
	public void setNotesList(List<BusinessNoteVO> notesList) {
		this.notesList = notesList;
	}
	public DDBBThread getPersistenceObject() {
		DDBBThread ddbbThread = new DDBBThread();
		if(getThreadId() != null) {
			ddbbThread.setThreadId(getThreadId());
		} else {
			ddbbThread.setThreadIdNull();
		}
		if(getThreadTitle() != null) {
			ddbbThread.setThreadTitle(getThreadTitle());
		} else {
			ddbbThread.setThreadTitleNull();
		}
		if(getCreationDate() != null) {
			ddbbThread.setCreationDate(
					new java.sql.Date(getCreationDate().getTime()));
		} else {
			ddbbThread.setCreationDateNull();
		}
		return ddbbThread;
	}
	
	public void setFromPersistenceObject(DDBBThread ddbbThread) {
		
		if(!ddbbThread.isThreadIdNull()) {
			setThreadId(ddbbThread.getThreadId());
		} else {
			setThreadId(null);
		}
		if(!ddbbThread.isThreadTitleNull()) {
			setThreadTitle(ddbbThread.getThreadTitle());
		} else {
			setThreadTitle(null);
		}
		if(!ddbbThread.isCreationDateNull()) {
			setCreationDate(ddbbThread.getCreationDate());
		} else {
			setCreationDate(null);
		}
	}
}
