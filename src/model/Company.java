package model;

import persistence.DDBBCompany;

public class Company {
	
	private Integer id;
	private String taxID;
	private String companyName;
	private String companyTelephone;
	private String companyEmail;
	
	public Company () {
		
	}
	public Company(String companyName, String companyTelephone,
			String companyEmail) {
		
		this.companyName = companyName;
		this.companyTelephone = companyTelephone;
		this.companyEmail = companyEmail;
		
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTaxID() {
		return taxID;
	}
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyTelephone() {
		return companyTelephone;
	}
	public void setCompanyTelephone(String companyTelephone) {
		this.companyTelephone = companyTelephone;
	}
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	@Override
	public String toString() {
		return "Company [companyName=" + companyName + ", companyTelephone="
				+ companyTelephone + ", companyEmail=" + companyEmail + "]";
	}
	
	public final void setFromPersistence(final DDBBCompany ddbbCompany) {
		
		if (!ddbbCompany.isCompanyIdNull()) {
			this.id = ddbbCompany.getCompanyId();
		} else {
			this.id = null;
		}
		if (!ddbbCompany.isTaxIDNull()) {
			this.taxID = ddbbCompany.getTaxID();
		} else {
			this.taxID = null;
		}
		if (!ddbbCompany.isCompanyNameNull()) {
			this.companyName = ddbbCompany.getCompanyName();
		} else {
			this.companyName = null;
		}
		if (!ddbbCompany.isCompanyTelephoneNull()) {
			this.companyTelephone = ddbbCompany.getCompanyTelephone();
		} else {
			this.companyTelephone = null;
		}
		if (!ddbbCompany.isCompanyEmailNull()) {
			this.companyEmail = ddbbCompany.getCompanyEmail();
		} else {
			this.companyEmail = null;
		}
	}
	
	public DDBBCompany getPersistenceObject() {
		
		final DDBBCompany ddbbCompany = new DDBBCompany();
		if(getId() != null) {
			ddbbCompany.setId(getId());
		} else {
			ddbbCompany.setCompanyIdNull();
		}
		if(getTaxID() != null) {
			ddbbCompany.setTaxID(getTaxID());
		} else {
			ddbbCompany.setTaxIDNull();
		}
		if(getCompanyName() != null) {
			ddbbCompany.setCompanyName(getCompanyName());
		} else {
			ddbbCompany.setCompanyNameNull();
		}
		if(getCompanyTelephone() != null) {
			ddbbCompany.setCompanyTelephone(getCompanyTelephone());
		} else {
			ddbbCompany.setCompanyTelephoneNull();
		}
		if(getCompanyEmail() != null) {
			ddbbCompany.setCompanyEmail(getCompanyEmail());
		} else {
			ddbbCompany.setCompanyEmailNull();
		}
		
		return ddbbCompany;
	}
	

}
