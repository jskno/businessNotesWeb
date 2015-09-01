package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import persistence.DDBBNote;
import utils.DateUtils;
import model.Customer;
import model.Note;
import model.ProductVO;
import model.Supplier;

public class NoteDAOImpl extends DaoImpl implements NoteDAO {
	
	private static final int LAST_NOTES_DAYS = -30;
	private static final String INSERT = "insert into note (USER_ID, CREATION_DATE, " +
			"NOTE_TITLE, NOTE_TEXT) values (?,?,?,?)";
	private static final String LAST_ID = "SELECT LAST_INSERT_ID()";
			
	public NoteDAOImpl(Connection connection, HttpSession session) {
    	super(connection, session);
    }
    
	@Override
	public int insert(Object o){
		Note note = (Note) o;
		DDBBNote ddbbNote = note.getPersistenceObject();
		int newNoteId = -1;
		try {
			newNoteId = ddbbNote.insert(connection);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return newNoteId;
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
	public List<Note> getLastNotes() {
		
		List<Note> result = new ArrayList<Note>();
//		
//		Date date = new Date(DateUtils.getDateMinusXDays(LAST_NOTES_DAYS).getTime());
//		String sql = "select * from note" + " where CREATION_DATE <= '%"
//				+ date + "%'";
//		
//		PreparedStatement statement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			statement = connection.prepareStatement(sql);
//			resultSet = statement.executeQuery();
//			while (resultSet.next()) {
//				Note note = new Note();
//				int idCustomer = resultSet.getInt("customer_id");
//				Customer customer = customerDao.getCustomerById(
//						idCustomer);
//				Supplier supplier = supplierDao.getSupplierById(
//						resultSet.getInt("supplier_id"));
//				ProductVO product = productDao.getProductById(
//						resultSet.getInt("product_id"));
//								
//				note.setId(resultSet.getInt("id"));
//				note.setCustomer(customer);
//				note.setSupplier(supplier);
//				note.setProduct(product);
//				note.setNoteDate(resultSet.getDate("creation_date"));
//				note.setNoteTitle(resultSet.getString("note_title"));				
//				note.setNoteText(resultSet.getString("note_text"));
//				result.add(note);
//			}
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println(e.getCause().toString());
//			System.out.println(e.getClass().toString());
//			System.out.println(e.getMessage());
//		} finally {
//			closeStmtAndRs(statement, resultSet);
//		}
//			
		return result;
	}
		
	@Override
	public List<DDBBNote> getPersistenceCustomerList() {
		
		List<DDBBNote> result = new ArrayList<DDBBNote>();
//		
//		String sql = "select * from note";
//		PreparedStatement statement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			statement = connection.prepareStatement(sql);
//			resultSet = statement.executeQuery();
//			while (resultSet.next()) {
//				DDBBNote perNote = new DDBBNote();
//				
//				perNote.setId(resultSet.getInt("id"));
//				perNote.setCustomerId(resultSet.getInt("customer_id"));
//				perNote.setSupplierId(resultSet.getInt("supplier_id"));
//				perNote.setProductId(resultSet.getInt("product_id"));
//				perNote.setNoteDate(resultSet.getDate("creation_date"));
//				perNote.setNoteTitle(resultSet.getString("note_title"));				
//				perNote.setNoteText(resultSet.getString("note_text"));
//				result.add(perNote);
//			}
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println(e.getCause().toString());
//			System.out.println(e.getClass().toString());
//			System.out.println(e.getMessage());
//		} finally {
//			closeStmtAndRs(statement, resultSet);
//		}
//			
		return result;
	}
	@Override
	public void insertList(List<Note> notesList) {

		for(Note eachNote : notesList) {
			insert(eachNote);
		}
	}

}
