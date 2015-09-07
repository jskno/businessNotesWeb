package dao;

import java.util.List;

import persistence.DDBBNote;
import persistence.DDBBPersonalNote;
import model.NoteVO;
import model.PersonalNoteVO;

public interface PersonalNoteDAO extends DAO {

	public List<PersonalNoteVO> getLastPersonalNotes();
	List<DDBBPersonalNote> getPersistenceCustomerList();
	void insertList(List<NoteVO> notesList);

}
