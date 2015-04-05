package dao;

import java.sql.Connection;

import model.Customer;

public interface CustomerDAO extends Dao {

	Customer getCustomerById(int customerId, Connection connection);

}
