package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DDBBCompany {
	
	private int id;
	private String taxID;
	private String companyName;
	private String companyTelephone;
	private String companyEmail;
	
	// 1 is not null, 2 is null
	private int idNull;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	
	// Fields to indicate and set a primitive values to Null
	public int getIdNull() {
		return idNull;
	}
	public boolean isIdNull() {
		return getIdNull() == 2;
	}
	public void setIdNull() {
		this.idNull = 2;
	}
	
	// Fields to indicate and set object values to null.
	public boolean isTaxIDNull() {
		return getTaxID() == null;
	}
	public void setTaxIDNull() {
		setTaxID(null);
	}
	public boolean isCompanyNameNull() {
		return getCompanyName() == null;
	}
	public void setCompanyNameNull() {
		setCompanyName(null);
	}
	public boolean isCompanyTelephoneNull() {
		return getCompanyTelephone() == null;
	}
	public void setCompanyTelephoneNull() {
		setCompanyTelephone(null);
	}
	public boolean isCompanyEmailNull() {
		return getCompanyEmail() == null;
	}
	public void setCompanyEmailNull() {
		setCompanyEmail(null);
	}
		
	public void loadResult(ResultSet rs) throws SQLException {
		
		setId(rs.getInt("ID"));
		if(rs.wasNull()) {
			setIdNull();
		}
		
		setTaxID(rs.getString("TAX_ID"));
		setCompanyName(rs.getString("COMPANY_NAME"));
		setCompanyTelephone(rs.getString("COMPANY_TELEPHONE"));
		setCompanyEmail(rs.getString("COMPANY_EMAIL"));
					
	}

}
