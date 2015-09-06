package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import persistence.DDBBBusinessNote;
import persistence.DDBBNote;
import persistence.DDBBPersonalNote;
import utils.DateUtils;
import model.BusinessNoteVO;
import model.CustomerVO;
import model.NoteVO;
import model.PersonalNoteVO;
import model.ProductVO;
import model.SupplierVO;

public class PersonalNoteDAOImpl extends DaoImpl implements PersonalNoteDAO {
	
	private static final int LAST_NOTES_DAYS = -30;
	
	private NoteDAO noteDao;
    
    public PersonalNoteDAOImpl(Connection connection, HttpSession session) {
    	super(connection, session);
    	noteDao = new NoteDAOImpl(connection, session);
    }
	@Override
	public int insert(Object o){
		
		int noteId = noteDao.insert(o);
		PersonalNoteVO personalNote = (PersonalNoteVO) o;
		personalNote.setNoteId(noteId);
		DDBBPersonalNote ddbbNote = personalNote.getPersistencePersNote();
		try {
			ddbbNote.insert(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noteId;
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
	public List<PersonalNoteVO> getLastPersonalNotes() {
		
		List<PersonalNoteVO> list = new ArrayList<PersonalNoteVO>();
		
		Date date = DateUtils.getDateMinusXDays(LAST_NOTES_DAYS);
		String sql = "select * from note "
				+ "join personal_note perNote on note.note_id = perNote.note_id "
				+ "where create_date <= '%"
				+ date
				+ "%'"
				;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			PersonalNoteVO personalNote;
			DDBBPersonalNote ddbbPersonalNote;
			while (resultSet.next()) {
				personalNote = new PersonalNoteVO();
				ddbbPersonalNote = new DDBBPersonalNote();
				
				ddbbPersonalNote.loadResult(resultSet);
				personalNote.setFromPersistenceNote(ddbbPersonalNote);
				
				list.add(personalNote);
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
			
		return list;
	}
	@Override
	public List<DDBBPersonalNote> getPersistenceCustomerList() {
		
		List<DDBBPersonalNote> list = new ArrayList<DDBBPersonalNote>();
		
		String sql = "select * from note";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				DDBBPersonalNote perNote = new DDBBPersonalNote();
				
				perNote.setNoteId(resultSet.getInt("note_id"));
				perNote.setRemainderDate(resultSet.getDate("remainder_date"));
				list.add(perNote);
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
			
		return list;
	}
	@Override
	public void insertList(List<NoteVO> notesList) {

		for(NoteVO eachNote : notesList) {
			insert(eachNote);
		}
	}

}
