package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Company;

public class CompanyDAOImpl extends DaoImpl implements CompanyDAO {
	
	public void insert(Object o){
				
	}
	
	public Object search(Object o) {
		return null;
	}
	
	public void update(Object o) {
		
	}
	
	public void delete(Object o) {
		
	}
	
	public List<Company> findAllCompanies() {
		
		List<Company> result = new ArrayList<Company>();
				
		String sql = "select * from company";
		
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
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
			closeConnection(connection);
		}
		return result;
	}
	
	public List<Company> searchCompaniesByName(String name) {
		List<Company> result = new ArrayList<Company>();
		
		String sql = "select * from company"
				+ " where company_name Like '%"
				+ name.trim()
				+ "%'";
		
		Connection connection = null;
		try {
			
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
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
			closeConnection(connection);
		}
			
		return result;
		
	}

	@Override
	public Company getCompanyById(int companyId, Connection connection) {
		
		String sql = "select * from company where id = " + companyId;
		Company company = new Company();
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				company.setId(resultSet.getInt("id"));
				company.setCompanyName(resultSet.getString("company_name"));
				company.setCompanyTelephone(resultSet.getString("company_telephone"));
				company.setCompanyEmail(resultSet.getString("company_email"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}// finally {
		//	closeConnection(connection);
		//}
		return company;
	}
	
	

}
