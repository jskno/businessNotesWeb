package dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import model.Menu;

public class SubMenuDAOImpl extends DaoImpl implements MenuDAO {

	public SubMenuDAOImpl(Connection connection, HttpSession session) {
		super(connection, session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Map<Integer, Menu> getMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Object o) {
		// TODO Auto-generated method stub
		return 0;
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
