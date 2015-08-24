package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DDBBSubMenu {
	
	/** Static SQL sentence: DELETE. */
	private static final java.lang.String SQL_DELETE="DELETE /*DELETE*/ FROM SUBMENU WHERE ID_SUBMENU=? "
			+ "AND OPTIMIST_LOCK=?";
	
	/** Static SQL sentence: SELECT. */
	private static final java.lang.String SQL_READ="SELECT /*READ*/ * FROM SUBMENU WHERE ID_SUBMENU=?";
	
	/** Static SQL sentence: INSERT (all columns). */
	private static final java.lang.String SQL_INSERT="INSERT /*INSERT_ALL*/ INTO SUBMENU("
			+ "NAME,ORDER,LINK,IND_ACTIVE,KIND,ID_MENU, OPTIMIST_LOCK) "
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	
	private int idSubMenu;
	private String name;
	private int order;
	private String link;
	private boolean indActive;
	private String kind;
	private int idMenu;
	
	// 1 is not null, 2 is null
	private int idSubMenuNull;
	private int orderNull;
	private int indActiveNull;
	private int idMenuNull;
	
	public int getIdSubMenu() {
		return idSubMenu;
	}
	public void setIdSubMenu(int idSubMenu) {
		this.idSubMenu = idSubMenu;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public boolean getIndActive() {
		return indActive;
	}
	public void setIndActive(boolean indActive) {
		this.indActive = indActive;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getIdMenu() {
		return idMenu;
	}
	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}
	
	public boolean isIdSubMenuNull() {
		return idSubMenuNull == 2;
	}
	public void setIdSubMenuNull() {
		this.idSubMenuNull = 2;
	}
	public boolean isNameNull() {
		return name == null;
	}
	public void setNameNull() {
		this.name = null;
	}
	public boolean isOrderNull() {
		return orderNull == 2;
	}
	public void setOrderNull() {
		this.orderNull = 2;
	}
	public boolean isLinkNull() {
		return link == null;
	}
	public void setLinkNull() {
		this.link = null;
	}
	public boolean isIndActiveNull() {
		return indActiveNull == 2;
	}
	public void setIndActiveNull() {
		this.indActiveNull = 2;
	}
	public boolean isKindNull() {
		return kind == null;
	}
	public void setKindNull() {
		this.kind = null;
	}
	public boolean isIdMenuNull() {
		return idMenuNull == 2;
	}
	public void setIdMenuNull() {
		this.idMenuNull = 2;
	}
	
	public void loadResult(ResultSet rs) throws SQLException {
		
		setIdSubMenu(rs.getInt("ID_SUBMENU"));
		if(rs.wasNull()) {
			setIdSubMenuNull();
		}
		
		setIdMenu(rs.getInt("ID_MENU"));
		if(rs.wasNull()) {
			setIdMenuNull();
		}
		
		setName(rs.getString("NAME"));
		
		setOrder(rs.getInt("ORDER"));
		if(rs.wasNull()) {
			setOrderNull();
		}
		
		int active = rs.getInt("IND_ACTIVE");
		if(rs.wasNull()) {
			setIndActiveNull();
		} else {
			setIndActive(active == 1 ? true : false);
		}
		
		setLink(rs.getString("LINK"));
		setKind(rs.getString("KIND"));
					
	}

}
