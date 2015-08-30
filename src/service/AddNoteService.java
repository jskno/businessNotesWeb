package service;

import java.sql.SQLException;
import java.util.Date;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import dao.NoteDAO;
import dao.NoteDAOImpl;
import dao.ProductDAO;
import dao.ProductDAOImpl;
import dao.SupplierDAO;
import dao.SupplierDAOImpl;
import model.Customer;
import model.Note;
import model.ProductVO;
import model.Supplier;

public class AddNoteService extends ServiceImpl implements Service {

	@Override
	protected void execute() {

		createNote();
		request.setAttribute("newAction", "newNote");
	}
	
	private void createNote() {
		
		Note note = new Note();
		Customer customer;
		Supplier supplier;
		ProductVO product;
		
		NoteDAO noteDao = null;
		CustomerDAO customerDao = null;
		SupplierDAO supplierDao = null;
		ProductDAO productDao = null;
		
		try {
			noteDao = new NoteDAOImpl(getConnection(), getSession());
			customerDao = new CustomerDAOImpl(getConnection(), getSession());
			supplierDao = new SupplierDAOImpl(getConnection(), getSession());
			productDao = new ProductDAOImpl(getConnection(), getSession());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		customer = customerDao.getCustomerById(Integer.parseInt(request.getParameter("customerId")));
		supplier = supplierDao.getSupplierById(Integer.parseInt(request.getParameter("supplierId")));
		product = productDao.getProductById(Integer.parseInt(request.getParameter("productId")));
		
		note.setCustomer(customer);
		note.setSupplier(supplier);
		note.setProduct(product);
		note.setNoteDate((new Date()));
		note.setNoteTitle((String) request.getParameter("noteTitle"));
		note.setNoteText((String) request.getParameter("noteText"));
		
		noteDao.insert(note);
		
		
		
	}

}
