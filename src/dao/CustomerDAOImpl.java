package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.PersistenceCustomer;
import model.Company;
import model.Customer;

public class CustomerDAOImpl extends DaoImpl implements CustomerDAO {
	
	private CompanyDAO companyDao;
	
	private static final String INSERT = "insert into customer (company_id, contact_name,"
			+ "contact_telephone) values (?,?,?)";
	
	public CustomerDAOImpl() {
		companyDao = new CompanyDAOImpl();
		
	}
	
	public void insert(Object o){
		Customer customer = (Customer) o;
		int companyId = customer.getCompany().getId();
		String contactName = customer.getContactName();
		String contactTelephone = customer.getContactTelephone();
		
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = getConnection();
			ps = connection.prepareStatement(INSERT);
			ps.setInt(1, companyId);
			ps.setString(2, contactName);
			ps.setString(3, contactTelephone);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			closeTwoConnection(connection, ps);
		}
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
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
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
			closeTripleConnection(connection, statement, resultSet);
		}
		return customer;
	}

	@Override
	public List<Customer> getCustomersList() {
		
		List<Customer> result = new ArrayList<Customer>();
		
		String sql = "select * from customer";
		
		Connection connection = null;
		Customer customer;
		Company company;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				customer = new Customer();
				customer.setId(resultSet.getInt("id"));
				
				company = companyDao.getCompanyById(
						resultSet.getInt("company_id"));
				
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

	@Override
	public List<PersistenceCustomer> getPersistenceCustomerList() {
		
		List<PersistenceCustomer> result = new ArrayList<PersistenceCustomer>();
		
		String sql = "select * from customer";
		
		Connection connection = null;
		PersistenceCustomer perCustomer;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				perCustomer = new PersistenceCustomer();
				perCustomer.setId(resultSet.getInt("id"));
				perCustomer.setCompanyId(resultSet.getInt("company_id"));
				perCustomer.setContactName(resultSet.getString("contact_name"));
				perCustomer.setContactTelephone(resultSet.getString("contact_telephone"));
				
				result.add(perCustomer);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;
	}

	@Override
	public void insertList(List<Customer> customersList) {

		for(Customer eachCustomer : customersList) {
			insert(eachCustomer);
		}
	}
		
}
	
	


