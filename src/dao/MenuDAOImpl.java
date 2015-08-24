package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;

import persistence.DDBBMenu;
import persistence.DDBBSubMenu;
import model.Menu;
import model.Product;
import model.SubMenu;

public class MenuDAOImpl extends DaoImpl implements MenuDAO {
	
	private static final String SQL_MENU = "SELECT * FROM MENU ORDER BY ID_MENU";
	private static final String SQL_SUBMENU = "SELECT * FROM SUBMENU "
			+ "WHERE ID_MENU = ? ORDER BY ID_SUBMENU";

	public MenuDAOImpl(Connection connection, HttpSession session) {
		super(connection, session);
		// TODO Auto-generated constructor stub
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
			DDBBMenu ddbbMenu = new DDBBMenu();
			Menu menu = new Menu();
			statement = connection.prepareStatement(SQL_MENU);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				ddbbMenu.loadResult(resultSet);
				menu.setFromPersistence(ddbbMenu);
				try {
					DDBBSubMenu ddbbSubMenu = new DDBBSubMenu();
					SubMenu subMenu = new SubMenu();
					
					stmt = connection.prepareStatement(SQL_SUBMENU);
					stmt.setInt(1, ddbbMenu.getIdMenu());
					rs = stmt.executeQuery();
					
					while(rs.next()) {
						ddbbSubMenu.loadResult(rs);
						subMenu.setFromPersistence(ddbbSubMenu);
						menu.getSubMenus().add(subMenu);
					}
				} catch(SQLException e) {
					e.printStackTrace();
				}
				
				
			}
			theMenu.put(menu.getOrder(), menu);
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeStmtAndRs(stmt, rs);
			closeStmtAndRs(statement, resultSet);
			
		}
		return theMenu;
	}
	
}
