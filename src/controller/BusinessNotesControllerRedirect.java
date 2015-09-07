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
	
	private static final String BASE = "/notes?nextStep=";
	private String newStep;
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
		
		if(request.getSession().getAttribute("username") == null) {
			response.sendRedirect("notes/login");
			return;
		}
		
		String nextStep = request.getParameter("nextStep");
		String keyWord = request.getParameter("keyWord");
		if (nextStep == null) {
			nextStep = "homePage";
		}
		service = lookupService.getBusinessService(nextStep);
		service.execute(request, response);
		
		newStep = BASE + request.getAttribute("nextStep");
		response.sendRedirect(request.getContextPath() + newStep);
		
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
