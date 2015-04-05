package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	public Supplier getSupplierById(int supplierId, Connection connection) {
		
		String sql = "select * from supplier where id = " + supplierId;
		Supplier supplier = new Supplier();
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Company company = companyDao.getCompanyById(
						resultSet.getInt("company_id"), connection);
				supplier.setId(resultSet.getInt("id"));
				supplier.setCompany(company);
				supplier.setContactName(resultSet.getString("contact_name"));
				supplier.setContactTelephone(resultSet.getString("contact_telephone"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}// finally {
		//	closeConnection(connection);
		//}
		return supplier;
	}

}
