package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;
import utils.DBUtil;
import model.Company;
import model.Customer;
import model.Menu;
import model.Note;
import model.ProductVO;
import model.Supplier;
import dao.CompanyDAO;
import dao.CompanyDAOImpl;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import dao.NoteDAO;
import dao.NoteDAOImpl;
import dao.ProductDAO;
import dao.ProductDAOImpl;
import dao.MenuDAO;
import dao.MenuDAOImpl;
import dao.SupplierDAO;
import dao.SupplierDAOImpl;
import excelUtils.ExportTable;
import excelUtils.ImportTable;

public class BusinessNotesController extends HttpServlet {
	
	private static final String BASE = "/jsp/";
	private String url;
	private Service service;
	private BusinessLookUp lookupService = new BusinessLookUp();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		MenuDAO menuDao = new MenuDAOImpl(DBUtil.getConnection(), null);
		Map<Integer, Menu> theMenu = menuDao.getMenu();
		ServletContext context = config.getServletContext();
		context.setAttribute("theMenu", theMenu);
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String nextStep = request.getParameter("nextStep");
		String keyWord = request.getParameter("keyWord");
		RequestDispatcher requestDispatcher;
		if (nextStep == null) {
			nextStep = "homePage";
		}
		service = lookupService.getBusinessService(nextStep);
		service.execute(request, response);
		
		url = BASE + request.getAttribute("url");
		requestDispatcher = getServletContext().
				getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
		
		// From here it's over.
		
		switch(nextStep) {
//		case "homePage":
//		case "newNote":
//			
//			showNewNoteForm(request, response);
//			url = BASE + "newNoteForm.jsp?";
//			requestDispatcher = getServletContext().
//					getRequestDispatcher(url);
//			requestDispatcher.forward(request, response);
//			break;
//		case "notesList":
//			getNotesList(request, response);
//			url = BASE + "notesList.jsp";
//			requestDispatcher = getServletContext().
//					getRequestDispatcher(url);
//			requestDispatcher.forward(request, response);
//			break;
//		case "newCustomer":
//			showNewCustomerForm(request, response);
//			url = BASE + "newCustomer.jsp";
//			requestDispatcher = getServletContext().
//					getRequestDispatcher(url);
//			requestDispatcher.forward(request, response);
//			break;
//		case "customersList":
//			getCustomersList(request, response);
//			url = BASE + "customersList.jsp";
//			requestDispatcher = getServletContext().
//					getRequestDispatcher(url);
//			requestDispatcher.forward(request, response);
//			break;
//		case "newSupplier":
//			showNewSupplierForm(request, response);
//			url = BASE + "newSupplier.jsp";
//			requestDispatcher = getServletContext().
//					getRequestDispatcher(url);
//			requestDispatcher.forward(request, response);
//			break;
//		case "suppliersList":
//			//getSuppliersList(request, response);
//			url = BASE + "suppliersList.jsp";
//			requestDispatcher = getServletContext().
//					getRequestDispatcher(url);
//			requestDispatcher.forward(request, response);
//			break;
//		case "newProduct":
//			url = BASE + "newProduct.jsp";
//			requestDispatcher = getServletContext().
//					getRequestDispatcher(url);
//			requestDispatcher.forward(request, response);
//			break;
//		case "productsList":
//			//getProductsList(request, response);
//			url = BASE + "productsList.jsp";
//			requestDispatcher = getServletContext().
//					getRequestDispatcher(url);
//			requestDispatcher.forward(request, response);
//			break;
//		case "newCompany":
//			showNewCompanyForm(request, response);
//			url = BASE + "newCompany.jsp";
//			requestDispatcher = getServletContext().
//					getRequestDispatcher(url);
//			requestDispatcher.forward(request, response);
//			break;
//		case "companiesList":
//			getCompaniesList(request, response);
//			url = BASE + "companiesList.jsp";
//			requestDispatcher = getServletContext().
//					getRequestDispatcher(url);
//			requestDispatcher.forward(request, response);
//			break;
//		case "addCustomer":
//			createCustomer(request, response);
//			response.sendRedirect("notes?action=newCustomer");
//			break;
//		case "addSupplier":
//			createSupplier(request, response);
//			response.sendRedirect("notes?action=newSupplier");
//			break;
//		case "addProduct":
//			createProduct(request, response);
//			response.sendRedirect("notes?action=newProduct");
//			break;
//		case "addCompany":
//			createCompany(request, response);
//			url = BASE + "newCompany.jsp";
//			requestDispatcher = getServletContext().
//					getRequestDispatcher(url);
//			requestDispatcher.forward(request, response);
//			break;
//		case "addNote":
//			createNote(request, response);
//			response.sendRedirect("notes?action=newNote");
//			break;
		case "onlyCreateCompany":
			createCompany(request, response);
			response.sendRedirect("notes?action=newSupplier");
			break;
		case "onlyCreateCompany2":
			createCompany(request, response);
			response.sendRedirect("notes?action=newCustomer");
			break;
//		case "exportTable":
//			exportTable(request, response);
//			url = 	BASE + "exportSuccessModal.jsp";
//			requestDispatcher = getServletContext().
//					getRequestDispatcher(url);
//			requestDispatcher.forward(request, response);
//			break;
//		case "importTable":
//			importTable(request, response);
//			url = BASE + "importSuccessModal.jsp";
//			requestDispatcher = getServletContext().
//					getRequestDispatcher(url);
//			requestDispatcher.forward(request, response);
//			break;
		}
	}

	private void importTable(HttpServletRequest request,
			HttpServletResponse response) {

		String table = request.getParameter("tableName");
		String file = request.getParameter("myFile");
		try {
			
			switch (table) {
			case "company":
				ImportTable.importCompanyTable(file);
				break;
			case "customer":
				ImportTable.importCustomerTable(file);
				break;
			case "supplier":
				ImportTable.importSupplierTable(file);		
				break;
			case "product":
				ImportTable.importProductTable(file);
				break;
			case "note":
				ImportTable.importNoteTable(file);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void exportTable(HttpServletRequest request,
			HttpServletResponse response) {
		
		String table = request.getParameter("tableName");
		String fileName = request.getParameter("fileName");
		
		try {
			
			switch (table) {
			case "company":
				ExportTable.exportCompanyTable(fileName);
				break;
			case "customer":
				ExportTable.exportCustomerTable(fileName);
				break;
			case "supplier":
				ExportTable.exportSupplierTable(fileName);		
				break;
			case "product":
				ExportTable.exportProductTable(fileName);
				break;
			case "note":
				ExportTable.exportNoteTable(fileName);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private void showNewCompanyForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
//		url = BASE + "newCompany.jsp";
//		RequestDispatcher requestDispatcher = getServletContext().
//				getRequestDispatcher(url);
//		requestDispatcher.forward(request, response);
		
	}

	private void showNewSupplierForm(HttpServletRequest request,
			HttpServletResponse response) {
		
		getNoSupplierCompanies(request, response);
		
	}
	
	private void showNewCustomerForm(HttpServletRequest request,
			HttpServletResponse response) {
		
		getNoCustomerCompanies(request, response);
		
	}
	
	private void createNote(HttpServletRequest request,
			HttpServletResponse response) {
		
		Note note = new Note();
		Customer customer;
		Supplier supplier;
		ProductVO product;
		
		NoteDAO noteDao = new NoteDAOImpl(null, null);
		CustomerDAO customerDao = new CustomerDAOImpl(null, null);
		SupplierDAO supplierDao = new SupplierDAOImpl(null, null);
		ProductDAO productDao = new ProductDAOImpl(null, null);
		
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

	private void createCompany(HttpServletRequest request,
			HttpServletResponse response) {
		
		Company company = new Company();
		CompanyDAO companyDao = new CompanyDAOImpl(null, null);
		company.setCompanyName((String) request.getParameter("companyName"));
		company.setCompanyTelephone((String) request.getParameter("companyTelephone"));
		company.setCompanyEmail((String) request.getParameter("companyEmail"));
		
		companyDao.insert(company);
			
	}

	private void createProduct(HttpServletRequest request,
			HttpServletResponse response) {

		ProductVO product = new ProductVO();
		ProductDAO productDao = new ProductDAOImpl(null, null);
		product.setProductCode((String) request.getParameter("productCode"));
		product.setProductDescription((String) request.getParameter("productDescription"));
		
		productDao.insert(product);	
	}

	private void createSupplier(HttpServletRequest request,
			HttpServletResponse response) {
		
		Supplier supplier = new Supplier();
		CompanyDAO companyDao = new CompanyDAOImpl(null, null);
		SupplierDAO supplierDao = new SupplierDAOImpl(null, null);
		Company company = companyDao.getCompanyById(Integer.parseInt(request.getParameter("companyId")));
		supplier.setCompany(company);
		supplier.setContactName((String) request.getParameter("contactName"));
		supplier.setContactTelephone((String) request.getParameter("contactTelephone"));
		
		supplierDao.insert(supplier);
		
	}

	private void createCustomer(HttpServletRequest request,
			HttpServletResponse response) {
		
		Customer customer = new Customer();
		CompanyDAO companyDao = new CompanyDAOImpl(null, null);
		CustomerDAO customerDao = new CustomerDAOImpl(null, null);
		Company company = companyDao.getCompanyById(Integer.parseInt(request.getParameter("companyId")));
		customer.setCompany(company);
		customer.setContactName((String) request.getParameter("contactName"));
		customer.setContactTelephone((String) request.getParameter("contactTelephone"));
		
		customerDao.insert(customer);
		
	}

	private void getCompaniesList(HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			CompanyDAO companyDao = new CompanyDAOImpl(null, null);
			List<Company> companiesList = companyDao.getCompaniesList();
			request.setAttribute("companiesList", companiesList);
		} catch (Exception e) {
			System.out.println(e);
		}
			
	}
	
	private void getNoCustomerCompanies(HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			CompanyDAO companyDao = new CompanyDAOImpl(null, null);
			List<Company> companiesList = companyDao.getNoCustomerCompanies();
			request.setAttribute("companiesList", companiesList);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	private void getNoSupplierCompanies(HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			CompanyDAO companyDao = new CompanyDAOImpl(null, null);
			List<Company> companiesList = companyDao.getNoSupplierCompanies();
			request.setAttribute("companiesList", companiesList);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	private void getNotesList(HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			NoteDAO noteDao = new NoteDAOImpl(null, null);
			List<Note> notesList = noteDao.getLastNotes();
			request.setAttribute("notesList", notesList);
		} catch (Exception e) {
			System.out.println(e);
		}		
	}

	private void lastNotes(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			NoteDAO noteDao = new NoteDAOImpl(null, null);
			List<Note> notesList = noteDao.getLastNotes();
			request.setAttribute("notesList", notesList);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void searchCompanies(HttpServletRequest request,
			HttpServletResponse response, String keyWord) {
		try {
			CompanyDAO companyDao = new CompanyDAOImpl(null, null);
			List<Company> companiesList = companyDao.searchCompaniesByName(keyWord);
			request.setAttribute("companiesList", companiesList);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
		
	public String executeLogin() {
		String executelogin = "failed";
		return null;
	}

}
