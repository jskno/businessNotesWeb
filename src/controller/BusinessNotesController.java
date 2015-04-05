package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Company;
import model.Note;
import dao.CompanyDAO;
import dao.CompanyDAOImpl;
import dao.NoteDAO;
import dao.NoteDAOImpl;

public class BusinessNotesController extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		//NoteDAO noteDao = new NoteDAOImpl();
		//List<Note> notesList = noteDao.getLastNotes();
		ServletContext context = config.getServletContext();
		//context.setAttribute("notesList", notesList);
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String base = "/jsp/";
		String url = base + "newNoteHome2.jsp"; //home.jsp
		String action = request.getParameter("action");
		String keyWord = request.getParameter("keyWord");
		if (action != null) {
			switch(action) {
			case "allCompanies":
				findAllCompanies(request, response);
				url = base + "listOfCompanies.jsp";
				break;
			case "lastNotes":
				lastNotes(request, response);
				url = base + "listOfLastNotes.jsp?";
				break;
			case "searchCompanies":
				searchCompanies(request, response, keyWord);
				url = base + "searchResult.jsp";
				break;
			}
		}
		RequestDispatcher requestDispatcher = getServletContext().
				getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
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

	private void findAllCompanies(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			CompanyDAO companyDao = new CompanyDAOImpl();
			List<Company> companiesList = companyDao.findAllCompanies();
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
