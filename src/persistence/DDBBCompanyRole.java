package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DDBBCompanyRole {
	
	private int roleId;
	private int companyId;
	private String roleName;
	private String contactName;
	private String contactTelephone;
	
	// 1 is not null, 2 is null
	private int roleIdNull;
	private int companyIdNull;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
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
	
	public boolean isRoleIdNull() {
		return this.roleIdNull == 2;
	}
	public void setRoleIdNull() {
		this.roleIdNull = 2;
	}
	public boolean isCompanyIdNull() {
		return companyIdNull == 2;
	}
	public void setCompanyIdNull() {
		this.companyIdNull = 2;
	}
	public boolean isRoleNameNull() {
		return getRoleName() == null;
	}
	public void setRoleNameNull() {
		setRoleName(null);
	}
	public boolean isContactNameNull() {
		return getContactName() == null;
	}
	public void setContactNameNull() {
		setContactName(null);
	}
	public boolean isContactTelephoneNull() {
		return getContactTelephone() == null;
	}
	public void setContactTelephoneNull() {
		setContactTelephone(null);
	}
	
	public void loadResult(ResultSet rs) throws SQLException {
		
		setRoleId(rs.getInt("ROLE_ID"));
		if(rs.wasNull()) {
			setRoleIdNull();
		}
		
		setCompanyId(rs.getInt("COMPANY_ID"));
		if(rs.wasNull()) {
			setCompanyIdNull();
		}
		
		setRoleName(rs.getString("ROLE_NAME"));
		setContactName(rs.getString("CONTACT_NAME"));
		setContactTelephone(rs.getString("CONTACT_TELEPHONE"));
		
	}
	
}
