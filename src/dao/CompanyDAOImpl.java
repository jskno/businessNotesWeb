package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistence.DDBBCompany;
import model.CompanyVO;

public class CompanyDAOImpl extends DAOImpl implements CompanyDAO {
	
	public CompanyDAOImpl(Connection connection, HttpSession session) {
		super(connection, session);
	}

	private static final String NO_CUSTOMER_COMPANIES = "select * from company where id not in (" +
			"select distinct company_id from customer)";
	private static final String NO_SUPPLIER_COMPANIES = "select * from company where id not in (" +
			"select distinct company_id from supplier)";
	
	public int insert(Object o){
		
		CompanyVO company = (CompanyVO) o;
		DDBBCompany ddbbCompany = company.getPersistenceObject();
		Integer newCompanyId = -1;
		
		try {
			newCompanyId = ddbbCompany.insert(connection);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return newCompanyId;
	}
	
	public Object search(Object o) {
		return null;
	}
	
	public void update(Object o) {
				
	}
	
	public void delete(Object o) {
		
	}
	
	public List<CompanyVO> getCompaniesList() {
		
		List<CompanyVO> result = new ArrayList<CompanyVO>();
				
		String sql = "select * from company order by company_name";
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		CompanyVO company = null;
		
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				company = getCompanyFromRs(resultSet);
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
	public List<CompanyVO> getNoCustomerCompanies() {
		
		List<CompanyVO> result = new ArrayList<CompanyVO>();
		CompanyVO company;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(NO_CUSTOMER_COMPANIES);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				company = new CompanyVO();
				company.setCompanyId(resultSet.getInt("id"));
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
	public List<CompanyVO> getNoSupplierCompanies() {
		
		List<CompanyVO> result = new ArrayList<CompanyVO>();
		CompanyVO company;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement(NO_SUPPLIER_COMPANIES);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				company = new CompanyVO();
				company.setCompanyId(resultSet.getInt("id"));
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
	
	public List<CompanyVO> searchCompaniesByName(String name) {
		List<CompanyVO> result = new ArrayList<CompanyVO>();
		
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
				CompanyVO company = new CompanyVO();
				company.setCompanyId(resultSet.getInt("id"));
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
	public CompanyVO getCompanyById(int companyId) {
		
		String sql = "select * from company where id = " + companyId;
		CompanyVO company = new CompanyVO();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				company.setCompanyId(resultSet.getInt("id"));
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
	public void insertList(List<CompanyVO> companiesList) {
		
		for(CompanyVO eachCompany : companiesList) {
			insert(eachCompany);
		}
		
	}

	@Override
	public CompanyVO getCompanyByTaxID(String taxID) {
		String sql = "select * from company where tax_ID = ?";
		CompanyVO company = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, taxID);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				DDBBCompany ddbbCompany = new DDBBCompany();
				ddbbCompany.loadResult(resultSet);
				company = new CompanyVO(ddbbCompany);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeStmtAndRs(statement, resultSet);
		}
		return company;
	}
	
	private CompanyVO getCompanyFromRs(ResultSet resultSet) throws SQLException {
		
		CompanyVO company;
		DDBBCompany ddbbCompany = new DDBBCompany();
		ddbbCompany.loadResult(resultSet);
		company = new CompanyVO(ddbbCompany);
		
		return company;
	}
}
