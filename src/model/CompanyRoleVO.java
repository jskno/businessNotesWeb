package model;

import persistence.DDBBCompanyRole;

public abstract class CompanyRoleVO {
	
	private Integer roleId;
	private CompanyVO company;
	private RoleName roleName;
	private String contactName;
	private String contactTelephone;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public CompanyVO getCompany() {
		return company;
	}
	public void setCompany(CompanyVO company) {
		this.company = company;
	}
	public RoleName getRoleName() {
		return roleName;
	}
	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactTelephone() {
		return contactTelephone;
	}
	public void setContactTelephone(String contactTelephone) {
		this.contactTelephone = contactTelephone;
	}
	
	public int getCompanyId() {
		return this.company.getCompanyId();
	}
	public void setCompanyId(int companyId) {
		this.company.setCompanyId(companyId);
	}
	public String getCompanyTaxID() {
		return this.company.getTaxID();
	}
	public void setCompanyTaxID(String taxID) {
		this.company.setTaxID(taxID);
	}
	public String getCompanyName() {
		return this.company.getCompanyName();
	}
	public void setCompanyName(String companyName) {
		this.company.setCompanyName(companyName);
	}
	public String getCompanyTelephone() {
		return this.company.getCompanyTelephone();
	}
	public void setCompanyTelephone(String companyTelephone) {
		this.company.setCompanyTelephone(companyTelephone);
	}
	public String getCompanyEmail() {
		return this.company.getCompanyEmail();
	}
	public void setCompanyEmail(String companyEmail) {
		this.company.setCompanyEmail(companyEmail);
	}
	
	public DDBBCompanyRole getPersistenceObject() {
		DDBBCompanyRole ddbbCompanyRole = new DDBBCompanyRole();
		if(getRoleId() != null) {
			ddbbCompanyRole.setRoleId(getRoleId());
		} else {
			ddbbCompanyRole.setRoleIdNull();
		}
		if(getCompany() != null) {
			ddbbCompanyRole.setCompanyId(getCompany().getCompanyId());
		} else {
			ddbbCompanyRole.setCompanyIdNull();
		}
		if(getRoleName() != null) {
			ddbbCompanyRole.setRoleName(getRoleName().desc());
		} else {
			ddbbCompanyRole.setRoleNameNull();
		}
		if(getContactName() != null) {
			ddbbCompanyRole.setContactName(getContactName());
		} else {
			ddbbCompanyRole.setContactNameNull();
		}
		if(getContactTelephone() != null) {
			ddbbCompanyRole.setContactTelephone(getContactTelephone());
		} else {
			ddbbCompanyRole.setContactTelephoneNull();
		}
		
		return ddbbCompanyRole;
	}
	
	public void setFromPersistenceObject(final DDBBCompanyRole ddbbCompanyRole) {
		
		CompanyVO company = new CompanyVO();
		if(!ddbbCompanyRole.isRoleIdNull()) {
			setRoleId(ddbbCompanyRole.getRoleId());
		} else {
			setRoleId(null);
		}
		if(!ddbbCompanyRole.isCompanyIdNull()) {
			company.setCompanyId((ddbbCompanyRole.getCompanyId()));
		} 
		setCompany(company);
		
		if(!ddbbCompanyRole.isRoleNameNull()) {
			setRoleName(RoleName.getRoleName(ddbbCompanyRole.getRoleName()));
		} else {
			setRoleName(null);
		}
		if(!ddbbCompanyRole.isContactNameNull()) {
			setContactName(ddbbCompanyRole.getContactName());
		} else {
			setContactName(null);
		}
		if(!ddbbCompanyRole.isContactTelephoneNull()) {
			setContactTelephone(ddbbCompanyRole.getContactTelephone());
		} else {
			setContactTelephone(null);
		}
	}
	
	@Override
	public String toString() {
		return "CompanyRole [getRoleId()=" + getRoleId() + ", getRoleName()="
				+ getRoleName() + ", getContactName()=" + getContactName()
				+ ", getContactTelephone()=" + getContactTelephone()
				+ ", getCompanyId()=" + getCompanyId() + ", getCompanyTaxID()="
				+ getCompanyTaxID() + ", getCompanyName()=" + getCompanyName()
				+ ", getCompanyTelephone()=" + getCompanyTelephone()
				+ ", getCompanyEmail()=" + getCompanyEmail() + "]";
	}
	
	public String toJson() {
		StringBuffer sb = new StringBuffer();
		sb.append("<companyRole>");
	    sb.append("<roleId>" + getRoleId() + "</roleId>");
	    sb.append("<roleName>" + getRoleName() + "</roleName>");
	    sb.append("<contactName>" + getContactName() + "</contactName>");
	    sb.append("<contactTelephone>" + getContactTelephone() + "</contactTelephone>");
	    sb.append(getCompany().toJson());
	    sb.append("</companyRole>");
	    sb.append("<companyRoleAdded>1</companyRoleAdded>");
		return sb.toString();
				
	}
}
