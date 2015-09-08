package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;

public class BusinessNotesControllerRedirect extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		if (nextStep == null) {
			nextStep = "homePage";
		}
		service = lookupService.getBusinessService(nextStep);
		service.execute(request, response);
		
		newStep = BASE + request.getAttribute("nextStep");
		response.sendRedirect(request.getContextPath() + newStep);
	}
	
}
