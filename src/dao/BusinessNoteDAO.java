package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.BusinessNoteVO;
import persistence.DDBBBusinessNote;

public interface BusinessNoteDAO extends DAO {

	List<BusinessNoteVO> getLastBusinessNotes();
	List<DDBBBusinessNote> getPersistenceBusinessNotesList();
	void insertList(List<BusinessNoteVO> notesList);
	List<BusinessNoteVO> getBusinessNotesListFromRs(ResultSet rs) throws SQLException;
	BusinessNoteVO getBusinessNoteFromRs(ResultSet rs) throws SQLException;
	BusinessNoteVO getBusinessNoteById(int noteId);

}
