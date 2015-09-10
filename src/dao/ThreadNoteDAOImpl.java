package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.ThreadNoteVO;
import persistence.DDBBThreadNote;

public class ThreadNoteDAOImpl extends DAOImpl implements ThreadNoteDAO {
    
    public ThreadNoteDAOImpl(Connection connection, HttpSession session) {
    	super(connection, session);
    }
    
	@Override
	public int insert(Object o){
		
		int threadNoteId = -1;
		
		ThreadNoteVO threadNote = (ThreadNoteVO) o;
		DDBBThreadNote ddbbThreadNote = threadNote.getPersistenceObject();
		try {
			threadNoteId = ddbbThreadNote.insert(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return threadNoteId;
	}
	
	@Override
	public Object search(Object o) {
		return null;
	}
	
	@Override
	public void update(Object o) {
		
	}
	
	@Override
	public void delete(Object o) {
		
	}

	@Override
	public void insertList(List<ThreadNoteVO> threadNotesList) {
		
	}

}
