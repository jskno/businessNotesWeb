package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.CompanyVO;
import model.CompanyRoleVO;
import model.CustomerVO;
import persistence.DDBBCompany;
import persistence.DDBBCompanyRole;
import persistence.DDBBCustomer;

public class CustomerDAOImpl extends DAOImpl implements CustomerDAO {
	
	CompanyRoleDao companyRoleDao;
	
	public CustomerDAOImpl(Connection connection, HttpSession session) {
		super(connection, session);
		companyRoleDao = new CompanyRoleDaoImpl(connection, session);
	}
	
	@Override
	public int insert(Object o){
		CompanyRoleVO companyRole = (CompanyRoleVO) o;
		int roleId = companyRoleDao.insert(companyRole);
		CustomerVO customer = (CustomerVO) o;
		customer.setRoleId(roleId);
		DDBBCustomer ddbbCustomer = customer.getPersistenceCustomer();
		int newCustomerId = -1;
		
		try {
			newCustomerId = ddbbCustomer.insert(connection);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return newCustomerId;
	}
	
	public Object search(Object o) {
		return null;
	}
	
	public void update(Object o) {
		
	}
	
	public void delete(Object o) {
		
	}

	@Override
	public CustomerVO getCustomerById(int roleId) {
		
		String sql = "select * from customer where role_id = " + roleId;
		DDBBCustomer ddbbCustomer = new DDBBCustomer();
		CustomerVO customer = new CustomerVO();
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
	public List<CustomerVO> getCustomersList() {
		
		List<CustomerVO> customerList = new ArrayList<CustomerVO>();
		
		String sql = "select * from customer cus "
				+ "join company_role cr "
					+ "on cus.role_id = cr.role_id "
				+ "join company com "
					+ "on cr.company_id = com.company_id "
				+ "order by com.company_name";
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		CustomerVO customer = null;
		
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				customer = getCustomerFromRs(resultSet);
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
	public List<DDBBCustomer> getPersistenceCustomersList() {
		
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
	public void insertList(List<CustomerVO> customersList) {

		for(CustomerVO eachCustomer : customersList) {
			insert(eachCustomer);
		}
	}

	@Override
	public CustomerVO getCustomerByTaxID(String taxID) {
		
		CustomerVO customer = null;
		
		String sql = "select * from customer cus"
			+ " left join company_role cr"
					+ " on cus.role_id = cr.role_id"
			+ " left join company com"
					+ " on cr.company_id = com.company_id"
			+ " where com.tax_ID =?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, taxID);
			rs = ps.executeQuery();
			while (rs.next()) {
				customer = getCustomerFromRs(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeStmtAndRs(ps, rs);
		}
		return customer;
	}
	
	private CustomerVO getCustomerFromRs(ResultSet rs) throws SQLException {
		
		CustomerVO customer;
		CompanyVO company;
		
		DDBBCustomer ddbbCustomer = new DDBBCustomer();
		DDBBCompanyRole ddbbCompanyRole = new DDBBCompanyRole();
		DDBBCompany ddbbCompany = new DDBBCompany();
		
		ddbbCompany.loadResult(rs);
		ddbbCustomer.loadResult(rs);
		ddbbCompanyRole.loadResult(rs);
		
		company = new CompanyVO(ddbbCompany);
		customer = new CustomerVO(ddbbCompanyRole, ddbbCustomer);
		customer.setCompany(company);
		
		return customer;
	}
		
}