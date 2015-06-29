package dao;

import java.util.List;

import model.Customer;

public interface CustomerDAO extends Dao {

	Customer getCustomerById(int customerId);

	List<Customer> getCustomersList();

}
