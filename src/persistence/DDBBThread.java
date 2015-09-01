package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DDBBThread {
	
	private int threadId;
	private String threadTitle;
	
	private int threadIdNull;
	private int threadTitleNull;
	
	public int getThreadId() {
		return threadId;
	}
	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}
	public String getThreadTitle() {
		return threadTitle;
	}
	public void setThreadTitle(String threadTitle) {
		this.threadTitle = threadTitle;
	}
	
	public int getThreadIdNull() {
		return threadIdNull;
	}
	public void setThreadIdNull() {
		this.threadIdNull = 2;
	}
	public boolean isThreadNull() {
		return getThreadIdNull() == 2;
	}
	public boolean isThreadTitleNull() {
		return threadTitle == null;
	}
	public void setThreadTitleNull() {
		this.threadTitle = null;
	}
	
	public void loadResult(ResultSet rs) throws SQLException {
		
		setThreadId(rs.getInt("THREAD_ID"));
		if(rs.wasNull()) {
			setThreadIdNull();
		}
		setThreadTitle(rs.getString("THREAD_TITLE"));
		if(rs.wasNull()) {
			setThreadTitleNull();
		}
		
	}

}
