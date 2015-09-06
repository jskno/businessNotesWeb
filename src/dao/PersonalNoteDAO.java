package dao;

import java.util.List;

import persistence.DDBBNote;
import persistence.DDBBPersonalNote;
import model.Note;
import model.PersonalNoteVO;

public interface PersonalNoteDAO extends Dao {

	public List<PersonalNoteVO> getLastPersonalNotes();
	List<DDBBPersonalNote> getPersistenceCustomerList();
	void insertList(List<Note> notesList);

}
