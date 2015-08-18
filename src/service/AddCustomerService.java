package service;

import java.sql.SQLException;

import dao.CompanyDAO;
import dao.CompanyDAOImpl;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import model.Company;
import model.Customer;

public class AddCustomerService extends ServiceImpl implements Service {

	@Override
	protected void execute() {

		createCustomer();
		request.setAttribute("newAction", "newCustomer");
	}
	
	private void createCustomer() {
		
		Customer customer = new Customer();
		CompanyDAO companyDao = null;
		try {
			companyDao = new CompanyDAOImpl(getConnection(), getSession());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CustomerDAO customerDao = new CustomerDAOImpl(null, null);
		Company company = companyDao.getCompanyById(Integer.parseInt(request.getParameter("companyId")));
		customer.setCompany(company);
		customer.setContactName((String) request.getParameter("contactName"));
		customer.setContactTelephone((String) request.getParameter("contactTelephone"));
		
		customerDao.insert(customer);
		
	}

}
