package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;
import dao.MenuDAO;
import dao.MenuDAOImpl;

public class BusinessNotesControllerRedirect extends HttpServlet {
	
	private static final String BASE = "notes?action=";
	private String newAction;
	private Service service;
	private BusinessLookUp lookupService = new BusinessLookUp();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		String keyWord = request.getParameter("keyWord");
		if (action == null) {
			action = "homePage";
		}
		service = lookupService.getBusinessService(action);
		service.execute(request, response);
		
		newAction = BASE + request.getAttribute("newAction");
		response.sendRedirect(newAction);
		
		// From here it's over.
		
//		switch(action) {
//		
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
//		case "onlyCreateCompany":
//			createCompany(request, response);
//			response.sendRedirect("notes?action=newSupplier");
//			break;
//		case "onlyCreateCompany2":
//			createCompany(request, response);
//			response.sendRedirect("notes?action=newCustomer");
//			break;
//		}
	}
	
}
