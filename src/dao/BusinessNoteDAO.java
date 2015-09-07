package dao;

import java.util.List;

import model.BusinessNoteVO;
import persistence.DDBBBusinessNote;

public interface BusinessNoteDAO extends DAO {

	List<BusinessNoteVO> getLastBusinessNotes();
	List<DDBBBusinessNote> getPersistenceBusinessNotesList();
	void insertList(List<BusinessNoteVO> notesList);

}
