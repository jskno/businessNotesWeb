package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Company;
import dao.CompanyDAO;
import dao.CompanyDAOImpl;

public class NewCustomer2Service extends ServiceImpl{

	@Override
	protected void execute() {		
		//getNoCustomerCompanies(request, response);
		request.setAttribute("url", "newCustomer2.jsp");
	}
	
	private void getNoCustomerCompanies(HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			CompanyDAO companyDao = new CompanyDAOImpl(null, null);
			List<Company> companiesList = companyDao.getNoCustomerCompanies();
			request.setAttribute("companiesList", companiesList);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
