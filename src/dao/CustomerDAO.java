package dao;

import java.util.List;

import persistence.DDBBCustomer;
import model.CustomerVO;

public interface CustomerDAO extends DAO {

	CustomerVO getCustomerById(int customerId);

	List<CustomerVO> getCustomersList();

	List<DDBBCustomer> getPersistenceCustomersList();

	void insertList(List<CustomerVO> customersList);

	CustomerVO getCustomerByTaxID(String taxID);

}
