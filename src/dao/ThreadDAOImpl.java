package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.BusinessNoteVO;
import model.CustomerVO;
import model.NoteVO;
import model.ProductVO;
import model.Profile;
import model.SupplierVO;
import model.ThreadVO;
import persistence.DDBBBusinessNote;
import persistence.DDBBNote;
import persistence.DDBBThread;
import utils.DateUtils;

public class ThreadDAOImpl extends DAOImpl implements ThreadDAO {
	
	private static final String MANAGER_LIST = 
			"SELECT * FROM THREAD T " +
					"JOIN THREAD_NOTE TN ON TN.THREAD_ID = T.THREAD_ID " + 
					"JOIN NOTE N ON N.NOTE_ID = TN.NOTE_ID " +
					"JOIN BUSINESS_NOTE BN ON BN.NOTE_ID = N.NOTE_ID " +
			"WHERE T.THREAD_ID = ?";
	
	private static final String SALES_TEAM_LIST = 
			"SELECT * FROM THREAD T " +
					"JOIN THREAD_NOTE TN ON TN.THREAD_ID = T.THREAD_ID " + 
					"JOIN NOTE N ON N.NOTE_ID = TN.NOTE_ID " +
					"JOIN BUSINESS_NOTE BN ON BN.NOTE_ID = N.NOTE_ID " + 
			"WHERE N.USER_ID = ? " +
			"AND T.THREAD_ID = ?";
	
	private static final String THREAD_ID_LIST =
			"SELECT * FROM THREAD";
	
	private static final String THREAD_ID_LIST_ST =
			"SELECT DISCTINT T.THREAD_ID, T.THREAD_TITLE, T.CREATION_DATE " +
			"FROM THREAD T " +
					"JOIN THREAD_NOTE TN ON TN.THREAD_ID = T.THREAD_ID " +
					"JOIN NOTE N ON N.NOTE_ID = TN.NOTE_ID " +
			"WHERE N.USER_ID = ?";
	
	private Profile profile;
	Integer userId;
	private BusinessNoteDAO businessDao;
	
	
	public ThreadDAOImpl(Connection connection, HttpSession session) {
    	super(connection, session);
    	businessDao = new BusinessNoteDAOImpl(connection, session);
    	userId = (Integer) getSession().getAttribute("userId");
		profile = (Profile) getSession().getAttribute("profile");
    }
    
	@Override
	public int insert(Object o){
		
		int threadId = -1;
		
		ThreadVO thread = (ThreadVO) o;
		DDBBThread ddbbThread = thread.getPersistenceObject();
		try {
			threadId = ddbbThread.insert(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return threadId;
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
	public List<ThreadVO> getThreadsList() {
		
		String SQL = null;
		
		if(Profile.MANAGER.equals(profile)) {
			SQL = MANAGER_LIST;
		} else if (Profile.SALES_TEAM.equals(profile)) {
			SQL = SALES_TEAM_LIST;
		}
		
		List<ThreadVO> threadsList = getThreadsIdList();
		List<BusinessNoteVO> notesList;
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement(SQL);
			for(ThreadVO eachThread : threadsList) {
				int p = 1;
				if(Profile.SALES_TEAM.equals(profile)) {
					statement.setInt(p, userId);
					p++;
				}
				statement.setInt(p, eachThread.getThreadId());
				p++;
				resultSet = statement.executeQuery();
				notesList = businessDao.getBusinessNotesListFromRs(resultSet);
				eachThread.setNotesList(notesList);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getCause().toString());
			System.out.println(e.getClass().toString());
			System.out.println(e.getMessage());
		} finally {
			closeStmtAndRs(statement, resultSet);
		}
		return threadsList;
	}

	private List<ThreadVO> getThreadsIdList() {
		
		String SQL = null;
		
		if(Profile.MANAGER.equals(profile)) {
			SQL = THREAD_ID_LIST;
		} else if (Profile.SALES_TEAM.equals(profile)) {
			SQL = THREAD_ID_LIST_ST;
		}
		
		List<ThreadVO> list = new ArrayList<ThreadVO>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
			try {
				statement = connection.prepareStatement(SQL);
				int p = 1;
				if(Profile.SALES_TEAM.equals(profile)) {
					statement.setInt(p, userId);
					p++;
				}
				resultSet = statement.executeQuery();
				
				ThreadVO thread;
				while (resultSet.next()) {
					thread = new ThreadVO();
					thread.setThreadId(resultSet.getInt("THREAD_ID"));
					thread.setThreadTitle(resultSet.getString("THREAD_TITLE"));
					thread.setCreationDate(resultSet.getDate("CREATION_DATE"));
					list.add(thread);
				}		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return list;
	}
	

}
