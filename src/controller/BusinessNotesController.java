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

import model.Company;
import model.Customer;
import model.Note;
import model.Product;
import model.Supplier;
import dao.CompanyDAO;
import dao.CompanyDAOImpl;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import dao.NoteDAO;
import dao.NoteDAOImpl;
import dao.ProductDAO;
import dao.ProductDAOImpl;
import dao.SubMenuDAO;
import dao.SubMenuDAOImpl;
import dao.SupplierDAO;
import dao.SupplierDAOImpl;

public class BusinessNotesController extends HttpServlet {
	
	private static final String BASE = "/jsp/";
	private String url;
	
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		SubMenuDAO subMenuDao = new SubMenuDAOImpl();
		Map<String, List<String>> subMenusList = subMenuDao.getSubMenus();
		ServletContext context = config.getServletContext();
		context.setAttribute("subMenusList", subMenusList);
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String keyWord = request.getParameter("keyWord");
		RequestDispatcher requestDispatcher;
		if (action == null) {
			action = "homePage";
		}
		
		switch(action) {
		case "homePage":
		case "newNote":
			showNewNoteForm(request, response);
			url = BASE + "newNoteForm.jsp?";
			requestDispatcher = getServletContext().
					getRequestDispatcher(url);
			requestDispatcher.forward(request, response);
			break;
		case "notesList":
			getNotesList(request, response);
			url = BASE + "notesList.jsp";
			requestDispatcher = getServletContext().
					getRequestDispatcher(url);
			requestDispatcher.forward(request, response);
			break;
		case "newCustomer":
			showNewCustomerForm(request, response);
			url = BASE + "newCustomer.jsp";
			requestDispatcher = getServletContext().
					getRequestDispatcher(url);
			requestDispatcher.forward(request, response);
			break;
		case "customersList":
			getCustomersList(request, response);
			url = BASE + "customersList.jsp";
			requestDispatcher = getServletContext().
					getRequestDispatcher(url);
			requestDispatcher.forward(request, response);
			break;
		case "newSupplier":
			showNewSupplierForm(request, response);
			url = BASE + "newSupplier.jsp";
			requestDispatcher = getServletContext().
					getRequestDispatcher(url);
			requestDispatcher.forward(request, response);
			break;
		case "suppliersList":
			getSuppliersList(request, response);
			url = BASE + "suppliersList.jsp";
			requestDispatcher = getServletContext().
					getRequestDispatcher(url);
			requestDispatcher.forward(request, response);
			break;
		case "newProduct":
			url = BASE + "newProduct.jsp";
			requestDispatcher = getServletContext().
					getRequestDispatcher(url);
			requestDispatcher.forward(request, response);
			break;
		case "productsList":
			getProductsList(request, response);
			url = BASE + "productsList.jsp";
			requestDispatcher = getServletContext().
					getRequestDispatcher(url);
			requestDispatcher.forward(request, response);
			break;
		case "newCompany":
			showNewCompanyForm(request, response);
			url = BASE + "newCompany.jsp";
			requestDispatcher = getServletContext().
					getRequestDispatcher(url);
			requestDispatcher.forward(request, response);
			break;
		case "companiesList":
			getCompaniesList(request, response);
			url = BASE + "companiesList.jsp";
			requestDispatcher = getServletContext().
					getRequestDispatcher(url);
			requestDispatcher.forward(request, response);
			break;
		case "createCustomer":
			createCustomer(request, response);
			response.sendRedirect("notes?action=newCustomer");
			break;
		case "createSupplier":
			createSupplier(request, response);
			response.sendRedirect("notes?action=newSupplier");
			break;
		case "createProduct":
			createProduct(request, response);
			response.sendRedirect("notes?action=newProduct");
			break;
		case "createCompany":
			createCompany(request, response);
			url = BASE + "newCompany.jsp";
			requestDispatcher = getServletContext().
					getRequestDispatcher(url);
			requestDispatcher.forward(request, response);
			break;
		case "createNote":
			createNote(request, response);
			response.sendRedirect("notes?action=newNote");
			break;
		case "onlyCreateCompany":
			createCompany(request, response);
			response.sendRedirect("notes?action=newSupplier");
			break;
		case "onlyCreateCompany2":
			createCompany(request, response);
			response.sendRedirect("notes?action=newCustomer");
			break;
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
	
	private void showNewNoteForm(HttpServletRequest request,
			HttpServletResponse response) {
		
		getCustomersList(request, response);
		getSuppliersList(request, response);
		getProductsList(request, response);
	}

	private void createNote(HttpServletRequest request,
			HttpServletResponse response) {
		
		Note note = new Note();
		Customer customer;
		Supplier supplier;
		Product product;
		
		NoteDAO noteDao = new NoteDAOImpl();
		CustomerDAO customerDao = new CustomerDAOImpl();
		SupplierDAO supplierDao = new SupplierDAOImpl();
		ProductDAO productDao = new ProductDAOImpl();
		
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
		CompanyDAO companyDao = new CompanyDAOImpl();
		company.setCompanyName((String) request.getParameter("companyName"));
		company.setCompanyTelephone((String) request.getParameter("companyTelephone"));
		company.setCompanyEmail((String) request.getParameter("companyEmail"));
		
		companyDao.insert(company);
			
	}

	private void createProduct(HttpServletRequest request,
			HttpServletResponse response) {

		Product product = new Product();
		ProductDAO productDao = new ProductDAOImpl();
		product.setProductCode((String) request.getParameter("productCode"));
		product.setProductDescription((String) request.getParameter("productDescription"));
		
		productDao.insert(product);	
	}

	private void createSupplier(HttpServletRequest request,
			HttpServletResponse response) {
		
		Supplier supplier = new Supplier();
		CompanyDAO companyDao = new CompanyDAOImpl();
		SupplierDAO supplierDao = new SupplierDAOImpl();
		Company company = companyDao.getCompanyById(Integer.parseInt(request.getParameter("companyId")));
		supplier.setCompany(company);
		supplier.setContactName((String) request.getParameter("contactName"));
		supplier.setContactTelephone((String) request.getParameter("contactTelephone"));
		
		supplierDao.insert(supplier);
		
	}

	private void createCustomer(HttpServletRequest request,
			HttpServletResponse response) {
		
		Customer customer = new Customer();
		CompanyDAO companyDao = new CompanyDAOImpl();
		CustomerDAO customerDao = new CustomerDAOImpl();
		Company company = companyDao.getCompanyById(Integer.parseInt(request.getParameter("companyId")));
		customer.setCompany(company);
		customer.setContactName((String) request.getParameter("contactName"));
		customer.setContactTelephone((String) request.getParameter("contactTelephone"));
		
		customerDao.insert(customer);
		
	}

	private void getCompaniesList(HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			CompanyDAO companyDao = new CompanyDAOImpl();
			List<Company> companiesList = companyDao.getCompaniesList();
			request.setAttribute("companiesList", companiesList);
		} catch (Exception e) {
			System.out.println(e);
		}
			
	}
	
	private void getNoCustomerCompanies(HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			CompanyDAO companyDao = new CompanyDAOImpl();
			List<Company> companiesList = companyDao.getNoCustomerCompanies();
			request.setAttribute("companiesList", companiesList);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	private void getNoSupplierCompanies(HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			CompanyDAO companyDao = new CompanyDAOImpl();
			List<Company> companiesList = companyDao.getNoSupplierCompanies();
			request.setAttribute("companiesList", companiesList);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	private void getProductsList(HttpServletRequest request,
			HttpServletResponse response) {

		try {
			ProductDAO productDao = new ProductDAOImpl();
			List<Product> productsList = productDao.getProductsList();
			request.setAttribute("productsList", productsList);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	private void getSuppliersList(HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			SupplierDAO supplierDao = new SupplierDAOImpl();
			List<Supplier> suppliersList = supplierDao.getSuppliersList();
			request.setAttribute("suppliersList", suppliersList);
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}

	private void getCustomersList(HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			CustomerDAO customerDao = new CustomerDAOImpl();
			List<Customer> customersList = customerDao.getCustomersList();
			request.setAttribute("customersList", customersList);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	private void getNotesList(HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			NoteDAO noteDao = new NoteDAOImpl();
			List<Note> notesList = noteDao.getLastNotes();
			request.setAttribute("notesList", notesList);
		} catch (Exception e) {
			System.out.println(e);
		}		
	}

	private void lastNotes(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			NoteDAO noteDao = new NoteDAOImpl();
			List<Note> notesList = noteDao.getLastNotes();
			request.setAttribute("notesList", notesList);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void searchCompanies(HttpServletRequest request,
			HttpServletResponse response, String keyWord) {
		try {
			CompanyDAO companyDao = new CompanyDAOImpl();
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
