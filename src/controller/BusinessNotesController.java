package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MenuVO;
import service.Service;
import utils.DBUtil;
import dao.MenuDAO;
import dao.MenuDAOImpl;

public class BusinessNotesController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String BASE = "/jsp/";
	private static final BusinessLookUp lookupService = new BusinessLookUp();
	private String url;
	private Service service;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		MenuDAO menuDao = new MenuDAOImpl(DBUtil.getConnection(), null);
		Map<Integer, MenuVO> theMenu = menuDao.getMenu();
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
		
		if(request.getSession().getAttribute("username") == null) {
			response.sendRedirect(request.getContextPath() + "/notes/login");
			return;
		} else {
			
			
			String nextStep = request.getParameter("nextStep");
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
		}
		
	}
}
