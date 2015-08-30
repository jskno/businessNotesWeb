package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;

import persistence.DDBBMenu;
import persistence.DDBBSubMenu;
import model.Menu;
import model.ProductVO;
import model.SubMenu;

public class MenuDAOImpl extends DaoImpl implements MenuDAO {
	
	private static final String SQL_MENU = "SELECT * FROM MENU ORDER BY ID_MENU";
	private static final String SQL_SUBMENU = "SELECT * FROM SUBMENU "
			+ "WHERE ID_MENU = ? ORDER BY ID_SUBMENU";

	public MenuDAOImpl(Connection connection, HttpSession session) {
		super(connection, session);
	}

	@Override
	public Map<Integer, Menu> getMenu() {

		Map<Integer, Menu> theMenu = new TreeMap<Integer, Menu>();
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		//Product product = new Product();
		try {
			DDBBMenu ddbbMenu = null;
			Menu menu = null;
			statement = connection.prepareStatement(SQL_MENU);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				ddbbMenu = new DDBBMenu();
				menu = new Menu();
				
				ddbbMenu.loadResult(resultSet);
				menu.setFromPersistence(ddbbMenu);
				try {
					DDBBSubMenu ddbbSubMenu = null;
					SubMenu subMenu = null;
					
					stmt = connection.prepareStatement(SQL_SUBMENU);
					stmt.setInt(1, ddbbMenu.getIdMenu());
					rs = stmt.executeQuery();
					
					while(rs.next()) {
						ddbbSubMenu = new DDBBSubMenu();
						subMenu = new SubMenu();
						
						ddbbSubMenu.loadResult(rs);
						subMenu.setFromPersistence(ddbbSubMenu);
						menu.getSubMenus().add(subMenu);
					}
				} catch(SQLException e) {
					e.printStackTrace();
				}
				Collections.sort(menu.getSubMenus());
				theMenu.put(menu.getOrder(), menu);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeStmtAndRs(stmt, rs);
			closeStmtAndRs(statement, resultSet);
			
		}
		return theMenu;
	}
	
}
