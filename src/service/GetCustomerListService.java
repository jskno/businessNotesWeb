package service;

import java.util.List;

import model.Customer;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;

public class GetCustomerListService extends ServiceImpl {

	@Override
	protected void execute() {
		getCustomersList();
		request.setAttribute("url", "customersList.jsp?");
	}
	
	private void getCustomersList() {
		
		try {
			CustomerDAO customerDao = new CustomerDAOImpl(getConnection(), getSession());
			List<Customer> customersList = customerDao.getCustomersList();
			request.setAttribute("customersList", customersList);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	

}
