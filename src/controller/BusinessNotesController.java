package controller;

import java.io.IOException;
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
		String base = "/jsp/";
		String url = base + "newNoteForm.jsp"; //"newNoteForm.jsp"; "navBar.jsp"; / "newNoteHome2.jsp"; / home.jsp
		String action = request.getParameter("action");
		String keyWord = request.getParameter("keyWord");
		if (action != null) {
			switch(action) {
			case "notesList":
				getNotesList(request, response);
				url = base + "notesList.jsp";
				break;
			case "newCustomer":
				showNewCustomerForm(request, response);
				url = base + "newCustomer.jsp?";
				break;
			case "customersList":
				getCustomersList(request, response, keyWord);
				url = base + "customersList.jsp";
				break;
			case "newSupplier":
				showNewSupplierForm(request, response, keyWord);
				url = base + "newSupplier.jsp";
				break;
			case "supplierList":
				getSuppliersList(request, response, keyWord);
				url = base + "suppliersList.jsp";
				break;
			case "newProduct":
				showNewProductForm(request, response, keyWord);
				url = base + "newProduct.jsp";
				break;
			case "productsList":
				getProductsList(request, response, keyWord);
				url = base + "productsList.jsp";
				break;
			case "newCompany":
				showNewCompanyForm(request, response, keyWord);
				url = base + "newCompany.jsp";
				break;
			case "companiesList":
				getCompaniesList(request, response, keyWord);
				url = base + "companiesList.jsp";
				break;
			}
		}
		RequestDispatcher requestDispatcher = getServletContext().
				getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
	}

	private void getCompaniesList(HttpServletRequest request,
			HttpServletResponse response, String keyWord) {
		
		try {
			CompanyDAO companyDao = new CompanyDAOImpl();
			List<Company> companiesList = companyDao.getCompaniesList();
			request.setAttribute("companiesList", companiesList);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	private void showNewCompanyForm(HttpServletRequest request,
			HttpServletResponse response, String keyWord) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/jsp/newCompany.jsp")
        .forward(request, response);
		
	}

	private void getProductsList(HttpServletRequest request,
			HttpServletResponse response, String keyWord) {

		try {
			ProductDAO productDao = new ProductDAOImpl();
			List<Product> productsList = productDao.getProductsList();
			request.setAttribute("productsList", productsList);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	private void showNewProductForm(HttpServletRequest request,
			HttpServletResponse response, String keyWord) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/jsp/newProduct.jsp")
        .forward(request, response);
		
	}

	private void getSuppliersList(HttpServletRequest request,
			HttpServletResponse response, String keyWord) {
		
		try {
			SupplierDAO supplierDao = new SupplierDAOImpl();
			List<Supplier> suppliesList = supplierDao.getSuppliesList();
			request.setAttribute("suppliesList", suppliesList);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	private void showNewSupplierForm(HttpServletRequest request,
			HttpServletResponse response, String keyWord) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/jsp/newSupplier.jsp")
        .forward(request, response);
		
	}

	private void getCustomersList(HttpServletRequest request,
			HttpServletResponse response, String keyWord) {
		
		try {
			CustomerDAO customerDao = new CustomerDAOImpl();
			List<Customer> customersList = customerDao.getCustomersList();
			request.setAttribute("customersList", customersList);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	private void showNewCustomerForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/jsp/newCustomer.jsp")
        .forward(request, response);
		
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
