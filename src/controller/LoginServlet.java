package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.DBUtil;
import dao.MenuDAO;
import dao.MenuDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.MenuVO;
import model.UserVO;

@WebServlet(
		name = "loginServlet",
		urlPatterns = "notes/login"
		)

public class LoginServlet extends HttpServlet {
	
	private static final UserDAO userDao = 
			new UserDAOImpl(DBUtil.getConnection(), null);
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(request.getParameter("logout") != null) {
			session.invalidate();
			response.sendRedirect(request.getContextPath() + "/notes/login");
			return;
		} else if(session.getAttribute("username") != null){
			response.sendRedirect(request.getContextPath() + "/notes");
			return;
		}
		request.setAttribute("loginFailed", false);
		request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("username") != null) {
			response.sendRedirect("notes");
			return;
		}
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username == null || password == null ||
				username.isEmpty() || password.isEmpty()) {  
			request.setAttribute("loginFailed", true);
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		} else {
			UserVO user = userDao.getUserByUsernameId(username);
			if(user != null && username.equals(user.getUserName()) &&
					password.equals(user.getPassword())) {
				session.setAttribute("username", username);
				session.setAttribute("profile", user.getProfile().desc());
				request.changeSessionId();
				response.sendRedirect(request.getContextPath() + "/notes");
			} else {
				request.setAttribute("loginFailed", true);
				request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
			}
		}
	}

}
