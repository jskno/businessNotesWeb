package model;

import java.util.ArrayList;
import java.util.List;

import persistence.DDBBMenu;
import persistence.DDBBSubMenu;

public class Menu {
	
	private Integer idMenu;
	private String name;
	private Integer order;
	private Boolean indActive;
	private List<SubMenu> subMenus;
			
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
	public boolean isIndActive() {
		return indActive;
	}
	public void setIndActive(boolean indActive) {
		this.indActive = indActive;
	}
	public List<SubMenu> getSubMenus() {
		return subMenus;
	}
	public void setSubMenus(List<SubMenu> subMenus) {
		this.subMenus = subMenus;
	}
	
	public DDBBMenu getPersistenceObject() {
		DDBBMenu ddbbMenu = new DDBBMenu();
		return ddbbMenu;
		
	}
	
	public final void setFromPersistence(final DDBBMenu ddbbMenu) {
		
		if(!ddbbMenu.isIdMenuNull()) {
			this.idMenu = ddbbMenu.getIdMenu();
		} else {
			this.idMenu = null;
		}
		if(!ddbbMenu.isIndActiveNull()) {
			this.indActive = ddbbMenu.getIndActive();
		} else {
			this.indActive = null;
		}
		if(!ddbbMenu.isNameNull()) {
			this.name = ddbbMenu.getName();
		} else {
			this.name = null;
		}
		if(!ddbbMenu.isOrderNull()) {
			this.order = ddbbMenu.getOrder();
		} else {
			this.order = null;
		}
		this.subMenus = new ArrayList<SubMenu>();
	}

}
