package model;

public class Company {
	
	private int id;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	

}
