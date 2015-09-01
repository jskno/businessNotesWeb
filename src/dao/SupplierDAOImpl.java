package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import persistence.DDBBSupplier;
import model.Company;
import model.Supplier;

public class SupplierDAOImpl extends DaoImpl implements SupplierDAO {
	
	private CompanyDAO companyDao;
	
	private static final String INSERT = "insert into supplier (ROLE_ID, DELIVERY_DAYS)"
			+ " values (?,?)";
	
	public SupplierDAOImpl(Connection connection, HttpSession session) {
		super(connection, session);
	}
	
	public void insert(Object o){
		Supplier supplier = (Supplier) o;
		DDBBSupplier ddbbSupplier = supplier.getPersistenceSupplier();
		
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(INSERT);
			ps.setInt(1, ddbbSupplier.getRoleId());
			ps.setInt(2, ddbbSupplier.getDeliveryDays());
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
	public Supplier getSupplierById(int roleId) {
		
		String sql = "select * from supplier where id = " + roleId;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		Supplier supplier = new Supplier();
		DDBBSupplier ddbbSupplier = new DDBBSupplier();
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			ddbbSupplier.loadResult(resultSet);
			supplier.setFromPersistenceObject(ddbbSupplier);
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
		
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			Supplier supplier = new Supplier();
			DDBBSupplier ddbbSupplier = new DDBBSupplier();
			while (resultSet.next()) {
				ddbbSupplier.loadResult(resultSet);
				supplier.setFromPersistenceObject(ddbbSupplier);
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
	public List<DDBBSupplier> getPersistenceCustomerList() {
		
		List<DDBBSupplier> result = new ArrayList<DDBBSupplier>();
		
		String sql = "select * from supplier";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		DDBBSupplier ddbbSupplier = new DDBBSupplier();
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				ddbbSupplier.loadResult(resultSet);
				result.add(ddbbSupplier);
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


