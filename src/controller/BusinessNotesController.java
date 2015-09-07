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
import model.CompanyVO;
import model.CustomerVO;
import model.MenuVO;
import model.NoteVO;
import model.ProductVO;
import model.SupplierVO;
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

	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String executeLogin() {
		String executelogin = "failed";
		return null;
	}

}
