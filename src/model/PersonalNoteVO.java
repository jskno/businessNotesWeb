package model;

import java.util.Date;

import persistence.DDBBPersonalNote;

public class PersonalNoteVO extends NoteVO {
	
	private Date remainderDate;
	
	public Date getRemainderDate() {
		return remainderDate;
	}
	public void setRemainderDate(Date remainderDate) {
		this.remainderDate = remainderDate;
	}
	
	public DDBBPersonalNote getPersistencePersNote() {
		DDBBPersonalNote ddbbPersonalNote = new DDBBPersonalNote();
		if(getNoteId() != null) {
			ddbbPersonalNote.setNoteId(getNoteId());
		} else 
			ddbbPersonalNote.setNoteIdNull();
		if(getRemainderDate() != null) {
			ddbbPersonalNote.setRemainderDate(new java.sql.Date (
					getRemainderDate().getTime()));
		} else {
			ddbbPersonalNote.setRemainderDateNull();
		}
		return ddbbPersonalNote;
	}
	
	public void setFromPersistenceNote(DDBBPersonalNote ddbbPersonalNote) {
		
		if(!ddbbPersonalNote.isRemainderDateNull()) {
			setCreationDate(new Date (
					ddbbPersonalNote.getRemainderDate().getTime()));
		}
		
	}

}
