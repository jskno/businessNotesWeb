package dao;

import java.util.List;

import model.BusinessNoteVO;
import persistence.DDBBBusinessNote;

public interface BusinessNoteDAO extends Dao {

	List<BusinessNoteVO> getLastBusinessNotes();
	List<DDBBBusinessNote> getPersistenceBusinessNotesList();
	void insertList(List<BusinessNoteVO> notesList);

}
