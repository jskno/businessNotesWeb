package service;

import model.CompanyVO;
import model.CustomerVO;
import model.RoleName;
import dao.CompanyDAO;
import dao.CompanyDAOImpl;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;

public class AddCustomerService extends ServiceImpl implements Service {
	
	private int companyId;

	@Override
	protected void execute() {
		String companyIdFromRq = request.getParameter("companyId");
		if(companyIdFromRq == null || companyIdFromRq.equals("")) {
			createCustomerAndCompany();
		} else {
			companyId = Integer.parseInt(companyIdFromRq);
			createCustomer(companyId);
		}
		request.setAttribute("nextStep", "newCustomer2");
	}
	
	private void createCustomer(Integer companyId) {
		
		CustomerVO customer = new CustomerVO();
		CompanyVO company = new CompanyVO();
		company.setCompanyId(companyId);
		customer.setCompany(company);
		customer.setRoleName(RoleName.CUSTOMER);
		customer.setContactName((String) request.getParameter("contactName"));
		customer.setContactTelephone((String) request.getParameter("contactTelephone"));
		customer.setCreditRating(Integer.parseInt(request.getParameter("creditRating")));
		customer.setCustomerDiscount(Double.parseDouble(
					request.getParameter("customerDiscount")));
		CustomerDAO customerDao = new CustomerDAOImpl(getConnection(), getSession());
		
		customerDao.insert(customer);
		
	}
	
	private void createCustomerAndCompany() {
		
		CompanyVO company = new CompanyVO();
		company.setTaxID(request.getParameter("taxID"));
		company.setCompanyName(request.getParameter("companyName"));
		company.setCompanyTelephone(request.getParameter("companyTelephone"));
		company.setCompanyEmail(request.getParameter("companyEmail"));
		CompanyDAO companyDao = new CompanyDAOImpl(getConnection(), getSession());
		companyId = companyDao.insert(company);
		
		createCustomer(companyId);
	}

}
