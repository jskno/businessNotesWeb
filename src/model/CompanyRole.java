package model;

import persistence.DDBBCompanyRole;

public abstract class CompanyRole {
	
	private Integer roleId;
	private Company company;
	private RoleName roleName;
	private String contactName;
	private String contactTelephone;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public RoleName getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = RoleName.getRoleName(roleName);
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
		return this.company.getId();
	}
	public void setCompanyId(int companyId) {
		this.company.setId(companyId);
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
			ddbbCompanyRole.setCompanyId(getCompany().getId());
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
		
		Company company = new Company();
		if(!ddbbCompanyRole.isRoleIdNull()) {
			setRoleId(ddbbCompanyRole.getRoleId());
		} else {
			setRoleId(null);
		}
		if(!ddbbCompanyRole.isCompanyIdNull()) {
			company.setId((ddbbCompanyRole.getCompanyId()));
		} 
		setCompany(company);
		
		if(!ddbbCompanyRole.isRoleNameNull()) {
			setRoleName(ddbbCompanyRole.getRoleName());
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
}
