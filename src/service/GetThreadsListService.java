package service;

import java.util.List;

import model.ThreadVO;
import dao.ThreadDAO;
import dao.ThreadDAOImpl;

public class GetThreadsListService extends ServiceImpl implements Service {

	@Override
	protected void execute() {

		getThreadsList();
		request.setAttribute("url", "threadsList.jsp?");
	}
	
	private void getThreadsList() {

		try {
			ThreadDAO threadDao = new ThreadDAOImpl(getConnection(), getSession());
			List<ThreadVO> threadsList = threadDao.getThreadsList();
			request.setAttribute("threadsList", threadsList);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
