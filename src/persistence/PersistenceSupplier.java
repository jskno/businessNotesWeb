package persistence;

public class PersistenceSupplier {
	
	private int id;
	private int companyId;
	private String contactName;
	private String contactTelephone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
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
		return "Supplier [company=" + companyId + ", contactName=" + contactName
				+ ", contactTelephone=" + contactTelephone + "]";
	}
	
	

}
