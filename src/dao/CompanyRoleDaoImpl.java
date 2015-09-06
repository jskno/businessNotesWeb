package dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import persistence.DDBBCompanyRole;
import model.CompanyRoleVO;

public class CompanyRoleDaoImpl extends DaoImpl implements CompanyRoleDao {
	
	public CompanyRoleDaoImpl(Connection connection, HttpSession sessionn) {
		super(connection, sessionn);
	}

	@Override
	public int insert(Object o) {
		
		CompanyRoleVO companyRole = (CompanyRoleVO) o;
		DDBBCompanyRole ddbbCompanyRole = companyRole.getPersistenceObject();
		int newCompanyRoleId = -1;
		
		try {
			newCompanyRoleId = ddbbCompanyRole.insert(connection);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return newCompanyRoleId;		
	}

	@Override
	public Object search(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub
		
	}
	

}


