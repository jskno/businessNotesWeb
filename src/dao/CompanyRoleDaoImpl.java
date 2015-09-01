package dao;

import java.sql.Connection;

import javax.servlet.http.HttpSession;

import model.CompanyRole;

public class CompanyRoleDaoImpl extends DaoImpl implements CompanyRoleDao {
	
	public CompanyRoleDaoImpl(Connection connection, HttpSession sessionn) {
		super(connection, sessionn);
	}

	@Override
	public void insert(Object o) {
		
		CompanyRole role = (CompanyRole) o;
		
		
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


