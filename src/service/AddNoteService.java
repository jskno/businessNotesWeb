package service;

import java.util.Date;

import model.BusinessNoteVO;
import model.Customer;
import model.ProductVO;
import model.Supplier;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import dao.NoteDAO;
import dao.NoteDAOImpl;
import dao.ProductDAO;
import dao.ProductDAOImpl;
import dao.SupplierDAO;
import dao.SupplierDAOImpl;

public class AddNoteService extends ServiceImpl implements Service {

	@Override
	protected void execute() {

		createNote();
		request.setAttribute("newAction", "newNote");
	}
	
	private void createNote() {
		
		BusinessNoteVO note = new BusinessNoteVO();
		Customer customer;
		Supplier supplier;
		ProductVO product;
		
		NoteDAO noteDao = null;
		CustomerDAO customerDao = null;
		SupplierDAO supplierDao = null;
		ProductDAO productDao = null;
		
		noteDao = new NoteDAOImpl(getConnection(), getSession());
		customerDao = new CustomerDAOImpl(getConnection(), getSession());
		supplierDao = new SupplierDAOImpl(getConnection(), getSession());
		productDao = new ProductDAOImpl(getConnection(), getSession());
		
		customer = customerDao.getCustomerById(Integer.parseInt(request.getParameter("customerId")));
		supplier = supplierDao.getSupplierById(Integer.parseInt(request.getParameter("supplierId")));
		product = productDao.getProductById(Integer.parseInt(request.getParameter("productId")));
		
		note.setCustomer(customer);
		note.setSupplier(supplier);
		note.setProduct(product);
		note.setCreationDate((new Date()));
		note.setNoteTitle((String) request.getParameter("noteTitle"));
		note.setNoteText((String) request.getParameter("noteText"));
		
		noteDao.insert(note);
		
		
		
	}

}
