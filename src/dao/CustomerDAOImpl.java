package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public Customer getCustomerById(int customerId) {
		
		String sql = "select * from customer where id = " + customerId;
		Customer customer = new Customer();
		Connection connection = null;
		
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Company company = companyDao.getCompanyById(
						resultSet.getInt("company_id"));
				customer.setId(resultSet.getInt("id"));
				customer.setCompany(company);
				customer.setContactName(resultSet.getString("contact_name"));
				customer.setContactTelephone(resultSet.getString("contact_telephone"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return customer;
	}

	@Override
	public List<Customer> getCustomersList() {
		
		List<Customer> result = new ArrayList<Customer>();
		
		String sql = "select * from customer";
		
		Connection connection = null;
		Customer customer = new Customer();
		Company company;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				customer.setId(resultSet.getInt("id"));
				
				company = companyDao.getCompanyById(
						resultSet.getInt("id"));
				
				customer.setCompany(company);
				customer.setContactName(resultSet.getString("contact_name"));
				customer.setContactTelephone(resultSet.getString("contact_telephone"));
				
				result.add(customer);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;
	}

}
