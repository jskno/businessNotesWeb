package dao;

import java.util.List;

import persistence.DDBBNote;
import model.Note;

public interface PersonalNoteDAO extends Dao {

	List<Note> getLastNotes();
	List<DDBBNote> getPersistenceCustomerList();
	void insertList(List<Note> notesList);

}
