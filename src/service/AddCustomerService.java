package service;

import model.CompanyVO;
import model.CustomerVO;
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
		
		CustomerVO customer = new CustomerVO();
		CompanyDAO companyDao = null;
		companyDao = new CompanyDAOImpl(getConnection(), getSession());
		CustomerDAO customerDao = new CustomerDAOImpl(null, null);
		CompanyVO company = companyDao.getCompanyById(Integer.parseInt(request.getParameter("companyId")));
		customer.setCompany(company);
		customer.setContactName((String) request.getParameter("contactName"));
		customer.setContactTelephone((String) request.getParameter("contactTelephone"));
		
		customerDao.insert(customer);
		
	}

}
