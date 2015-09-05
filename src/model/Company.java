package model;

import persistence.DDBBCompany;

public class Company {
	
	private Integer companyId;
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
	
	public Company(DDBBCompany ddbbCompany) {
		this.setFromPersistence(ddbbCompany);
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setId(Integer companyId) {
		this.companyId = companyId;
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
			this.companyId = ddbbCompany.getCompanyId();
		} else {
			this.companyId = null;
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
		if(getCompanyId() != null) {
			ddbbCompany.setId(getCompanyId());
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
	
	public String toJson() {
		StringBuffer sb = new StringBuffer();
		sb.append("<company>");
		sb.append("<companyId>" + getCompanyId() + "</companyId>");
		sb.append("<taxID>" + getTaxID() + "</taxID>");
		sb.append("<companyName>" + getCompanyName() + "</companyName>");
		sb.append("<companyTelephone>" + getCompanyTelephone() + "</companyTelephone>");
		sb.append("<companyEmail>" + getCompanyEmail() + "</companyEmail>");
		sb.append("</company>");
		sb.append("<companyAdded>1</companyAdded>");
		return sb.toString();
		
	}

}
