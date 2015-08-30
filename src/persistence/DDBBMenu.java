package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DDBBMenu {
	
	private int idMenu;	
	private String name;
	private int order;
	private boolean indActive;
	
	private int idMenuNull;
	private int orderNull;
	private int indActiveNull;
	
	public int getIdMenu() {
		return idMenu;
	}
	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
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
	public boolean getIndActive() {
		return indActive;
	}
	public void setIndActive(boolean indActive) {
		this.indActive = indActive;
	}
	
	// 0 is not null, 2 is null
	public boolean isIdMenuNull() {
		return idMenuNull == 2;
	}
	public void setIdMenuNull() {
		this.idMenuNull = 2;
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
	public boolean isIndActiveNull() {
		return indActiveNull == 2;
	}
	public void setIndActiveNull() {
		this.indActiveNull = 2;
	}
	
public void loadResult(ResultSet rs) throws SQLException {
		
		setIdMenu(rs.getInt("ID_MENU"));
		if(rs.wasNull()) {
			setIdMenuNull();
		}
		
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
		
		setName(rs.getString("NAME"));
	}

}