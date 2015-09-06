package model;

import java.util.Date;

import persistence.DDBBNote;

public abstract class NoteVO {
	
	private UserVO user;
	private Integer noteId;
	private Date creationDate;
	private String noteText;
	private String noteTitle;
	
	public NoteVO() {
	}
	
	public NoteVO(String noteTitle, String noteText, Date creationDate) {
		this.noteTitle = noteTitle;
		this.noteText = noteText;
		this.creationDate = creationDate;
	}

	public UserVO getUser() {
		return user;
	}
	public void setUser(UserVO user) {
		this.user = user;
	}
	public Integer getNoteId() {
		return noteId;
	}
	public void setNoteId(Integer noteId) {
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

	public DDBBNote getPersistenceObject() {
		
		DDBBNote ddbbNote = new DDBBNote();
		if(getNoteId() != null) {
			ddbbNote.setNoteId(getNoteId());
		} else {
			ddbbNote.setNoteIdNull();
		}
		if(getUser() != null) {
			ddbbNote.setUserId(getUser().getUserId());
		} else {
			ddbbNote.setUserIdNull();
		}
		if(getCreationDate() != null) {
			ddbbNote.setCreationDate(
				new java.sql.Date(getCreationDate().getTime()));
		} else {
			ddbbNote.setCreationDateNull();
		}
		if(getNoteTitle() != null) {
			ddbbNote.setNoteTitle(getNoteTitle());
		} else {
			ddbbNote.setNoteTitleNull();
		}
		if(getNoteText() != null) {
			ddbbNote.setNoteText(getNoteText());
		} else {
			ddbbNote.setNoteTextNull();
		}
		return ddbbNote;
	}
	
	public void setFromPersistenceObject(DDBBNote ddbbNote) {
		
		UserVO user = new UserVO();
		
		if(!ddbbNote.isUserIdNull()) {
			user.setUserId(ddbbNote.getUserId());
		}
		setUser(user);
		
		if(!ddbbNote.isNoteIdNull()) {
			setNoteId(ddbbNote.getUserId());
		} else {
			setNoteId(noteId);
		}
		if(!ddbbNote.isCreationDateNull()) {
			setCreationDate(new Date(
					ddbbNote.getCreationDate().getTime()));
		} else {
			setCreationDate(null);
		}
		if(!ddbbNote.isNoteTitleNull()) {
			setNoteTitle(ddbbNote.getNoteTitle());
		} else {
			setNoteTitle(null);
		}
		if(!ddbbNote.isNoteTextNull()) {
			setNoteText(ddbbNote.getNoteText());
		} else {
			setNoteText(null);
		}
	}
	

}
