package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Company;
import model.Supplier;

public class SupplierDAOImpl extends DaoImpl implements SupplierDAO {
	
	private CompanyDAO companyDao;
	
	public SupplierDAOImpl() {
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
	public Supplier getSupplierById(int supplierId) {
		
		String sql = "select * from supplier where id = " + supplierId;
		Supplier supplier = new Supplier();
		Company company;
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				company = companyDao.getCompanyById(
						resultSet.getInt("company_id"));
				supplier.setId(resultSet.getInt("id"));
				supplier.setCompany(company);
				supplier.setContactName(resultSet.getString("contact_name"));
				supplier.setContactTelephone(resultSet.getString("contact_telephone"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return supplier;
	}

	@Override
	public List<Supplier> getSuppliesList() {
		
		List<Supplier> result = new ArrayList<Supplier>();
		
		String sql = "select * from supplier";
		
		Connection connection = null;
		Supplier supplier = new Supplier();
		Company company;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				supplier.setId(resultSet.getInt("id"));
				
				company = companyDao.getCompanyById(
						resultSet.getInt("id"));
				
				supplier.setCompany(company);
				supplier.setContactName(resultSet.getString("contact_name"));
				supplier.setContactTelephone(resultSet.getString("contact_telephone"));
				
				result.add(supplier);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;
	}

}
