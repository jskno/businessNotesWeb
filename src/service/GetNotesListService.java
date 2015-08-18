package service;

import java.util.List;

import model.Note;
import dao.NoteDAO;
import dao.NoteDAOImpl;

public class GetNotesListService extends ServiceImpl {

	@Override
	protected void execute() {
		
		try {
			NoteDAO noteDao = new NoteDAOImpl(null, null);
			List<Note> notesList = noteDao.getLastNotes();
			request.setAttribute("notesList", notesList);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		request.setAttribute("url", "notesList.jsp");
		
	}

	

}