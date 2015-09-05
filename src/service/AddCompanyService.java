package service;

import model.Company;
import dao.CompanyDAO;
import dao.CompanyDAOImpl;

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
		companyDao = new CompanyDAOImpl(getConnection(), getSession());
		company.setCompanyName((String) request.getParameter("companyName"));
		company.setCompanyTelephone((String) request.getParameter("companyTelephone"));
		company.setCompanyEmail((String) request.getParameter("companyEmail"));
		
		companyDao.insert(company);
			
	}

}
