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

}
