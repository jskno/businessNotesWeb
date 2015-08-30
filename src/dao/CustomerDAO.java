package dao;

import java.util.List;

import persistence.DDBBCustomer;
import model.Customer;

public interface CustomerDAO extends Dao {

	Customer getCustomerById(int customerId);

	List<Customer> getCustomersList();

	List<DDBBCustomer> getPersistenceCustomerList();

	void insertList(List<Customer> customersList);

}
