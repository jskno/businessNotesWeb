package model;

public class Supplier {
	
	private int id;
	private Company company;
	private String contactName;
	private String contactTelephone;
	
	public Supplier() {
		
	}
	
	public Supplier(Company company, String contactName,
			String contactTelephone) {
		
		this.company = company;
		this.contactName = contactName;
		this.contactTelephone = contactTelephone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
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
	@Override
	public String toString() {
		return "Supplier [company=" + company + ", contactName=" + contactName
				+ ", contactTelephone=" + contactTelephone + "]";
	}
	
	

}
