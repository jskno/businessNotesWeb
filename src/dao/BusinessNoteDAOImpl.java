package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.BusinessNoteVO;
import model.Customer;
import model.Note;
import model.ProductVO;
import model.Supplier;
import persistence.DDBBBusinessNote;
import utils.DateUtils;

public class BusinessNoteDAOImpl extends DaoImpl implements BusinessNoteDAO {
	
	private static final int LAST_NOTES_DAYS = -30;
	
	private CustomerDAO customerDao;
    private SupplierDAO supplierDao;
    private ProductDAO productDao;
    private NoteDAO noteDao;
    
    public BusinessNoteDAOImpl(Connection connection, HttpSession session) {
    	super(connection, session);
    	customerDao = new CustomerDAOImpl(connection, session);
    	supplierDao = new SupplierDAOImpl(connection, session);
    	productDao = new ProductDAOImpl(connection, session);
    	noteDao = new NoteDAOImpl(connection, session);
    }
	@Override
	public int insert(Object o){
		
		int noteId = noteDao.insert(o);
		
		BusinessNoteVO businessNote = (BusinessNoteVO) o;
		businessNote.setNoteId(noteId);
		DDBBBusinessNote ddbbNote = businessNote.getPersistenceBusNote();
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
	public List<BusinessNoteVO> getLastBusinessNotes() {
		
		List<BusinessNoteVO> list = new ArrayList<BusinessNoteVO>();
		
		Date date = DateUtils.getDateMinusXDays(LAST_NOTES_DAYS);
		String sql = "select * from note "
				+ "join business_note busNote on note.note_id = busNote.note_id "
				+ "where create_date <= '%"
				+ date
				+ "%'"
				;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			BusinessNoteVO businessNote;
			DDBBBusinessNote ddbbBusinessNote;
			while (resultSet.next()) {
				businessNote = new BusinessNoteVO();
				ddbbBusinessNote = new DDBBBusinessNote();
				
				ddbbBusinessNote.loadResult(resultSet);
				businessNote.setFromPersistenceBusNote(ddbbBusinessNote);
				
				Customer customer = customerDao.getCustomerById(
						ddbbBusinessNote.getCustomerId());
				Supplier supplier = supplierDao.getSupplierById(
						ddbbBusinessNote.getSupplierId());
				ProductVO product = productDao.getProductById(
						ddbbBusinessNote.getProductId());
								
				businessNote.setCustomer(customer);
				businessNote.setSupplier(supplier);
				businessNote.setProduct(product);
				list.add(businessNote);
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
	public List<DDBBBusinessNote> getPersistenceBusinessNotesList() {
		
		List<DDBBBusinessNote> result = new ArrayList<DDBBBusinessNote>();
		
		String sql = "select * from note";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			DDBBBusinessNote ddbbBusNote;
			while (resultSet.next()) {
				ddbbBusNote = new DDBBBusinessNote();
				result.add(ddbbBusNote);
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
			
		return result;
	}
	@Override
	public void insertList(List<BusinessNoteVO> notesList) {

		for(Note eachNote : notesList) {
			insert(eachNote);
		}
	}

}
