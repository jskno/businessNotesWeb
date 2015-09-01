package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.Customer;
import persistence.DDBBCustomer;

public class CustomerDAOImpl extends DaoImpl implements CustomerDAO {
	
	
	private static final String INSERT = "INSERT /*INSERT_ALL*/ INTO customer(ROLE_ID, CREDIT_RATING, CUSTOMER_DISCOUNT) VALUES(?,?,?)";
	
	public CustomerDAOImpl(Connection connection, HttpSession session) {
		super(connection, session);
	}
	
	public void insert(Object o){
		Customer customer = (Customer) o;
		DDBBCustomer ddbbCustomer = customer.getPersistenceCustomer();
		
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(INSERT);
			ps.setInt(1, ddbbCustomer.getRoleId());
			ps.setInt(2, ddbbCustomer.getCreditRating());
			ps.setDouble(3, ddbbCustomer.getCustomerDiscount());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			closeStmt(ps);
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
	public Customer getCustomerById(int roleId) {
		
		String sql = "select * from customer where role_id = " + roleId;
		DDBBCustomer ddbbCustomer = new DDBBCustomer();
		Customer customer = new Customer();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			ddbbCustomer.loadResult(resultSet);
			customer.setFromPersistenceObject(ddbbCustomer);
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeStmtAndRs(statement, resultSet);
		}
		return customer;
	}

	@Override
	public List<Customer> getCustomersList() {
		
		List<Customer> customerList = new ArrayList<Customer>();
		
		String sql = "select * from customer";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		DDBBCustomer ddbbCustomer = new DDBBCustomer();
		Customer customer = new Customer();
		
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ddbbCustomer.loadResult(resultSet);
				customer.setFromPersistenceObject(ddbbCustomer);
				customerList.add(customer);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeStmtAndRs(statement, resultSet);
		}
		return customerList;
	}

	@Override
	public List<DDBBCustomer> getPersistenceCustomerList() {
		
		List<DDBBCustomer> list = new ArrayList<DDBBCustomer>();
		
		String sql = "select * from customer";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		DDBBCustomer ddbbCustomer = new DDBBCustomer();
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ddbbCustomer.loadResult(resultSet);
				list.add(ddbbCustomer);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeStmtAndRs(statement, resultSet);
		}
		return list;
	}

	@Override
	public void insertList(List<Customer> customersList) {

		for(Customer eachCustomer : customersList) {
			insert(eachCustomer);
		}
	}
		
}
	
	


