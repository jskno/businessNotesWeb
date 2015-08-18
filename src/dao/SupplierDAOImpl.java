package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import persistence.PersistenceSupplier;
import model.Company;
import model.Supplier;

public class SupplierDAOImpl extends DaoImpl implements SupplierDAO {
	
	private CompanyDAO companyDao;
	
	private static final String INSERT = "insert into supplier (company_id, contact_name,"
			+ "contact_telephone) values (?,?,?)";
	
	public SupplierDAOImpl(Connection connection, HttpSession session) {
		super(connection, session);
		companyDao = new CompanyDAOImpl(connection, session);
	}
	
	public void insert(Object o){
		Supplier supplier = (Supplier) o;
		int companyId = supplier.getCompany().getId();
		String contactName = supplier.getContactName();
		String contactTelephone = supplier.getContactTelephone();
		
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(INSERT);
			ps.setInt(1, companyId);
			ps.setString(2, contactName);
			ps.setString(3, contactTelephone);
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
	public Supplier getSupplierById(int supplierId) {
		
		String sql = "select * from supplier where id = " + supplierId;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		Supplier supplier = new Supplier();
		Company company;
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			
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
			closeStmtAndRs(statement, resultSet);
		}
		return supplier;
	}

	@Override
	public List<Supplier> getSuppliersList() {
		
		List<Supplier> result = new ArrayList<Supplier>();
		
		String sql = "select * from supplier";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		Supplier supplier;
		Company company;
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				supplier = new Supplier();
				supplier.setId(resultSet.getInt("id"));
				
				company = companyDao.getCompanyById(
						resultSet.getInt("company_id"));
				
				supplier.setCompany(company);
				supplier.setContactName(resultSet.getString("contact_name"));
				supplier.setContactTelephone(resultSet.getString("contact_telephone"));
				
				result.add(supplier);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeStmtAndRs(statement, resultSet);
		}
		return result;
	}

	@Override
	public List<PersistenceSupplier> getPersistenceCustomerList() {
		
		List<PersistenceSupplier> result = new ArrayList<PersistenceSupplier>();
		
		String sql = "select * from supplier";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		PersistenceSupplier perSupplier;
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				perSupplier = new PersistenceSupplier();
				perSupplier.setId(resultSet.getInt("id"));
				perSupplier.setCompanyId(resultSet.getInt("company_id"));
				perSupplier.setContactName(resultSet.getString("contact_name"));
				perSupplier.setContactTelephone(resultSet.getString("contact_telephone"));
				
				result.add(perSupplier);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeStmtAndRs(statement, resultSet);;
		}
		return result;
	}

	@Override
	public void insertList(List<Supplier> suppliersList) {

		for(Supplier eachSupplier : suppliersList) {
			insert(eachSupplier);
		}
	}

}


