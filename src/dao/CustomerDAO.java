package dao;

import java.util.List;

import persistence.PersistenceCustomer;
import model.Customer;

public interface CustomerDAO extends Dao {

	Customer getCustomerById(int customerId);

	List<Customer> getCustomersList();

	List<PersistenceCustomer> getPersistenceCustomerList();

}
