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
import model.SupplierVO;
import persistence.DDBBCompany;
import persistence.DDBBCompanyRole;
import persistence.DDBBSupplier;

public class SupplierDAOImpl extends DAOImpl implements SupplierDAO {
	
	private CompanyDAO companyDao;
	CompanyRoleDao companyRoleDao;
	
	public SupplierDAOImpl(Connection connection, HttpSession session) {
		super(connection, session);
		companyDao = new CompanyDAOImpl(connection, session);
		companyRoleDao = new CompanyRoleDaoImpl(connection, session);
	}
	
	public int insert(Object o){
		CompanyRoleVO companyRole = (CompanyRoleVO) o;
		int roleId = companyRoleDao.insert(companyRole);
		SupplierVO supplier = (SupplierVO) o;
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
	public SupplierVO getSupplierById(int roleId) {
		
		String sql = "select * from supplier where id = " + roleId;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		SupplierVO supplier = new SupplierVO();
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
	public List<SupplierVO> getSuppliersList() {
		
		List<SupplierVO> result = new ArrayList<SupplierVO>();
		
		String sql = "select * from supplier supp "
				+ "join company_role cr "
					+ "on supp.role_id = cr.role_id "
				+ "join company com "
					+ "on cr.company_id = com.company_id "
				+ "order by com.company_name";
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		SupplierVO supplier = null;
		
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
	public void insertList(List<SupplierVO> suppliersList) {

		for(SupplierVO eachSupplier : suppliersList) {
			insert(eachSupplier);
		}
	}
	
	@Override
	public SupplierVO getSupplierByTaxID(String taxID) {
		
		SupplierVO supplier = null;
		
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
	
	private SupplierVO getSupplierFromRs(ResultSet rs) throws SQLException {
		
		SupplierVO supplier;
		CompanyVO company;
		
		DDBBSupplier ddbbSupplier = new DDBBSupplier();
		DDBBCompanyRole ddbbCompanyRole = new DDBBCompanyRole();
		DDBBCompany ddbbCompany = new DDBBCompany();
		
		ddbbCompany.loadResult(rs);
		ddbbCompanyRole.loadResult(rs);
		ddbbSupplier.loadResult(rs);
				
		company = new CompanyVO(ddbbCompany);
		supplier = new SupplierVO(ddbbCompanyRole, ddbbSupplier);
		supplier.setCompany(company);
		
		return supplier;
	}

}


