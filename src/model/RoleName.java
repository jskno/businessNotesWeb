package model;

public enum RoleName {
	
	CUSTOMER ("Customer"),
	SUPPLIER ("Supplier");
	
	private final String desc;
	
	RoleName(String desc) {
		this.desc = desc;
	}

	public String desc() {
		return this.desc;
	}
	
	public static RoleName getRoleName(String roleName) {
		RoleName role = null;
		for(RoleName eachRole : RoleName.values()) {
			if(eachRole.desc().equals(roleName)) {
				role = eachRole;
				break;
			}
		}
		return role;
	}
	
	

}
