package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.Company;

public class CompanyDAOImpl extends DaoImpl implements CompanyDAO {
	
	public CompanyDAOImpl(Connection connection, HttpSession session) {
		super(connection, session);
	}

	private static final String INSERT = "insert into company (company_name, company_telephone, " +
			"company_email) values (?,?,?)";
	private static final String NO_CUSTOMER_COMPANIES = "select * from company where id not in (" +
			"select distinct company_id from customer)";
	private static final String NO_SUPPLIER_COMPANIES = "select * from company where id not in (" +
			"select distinct company_id from supplier)";
	
	public void insert(Object o){
		Company company = (Company) o;
		String companyName = company.getCompanyName();
		String companyTelephone = company.getCompanyTelephone();
		String companyEmail = company.getCompanyEmail();
		
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(INSERT);
			ps.setString(1, companyName);
			ps.setString(2, companyTelephone);
			ps.setString(3, companyEmail);
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
	
	public List<Company> getCompaniesList() {
		
		List<Company> result = new ArrayList<Company>();
				
		String sql = "select * from company order by company_name";
		
		Connection connection = null;
		Company company;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				company = new Company();
				company.setId(resultSet.getInt("id"));
				company.setCompanyName(resultSet.getString("company_name"));
				company.setCompanyTelephone(resultSet.getString("company_telephone"));
				company.setCompanyEmail(resultSet.getString("company_email"));
				result.add(company);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeStmtAndRs(statement, resultSet);
		}
		return result;
	}
	
	@Override
	public List<Company> getNoCustomerCompanies() {
		
		List<Company> result = new ArrayList<Company>();
		Company company;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(NO_CUSTOMER_COMPANIES);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				company = new Company();
				company.setId(resultSet.getInt("id"));
				company.setCompanyName(resultSet.getString("company_name"));
				company.setCompanyTelephone(resultSet.getString("company_telephone"));
				company.setCompanyEmail(resultSet.getString("company_email"));
				result.add(company);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeStmtAndRs(statement, resultSet);
		}
		return result;
	}
	
	@Override
	public List<Company> getNoSupplierCompanies() {
		
		List<Company> result = new ArrayList<Company>();
		Company company;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement(NO_SUPPLIER_COMPANIES);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				company = new Company();
				company.setId(resultSet.getInt("id"));
				company.setCompanyName(resultSet.getString("company_name"));
				company.setCompanyTelephone(resultSet.getString("company_telephone"));
				company.setCompanyEmail(resultSet.getString("company_email"));
				result.add(company);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeStmtAndRs(statement, resultSet);
		}
		return result;
	}
	
	public List<Company> searchCompaniesByName(String name) {
		List<Company> result = new ArrayList<Company>();
		
		String sql = "select * from company"
				+ " where company_name Like '%"
				+ name.trim()
				+ "%'";
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Company company = new Company();
				company.setId(resultSet.getInt("id"));
				company.setCompanyName(resultSet.getString("company_name"));
				company.setCompanyTelephone(resultSet.getString("company_telephone"));
				company.setCompanyEmail(resultSet.getString("company_email"));
				result.add(company);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeStmtAndRs(statement, resultSet);
		}
			
		return result;
		
	}

	@Override
	public Company getCompanyById(int companyId) {
		
		String sql = "select * from company where id = " + companyId;
		Company company = new Company();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				company.setId(resultSet.getInt("id"));
				company.setCompanyName(resultSet.getString("company_name"));
				company.setCompanyTelephone(resultSet.getString("company_telephone"));
				company.setCompanyEmail(resultSet.getString("company_email"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeStmtAndRs(statement, resultSet);
		}
		return company;
	}

	@Override
	public void insertList(List<Company> companiesList) {
		
		for(Company eachCompany : companiesList) {
			insert(eachCompany);
		}
		
	}
	
	

}
