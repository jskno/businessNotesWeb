package dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class SubMenuDAOImpl extends DaoImpl implements SubMenuDAO {

	public SubMenuDAOImpl(Connection connection, HttpSession session) {
		super(connection, session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Map<String, List<String>> getSubMenus() {
		// TODO Auto-generated method stub
		return null;
	}

}
