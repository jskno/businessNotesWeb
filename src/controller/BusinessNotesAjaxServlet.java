package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CompanyVO;
import model.CustomerVO;
import model.SupplierVO;
import utils.DBUtil;
import dao.CompanyDAO;
import dao.CompanyDAOImpl;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import dao.SupplierDAO;
import dao.SupplierDAOImpl;

public class BusinessNotesAjaxServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	String sb;
	
	public void init(ServletConfig config) throws ServletException {
		this.context = config.getServletContext();
	}
	
	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

		if(request.getSession().getAttribute("username") == null) {
			response.sendRedirect("notes/login");
			return;
		}
		
		String action = request.getParameter("action");
        
		switch (action) {
		case "checkCompanyCustomer":
			checkTaxIDInCustomer(request, response);
			break;
		case "checkCompany":
			checkTaxIDInCompany(request, response);
			break;
		case "checkCompanySupplier":
			checkTaxIDInSupplier(request, response);
			break;
		case "getNoRoleCompanies":
			getNoRoleCompanies(request, response);
			break;
		default:
			break;
		}
    }

	

	private void checkTaxIDInSupplier(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String taxID = request.getParameter("taxID");
        
        if (taxID != null) {
        	taxID = taxID.trim().toLowerCase();
        } else {
            context.getRequestDispatcher("/error.jsp").forward(request, response);
        }
        
        boolean namesAdded = false;
        
     // check if user sent empty string
        if (!taxID.equals("")) {
        	
        	SupplierDAO supplierDao = new SupplierDAOImpl(DBUtil.getConnection(),
    			request.getSession());
        	SupplierVO supplier = supplierDao.getSupplierByTaxID(taxID);
        	
        	if(supplier != null) {
        		sb = supplier.toJson();
        		namesAdded = true;
        	} else {
        		CompanyDAO companyDao = new CompanyDAOImpl(DBUtil.getConnection(),
            			request.getSession());
        		CompanyVO company = companyDao.getCompanyByTaxID(taxID);
        		if(company != null) {
        			sb = company.toJson() + "<supplierAdded>0</supplierAdded>";
        			namesAdded = true;
        		} else {
        			
        		}
        	}
       }

        if (namesAdded) {
            response.setContentType("text/xml");
            response.setHeader("Cache-Control", "no-cache");
            response.getWriter().write("<data>" + sb + "</data>");
        } else {
            //nothing to show
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }
	}

	private void checkTaxIDInCompany(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String taxID = request.getParameter("taxID");
        
        if (taxID != null) {
        	taxID = taxID.trim().toLowerCase();
        } else {
            context.getRequestDispatcher("/error.jsp").forward(request, response);
        }
        
        boolean namesAdded = false;
        
     // check if user sent empty string
        if (!taxID.equals("")) {
        	
        	CompanyDAO companyDao = new CompanyDAOImpl(DBUtil.getConnection(),
    			request.getSession());
        	CompanyVO company = companyDao.getCompanyByTaxID(taxID);
        	
        	if(company != null) {
        		sb = company.toJson();
        		namesAdded = true;
        	} else {
        		sb = "<companyAdded>0</companyAdded>";
        		namesAdded = true;
        	}
       }

        if (namesAdded) {
            response.setContentType("text/xml");
            response.setHeader("Cache-Control", "no-cache");
            response.getWriter().write("<data>" + sb + "</data>");
        } else {
            //nothing to show
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }
		
	}

	private void checkTaxIDInCustomer(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String taxID = request.getParameter("taxID");
        
        if (taxID != null) {
        	taxID = taxID.trim().toLowerCase();
        } else {
            context.getRequestDispatcher("/error.jsp").forward(request, response);
        }
        
        boolean namesAdded = false;
        
     // check if user sent empty string
        if (!taxID.equals("")) {
        	
        	CustomerDAO customerDao = new CustomerDAOImpl(DBUtil.getConnection(),
    			request.getSession());
        	CustomerVO customer = customerDao.getCustomerByTaxID(taxID);
        	
        	if(customer != null) {
        		sb = customer.toJson();
        		namesAdded = true;
        	} else {
        		CompanyDAO companyDao = new CompanyDAOImpl(DBUtil.getConnection(),
            			request.getSession());
        		CompanyVO company = companyDao.getCompanyByTaxID(taxID);
        		if(company != null) {
        			sb = company.toJson() + "<customerAdded>0</customerAdded>";
        			namesAdded = true;
        		} else {
        			
        		}
        	}
       }

        if (namesAdded) {
            response.setContentType("text/xml");
            response.setHeader("Cache-Control", "no-cache");
            response.getWriter().write("<data>" + sb + "</data>");
        } else {
            //nothing to show
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }
		
	}
	
	private void getNoRoleCompanies(HttpServletRequest request,
			HttpServletResponse response) {
		
		boolean companiesAdded = false;
		String origin = request.getParameter("origin");
		
		try {
			CompanyDAO companyDao = new CompanyDAOImpl(DBUtil.getConnection(),
        			request.getSession());
			List<CompanyVO> companiesList = companyDao.getNoRoleCompanies(origin);
			StringBuffer sb = new StringBuffer();
			if(companiesList != null) {
				companiesAdded = true;
				for(CompanyVO eachCompany : companiesList) {
					sb.append(eachCompany.toJson());
				}
			}
			
			if (companiesAdded) {
	            response.setContentType("text/xml");
	            response.setHeader("Cache-Control", "no-cache");
	            response.getWriter().write("<data>" + sb.toString() + "</data>");
	        } else {
	            //nothing to show
	            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	        }
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
