package service;

import model.Company;
import model.Customer;
import dao.CompanyDAO;
import dao.CompanyDAOImpl;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;

public class AddCustomerService extends ServiceImpl implements Service {

	@Override
	protected void execute() {

		createCustomer();
		request.setAttribute("newAction", "newCustomer");
	}
	
	private void createCustomer() {
		
		Customer customer = new Customer();
		CompanyDAO companyDao = null;
		companyDao = new CompanyDAOImpl(getConnection(), getSession());
		CustomerDAO customerDao = new CustomerDAOImpl(null, null);
		Company company = companyDao.getCompanyById(Integer.parseInt(request.getParameter("companyId")));
		customer.setCompany(company);
		customer.setContactName((String) request.getParameter("contactName"));
		customer.setContactTelephone((String) request.getParameter("contactTelephone"));
		
		customerDao.insert(customer);
		
	}

}
