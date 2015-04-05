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
						idCustomer, connection);
				Supplier supplier = supplierDao.getSupplierById(
						resultSet.getInt("supplier_id"), connection);
				Product product = productDao.getProductById(
						resultSet.getInt("product_id"), connection);
								
				note.setId(resultSet.getInt("id"));
				note.setCustomer(customer);
				note.setSupplier(supplier);
				note.setProduct(product);
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
