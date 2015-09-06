package dao;

import java.util.List;

import persistence.DDBBNote;
import model.NoteVO;

public interface NoteDAO extends Dao {

	List<NoteVO> getLastNotes();
	List<DDBBNote> getPersistenceCustomerList();
	void insertList(List<NoteVO> notesList);

}
