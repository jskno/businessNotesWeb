package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;

public class BusinessNotesAjaxServlet extends HttpServlet {
	
	private ServletContext context;
	private static final String BASE = "/jsp/";
	private String url;
	private Service service;
	private BusinessLookUp lookupService = new BusinessLookUp();
	
	public void init(ServletConfig config) throws ServletException {
		this.context = config.getServletContext();
	}
	
	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String action = request.getParameter("action");
        String targetId = request.getParameter("id");
        StringBuffer sb = new StringBuffer();

        if (targetId != null) {
            targetId = targetId.trim().toLowerCase();
        } else {
            context.getRequestDispatcher("/error.jsp").forward(request, response);
        }

        boolean namesAdded = false;
        if (action.equals("complete")) {

            // check if user sent empty string
            if (!targetId.equals("")) {

                
                
            }

            if (namesAdded) {
                response.setContentType("text/xml");
                response.setHeader("Cache-Control", "no-cache");
                response.getWriter().write("<composers>" + sb.toString() + "</composers>");
            } else {
                //nothing to show
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
        }

        if (action.equals("lookup")) {

            // put the target composer in the request scope to display 
//            if ((targetId != null) && composers.containsKey(targetId.trim())) {
//                request.setAttribute("composer", composers.get(targetId));
//                context.getRequestDispatcher("/composer.jsp").forward(request, response);
//            }
        }
    }
	
	
}
