package service;

import java.sql.SQLException;

import dao.CompanyDAO;
import dao.CompanyDAOImpl;
import model.Company;

public class AddCompanyService extends ServiceImpl implements Service {

	@Override
	protected void execute() {

		createCompany();
		String originScreen = request.getParameter("originScreen");
		switch (originScreen) {
		case "newCustomerForm":
			request.setAttribute("newAction", "newCustomer");
			break;
		case "newSupplierForm":
			request.setAttribute("newAction", "newSupplier");
			break;
		default:
			request.setAttribute("newAction", "newCompany");
			break;
		}
		
	}
	
	private void createCompany() {
		
		Company company = new Company();
		CompanyDAO companyDao = null;
		try {
			companyDao = new CompanyDAOImpl(getConnection(), getSession());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		company.setCompanyName((String) request.getParameter("companyName"));
		company.setCompanyTelephone((String) request.getParameter("companyTelephone"));
		company.setCompanyEmail((String) request.getParameter("companyEmail"));
		
		companyDao.insert(company);
			
	}

}
