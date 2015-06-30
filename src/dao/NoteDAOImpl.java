package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import utils.DateUtils;
import model.Customer;
import model.Note;
import model.Product;
import model.Supplier;

public class NoteDAOImpl extends DaoImpl implements NoteDAO {
	
	private static final int LAST_NOTES_DAYS = -30;
	private static final String INSERT = "insert into note (customer_id, supplier_id, product_id, " +
			" creation_date, note_title, note_text) values (?,?,?,?,?,?)";
	private CustomerDAO customerDao;
    private SupplierDAO supplierDao;
    private ProductDAO productDao;
    
    public NoteDAOImpl() {
    	customerDao = new CustomerDAOImpl();
    	supplierDao = new SupplierDAOImpl();
    	productDao = new ProductDAOImpl();
    }
	@Override
	public void insert(Object o){
		Note note = (Note) o;
		int customerId = note.getCustomer().getId();
		int supplierId = note.getSupplier().getId();
		int productId = note.getProduct().getId();
		java.sql.Date creationDate = new java.sql.Date(note.getNoteDate().getTime());
		String noteTitle = note.getNoteTitle();
		String noteText = note.getNoteText();
		
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = getConnection();
			ps = connection.prepareStatement(INSERT);
			ps.setInt(1, customerId);
			ps.setInt(2, supplierId);
			ps.setInt(3, productId);
			ps.setDate(4, creationDate);
			ps.setString(5, noteTitle);
			ps.setString(6, noteText);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			closeTwoConnection(connection, ps);
		}
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
		
		Date date = DateUtils.getDateMinusXDays(LAST_NOTES_DAYS);
		String sql = "select * from note"
				//+ " where create_date <= '%"
				//+ date
				//+ "%'"
				;
		
		Connection connection = null;
		try {
			
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Note note = new Note();
				int idCustomer = resultSet.getInt("customer_id");
				Customer customer = customerDao.getCustomerById(
						idCustomer);
				Supplier supplier = supplierDao.getSupplierById(
						resultSet.getInt("supplier_id"));
				Product product = productDao.getProductById(
						resultSet.getInt("product_id"));
								
				note.setId(resultSet.getInt("id"));
				note.setCustomer(customer);
				note.setSupplier(supplier);
				note.setProduct(product);
				note.setNoteDate(resultSet.getDate("creation_date"));
				note.setNoteTitle(resultSet.getString("note_title"));				
				note.setNoteText(resultSet.getString("note_text"));
				result.add(note);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getCause().toString());
			System.out.println(e.getClass().toString());
			System.out.println(e.getMessage());
		} finally {
			closeConnection(connection);
		}
			
		return result;
	}

}
