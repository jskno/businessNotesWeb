package service;

import java.util.List;

import model.BusinessNoteVO;
import dao.BusinessNoteDAO;
import dao.BusinessNoteDAOImpl;

public class GetBusinessNotesListService extends ServiceImpl implements Service {

	@Override
	protected void execute() {
		
		getBusinessNotesList();
		request.setAttribute("url", "businessNotesList.jsp");
	}

	private void getBusinessNotesList() {
		
		try {
			BusinessNoteDAO businessNoteDao = new BusinessNoteDAOImpl(
					getConnection(), getSession());
			List<BusinessNoteVO> businessNotesList = businessNoteDao.
					getLastBusinessNotes();
			request.setAttribute("notesList", businessNotesList);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
