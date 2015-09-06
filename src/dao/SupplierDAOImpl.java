package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.Company;
import model.CompanyRole;
import model.Supplier;
import persistence.DDBBCompany;
import persistence.DDBBCompanyRole;
import persistence.DDBBSupplier;

public class SupplierDAOImpl extends DaoImpl implements SupplierDAO {
	
	private CompanyDAO companyDao;
	CompanyRoleDao companyRoleDao;
	
	public SupplierDAOImpl(Connection connection, HttpSession session) {
		super(connection, session);
		companyDao = new CompanyDAOImpl(connection, session);
		companyRoleDao = new CompanyRoleDaoImpl(connection, session);
	}
	
	public int insert(Object o){
		CompanyRole companyRole = (CompanyRole) o;
		int roleId = companyRoleDao.insert(companyRole);
		Supplier supplier = (Supplier) o;
		supplier.setRoleId(roleId);
		DDBBSupplier ddbbSupplier = supplier.getPersistenceSupplier();
		int newSupplierId = -1;
		
		try {
			newSupplierId = ddbbSupplier.insert(connection);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return newSupplierId;
		
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
		
		String sql = "select * from supplier supp "
				+ "join company_role cr "
					+ "on supp.role_id = cr.role_id "
				+ "join company com "
					+ "on cr.company_id = com.company_id "
				+ "order by com.company_name";
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		Supplier supplier = null;
		
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				supplier = getSupplierFromRs(resultSet);
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
	
	@Override
	public Supplier getSupplierByTaxID(String taxID) {
		
		Supplier supplier = null;
		
		String sql = "select * from supplier supp"
			+ " left join COMPANY_ROLE cr"
					+ " on supp.ROLE_ID = cr.ROLE_ID"
			+ " left join company com"
					+ " on cr.COMPANY_ID = com.COMPANY_ID"
			+ " where com.TAX_ID =?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, taxID);
			rs = ps.executeQuery();
			while (rs.next()) {
				supplier = getSupplierFromRs(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeStmtAndRs(ps, rs);
		}
		return supplier;
	}
	
	private Supplier getSupplierFromRs(ResultSet rs) throws SQLException {
		
		Supplier supplier;
		Company company;
		
		DDBBSupplier ddbbSupplier = new DDBBSupplier();
		DDBBCompanyRole ddbbCompanyRole = new DDBBCompanyRole();
		DDBBCompany ddbbCompany = new DDBBCompany();
		
		ddbbCompany.loadResult(rs);
		ddbbCompanyRole.loadResult(rs);
		ddbbSupplier.loadResult(rs);
				
		company = new Company(ddbbCompany);
		supplier = new Supplier(ddbbCompanyRole, ddbbSupplier);
		supplier.setCompany(company);
		
		return supplier;
	}

}


