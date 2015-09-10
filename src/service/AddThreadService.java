package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.BusinessNoteVO;
import model.ThreadNoteVO;
import model.ThreadVO;
import dao.BusinessNoteDAO;
import dao.BusinessNoteDAOImpl;
import dao.ThreadDAO;
import dao.ThreadDAOImpl;
import dao.ThreadNoteDAO;
import dao.ThreadNoteDAOImpl;

public class AddThreadService extends ServiceImpl implements Service {
	
	private String threadTitle;
	private Date creationDate;
	private List<Integer> notesIdList;
	private Integer threadId;
	
	private ThreadVO thread;
	private BusinessNoteVO note;
	private ThreadNoteVO threadNote;
	
	private ThreadDAO threadDao;
	private BusinessNoteDAO noteDao;
	private ThreadNoteDAO threadNoteDao;

	@Override
	protected void execute() {

		instantiation();
		createThread();
		createNoteThreads();
		request.setAttribute("nextStep", "threadsList");
	}

	private void instantiation() {
		
		noteDao = new BusinessNoteDAOImpl(getConnection(), getSession());
		threadDao = new ThreadDAOImpl(getConnection(), getSession());
		threadNoteDao = new ThreadNoteDAOImpl(getConnection(), getSession());
		thread = new ThreadVO();
		threadNote = new ThreadNoteVO();
	}
	
	private void createThread() {
		setThreadAttributes();
		threadId = threadDao.insert(thread);
		thread.setThreadId(threadId);
		
	}

	private void setThreadAttributes() {
		thread.setThreadTitle(threadTitle);
		thread.setCreationDate(creationDate);
	}
	
	private void createNoteThreads() {
		
		for(Integer eachNoteId : notesIdList) {
			getNoteThreadObjects(eachNoteId);
			threadNote.setThread(thread);
			threadNote.setNote(note);
			threadNoteDao.insert(threadNote);
		}
	}
	
	private void getNoteThreadObjects(Integer noteId) {
		note = noteDao.getBusinessNoteById(noteId);
	}
	
	@Override
	public void getDomainData(HttpServletRequest request) {
		
		notesIdList = new ArrayList<Integer>();
		String[] idsList = request.getParameterValues("IdsList");
		for(int i = 0; i < idsList.length; i++) {
			int noteId = Integer.parseInt(idsList[i]);
			notesIdList.add(noteId);
			}
						
		threadTitle = request.getParameter("threadTitle");
		creationDate = new Date();
		
	}

}
