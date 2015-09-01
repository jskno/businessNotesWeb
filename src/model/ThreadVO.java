package model;

import persistence.DDBBThread;

public class ThreadVO {
	
	private Integer threadId;
	private String threadTitle;
	
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
	}
	
	
	

}
