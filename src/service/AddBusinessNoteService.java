package service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.BusinessNoteVO;
import model.CustomerVO;
import model.ProductVO;
import model.SupplierVO;
import model.UserVO;
import dao.BusinessNoteDAO;
import dao.BusinessNoteDAOImpl;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import dao.ProductDAO;
import dao.ProductDAOImpl;
import dao.SupplierDAO;
import dao.SupplierDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;

public class AddBusinessNoteService extends ServiceImpl implements Service {
	
	private Integer customerId;
	private Integer supplierId;
	private Integer productId;
	private Integer userId;
	private Date creationDate;
	private String noteText;
	private String noteTitle;
	
	BusinessNoteVO note;
	CustomerVO customer;
	SupplierVO supplier;
	ProductVO product;
	UserVO user;
	
	BusinessNoteDAO noteDao;
	CustomerDAO customerDao;
	SupplierDAO supplierDao;
	ProductDAO productDao;
	UserDAO userDao;

	@Override
	protected void execute() {

		instantiateDaos();
		createNote();
		request.setAttribute("nextStep", "newBusinessNoteForm");
	}
	
	private void instantiateDaos() {
		
		noteDao = new BusinessNoteDAOImpl(getConnection(), getSession());
		customerDao = new CustomerDAOImpl(getConnection(), getSession());
		supplierDao = new SupplierDAOImpl(getConnection(), getSession());
		productDao = new ProductDAOImpl(getConnection(), getSession());
		userDao = new UserDAOImpl(getConnection(), getSession());
		
	}

	private void createNote() {
		
		getObjects();		
		setAttributes();
		noteDao.insert(note);
	}
	

	private void getObjects() {
		
		if(userId != null) {
			user = userDao.getUserById(userId);
		}
		if(customerId != null) {
			customer = customerDao.getCustomerById(customerId);
		}
		if(supplierId != null) {
			supplier = supplierDao.getSupplierById(supplierId);
		}
		if(productId != null) {
			product = productDao.getProductById(productId);
		}
		note = new BusinessNoteVO();
	}

	private void setAttributes() {
		note.setCustomer(customer);
		note.setSupplier(supplier);
		note.setProduct(product);
		note.setCreationDate(creationDate);
		note.setNoteTitle(noteTitle);
		note.setNoteText(noteText);
		note.setUser(user);
		
	}
	
	@Override
	public void getDomainData(HttpServletRequest request) {
		
		String customerIdFromRq = request.getParameter("customerId");
		if(customerIdFromRq == null || customerIdFromRq.isEmpty()) {
			customerId = null;
		} else {
			customerId = Integer.parseInt(customerIdFromRq);
		}
		
		String supplierIdFromRq = request.getParameter("supplierId");
		if(supplierIdFromRq == null || supplierIdFromRq.isEmpty()) {
			supplierIdFromRq = null;
		} else {
			supplierId = Integer.parseInt(supplierIdFromRq);
		}
		
		String productIdFromRq = request.getParameter("productId");
		if(productIdFromRq == null || productIdFromRq.isEmpty()) {
			productIdFromRq = null;
		} else {
			productId = Integer.parseInt(productIdFromRq);
		}
		
		userId = (Integer) getSession().getAttribute("userId");
		noteText = request.getParameter("noteTitle");
		noteTitle = request.getParameter("noteText");
		creationDate = new Date();
		
	}

}
