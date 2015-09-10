package dao;

import java.util.List;

import model.BusinessNoteVO;
import model.ThreadNoteVO;
import persistence.DDBBBusinessNote;

public interface ThreadNoteDAO extends DAO {

	void insertList(List<ThreadNoteVO> threadNotesList);

}
