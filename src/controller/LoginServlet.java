package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserVO;
import utils.DBUtil;
import dao.UserDAO;
import dao.UserDAOImpl;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
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
				session.setAttribute("userId", user.getUserId());
				session.setAttribute("username", username);
				session.setAttribute("profile", user.getProfile());
				request.changeSessionId();
				response.sendRedirect(request.getContextPath() + "/notes");
			} else {
				request.setAttribute("loginFailed", true);
				request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
			}
		}
	}

}
