package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Company;
import model.Customer;

public class CustomerDAOImpl extends DaoImpl implements CustomerDAO {
	
	private CompanyDAO companyDao;
	
	public CustomerDAOImpl() {
		companyDao = new CompanyDAOImpl();
		
	}
	
	public void insert(Object o){
		
	}
	
	public Object search(Object o) {
		return null;
	}
	
	public void update(Object o) {
		
	}
	
	public void delete(Object o) {
		
	}

	@Override
	public Customer getCustomerById(int customerId, Connection connection) {
		
		String sql = "select * from customer where id = " + customerId;
		Customer customer = new Customer();
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Company company = companyDao.getCompanyById(
						resultSet.getInt("company_id"), connection);
				customer.setId(resultSet.getInt("id"));
				customer.setCompany(company);
				customer.setContactName(resultSet.getString("contact_name"));
				customer.setContactTelephone(resultSet.getString("contact_telephone"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} //finally {
		//	closeConnection(connection);
		//}
		return customer;
	}

}
