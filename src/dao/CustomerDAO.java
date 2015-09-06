package dao;

import java.util.List;

import persistence.DDBBCustomer;
import model.CustomerVO;

public interface CustomerDAO extends Dao {

	CustomerVO getCustomerById(int customerId);

	List<CustomerVO> getCustomersList();

	List<DDBBCustomer> getPersistenceCustomerList();

	void insertList(List<CustomerVO> customersList);

	CustomerVO getCustomerByTaxID(String taxID);

}
