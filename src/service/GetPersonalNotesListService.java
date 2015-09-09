package service;

import java.util.List;

import model.NoteVO;
import dao.NoteDAO;
import dao.NoteDAOImpl;

public class GetPersonalNotesListService extends ServiceImpl implements Service {

	@Override
	protected void execute() {
		
		try {
			NoteDAO noteDao = new NoteDAOImpl(null, null);
			List<NoteVO> notesList = noteDao.getLastNotes();
			request.setAttribute("notesList", notesList);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		request.setAttribute("url", "notesList.jsp");
		
	}

	

}
