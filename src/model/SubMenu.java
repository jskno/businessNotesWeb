package model;

import persistence.DDBBSubMenu;

public class SubMenu {
	
	private Integer idSubMenu;
	private String name;
	private Integer order;
	private String link;
	private Boolean indActive;
	private String kind;
	private Integer idMenu;
	
	
	
	public Integer getIdSubMenu() {
		return idSubMenu;
	}

	public void setIdSubMenu(Integer idSubMenu) {
		this.idSubMenu = idSubMenu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Boolean getIndActive() {
		return indActive;
	}

	public void setIndActive(Boolean indActive) {
		this.indActive = indActive;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Integer getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	public final void setFromPersistence(final DDBBSubMenu ddbbSubMenu) {
		
		if (!ddbbSubMenu.isIdSubMenuNull()) {
			this.idSubMenu = ddbbSubMenu.getIdSubMenu();
		} else {
			this.idSubMenu = null;
		}
		if (!ddbbSubMenu.isIdMenuNull()) {
			this.idMenu = ddbbSubMenu.getIdMenu();
		} else {
			this.idMenu = null;
		}
		if (!ddbbSubMenu.isIndActiveNull()) {
			this.indActive = ddbbSubMenu.getIndActive();
		} else {
			this.indActive = null;
		}
		if (!ddbbSubMenu.isKindNull()) {
			this.kind = ddbbSubMenu.getKind();
		} else {
			this.kind = null;
		}
		if (!ddbbSubMenu.isLinkNull()) {
			this.link = ddbbSubMenu.getLink();
		} else {
			this.link = null;
		}
		if (!ddbbSubMenu.isNameNull()) {
			this.name = ddbbSubMenu.getName();
		} else {
			this.name = null;
		}
		if (!ddbbSubMenu.isOrderNull()) {
			this.order = ddbbSubMenu.getOrder();
		} else {
			this.order = null;
		}
				
	}
	
	public DDBBSubMenu getPersistenceObject() {
		
		final DDBBSubMenu ddbbSubMenu = new DDBBSubMenu();
		if(getIdSubMenu() != null) {
			ddbbSubMenu.setIdSubMenu(getIdSubMenu());
		} else {
			ddbbSubMenu.setIdSubMenuNull();
		}
		if(getIdMenu() != null) {
			ddbbSubMenu.setIdMenu(getIdMenu());
		} else {
			ddbbSubMenu.setIdMenuNull();
		}
		if(getIndActive() != null) {
			ddbbSubMenu.setIndActive(getIndActive());
		} else {
			ddbbSubMenu.setIndActiveNull();
		}
		if(getKind() != null) {
			ddbbSubMenu.setKind(getKind());
		} else {
			ddbbSubMenu.setKindNull();
		}
		if(getLink() != null) {
			ddbbSubMenu.setLink(getLink());
		} else {
			ddbbSubMenu.setLinkNull();
		}
		if(getName() != null) {
			ddbbSubMenu.setName(getName());
		} else {
			ddbbSubMenu.setNameNull();
		}
		if(getOrder() != null) {
			ddbbSubMenu.setOrder(getOrder());
		} else {
			ddbbSubMenu.setOrderNull();
		}
		return ddbbSubMenu;
	}

}
