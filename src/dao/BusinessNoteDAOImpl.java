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
import model.CustomerVO;
import model.NoteVO;
import model.ProductVO;
import model.Profile;
import model.SupplierVO;
import persistence.DDBBBusinessNote;
import persistence.DDBBNote;
import utils.DateUtils;

public class BusinessNoteDAOImpl extends DAOImpl implements BusinessNoteDAO {
	
	private static final int LAST_NOTES_DAYS = -30;
	private static final String MANAGER_NOTES_LIST = 
			"select * from note "
					+ "join business_note busNote on note.note_id = busNote.note_id "
		//	+ "where creation_date <= ?"
					;
	
	private static final String SALES_TEAM_NOTES_LIST = 
			"select * from note "
					+ "join business_note busNote on note.note_id = busNote.note_id "
		//	+ "where creation_date <= ? and "
			+ "where user_id = ?";
	
	private SupplierVO supplier;
	private CustomerVO customer;
	private ProductVO product;
	
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
		String sql = null;
		java.sql.Date date = DateUtils.getSqlDate(
				DateUtils.getDateMinusXDays(LAST_NOTES_DAYS));
		
		Integer userId = (Integer) getSession().getAttribute("userId");
		
		Profile profile = (Profile) getSession().getAttribute("profile");
		if(Profile.MANAGER.equals(profile)) {
			sql = MANAGER_NOTES_LIST;
		} else if (Profile.SALES_TEAM.equals(profile)) {
			sql = SALES_TEAM_NOTES_LIST;
			
		}
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement(sql);
			int p = 1;
//			statement.setDate(p, date);
//			p++;
			if(Profile.SALES_TEAM.equals(profile)) {
				statement.setInt(p, userId);
				p++;
			}
			resultSet = statement.executeQuery();
			BusinessNoteVO businessNote;
			DDBBBusinessNote ddbbBusinessNote;
			while (resultSet.next()) {
				ddbbBusinessNote = new DDBBBusinessNote();
				DDBBNote ddbbNote = new DDBBNote();
				
				ddbbNote.loadResult(resultSet);
				ddbbBusinessNote.loadResult(resultSet);
				businessNote = new BusinessNoteVO(ddbbNote, ddbbBusinessNote);
				
				CustomerVO customer = null;
				SupplierVO supplier = null;
				ProductVO product = null;
				if(!ddbbBusinessNote.isCustomerIdNull()) {
					customer = customerDao.getCustomerById(
							ddbbBusinessNote.getCustomerId());
				} 
				if(!ddbbBusinessNote.isSupplierIdNull()) {
					supplier = supplierDao.getSupplierById(
							ddbbBusinessNote.getSupplierId());
				}
				if(!ddbbBusinessNote.isProductIdNull()) {
					product = productDao.getProductById(
							ddbbBusinessNote.getProductId());
				}
								
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

		for(NoteVO eachNote : notesList) {
			insert(eachNote);
		}
	}

}
