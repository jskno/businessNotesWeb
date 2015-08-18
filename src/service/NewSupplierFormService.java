package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Company;
import dao.CompanyDAO;
import dao.CompanyDAOImpl;

public class NewSupplierFormService extends ServiceImpl {

	@Override
	protected void execute() {
		showNewSupplierForm(request, response);
		request.setAttribute("url", "newSupplier.jsp?");
	}
	
	private void showNewSupplierForm(HttpServletRequest request,
			HttpServletResponse response) {
		
		getNoSupplierCompanies(request, response);
		
	}
	
	private void getNoSupplierCompanies(HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			CompanyDAO companyDao = new CompanyDAOImpl(null, null);
			List<Company> companiesList = companyDao.getNoSupplierCompanies();
			request.setAttribute("companiesList", companiesList);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
