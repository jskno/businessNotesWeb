package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Company;
import model.Customer;
import model.Supplier;
import dao.CompanyDAO;
import dao.CompanyDAOImpl;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import dao.SupplierDAO;
import dao.SupplierDAOImpl;
import service.Service;
import utils.DBUtil;

public class BusinessNotesAjaxServlet extends HttpServlet {
	
	private ServletContext context;
	String sb;
	
	public void init(ServletConfig config) throws ServletException {
		this.context = config.getServletContext();
	}
	
	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String action = request.getParameter("action");
        String taxID = request.getParameter("taxID");
        
        if (taxID != null) {
        	taxID = taxID.trim().toLowerCase();
        } else {
            context.getRequestDispatcher("/error.jsp").forward(request, response);
        }
        
        boolean namesAdded = false;
        if (action.equals("checkCompanyCustomer")) {
        	
        	// check if user sent empty string
            if (!taxID.equals("")) {
            	
            	CustomerDAO customerDao = new CustomerDAOImpl(DBUtil.getConnection(),
        			request.getSession());
            	Customer customer = customerDao.getCustomerByTaxID(taxID);
            	
            	if(customer != null) {
            		sb = customer.toJson();
            		namesAdded = true;
            	} else {
            		CompanyDAO companyDao = new CompanyDAOImpl(DBUtil.getConnection(),
                			request.getSession());
            		Company company = companyDao.getCompanyByTaxID(taxID);
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
            
        } else if(action.equals("checkCompany")) {
        	
        	// check if user sent empty string
            if (!taxID.equals("")) {
            	
            	CompanyDAO companyDao = new CompanyDAOImpl(DBUtil.getConnection(),
        			request.getSession());
            	Company company = companyDao.getCompanyByTaxID(taxID);
            	
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
        	
        } else if(action.equals("checkCompanySupplier")) {
        	
        	// check if user sent empty string
            if (!taxID.equals("")) {
            	
            	SupplierDAO supplierDao = new SupplierDAOImpl(DBUtil.getConnection(),
        			request.getSession());
            	Supplier supplier = supplierDao.getSupplierByTaxID(taxID);
            	
            	if(supplier != null) {
            		sb = supplier.toJson();
            		namesAdded = true;
            	} else {
            		CompanyDAO companyDao = new CompanyDAOImpl(DBUtil.getConnection(),
                			request.getSession());
            		Company company = companyDao.getCompanyByTaxID(taxID);
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
    }
	
	
}
