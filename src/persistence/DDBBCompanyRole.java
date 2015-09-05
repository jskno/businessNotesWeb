package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DDBBCompanyRole {
	
	private static final String INSERT_ALL = "insert into company_role (COMPANY_ID, " +
		"ROLE_NAME, CONTACT_NAME, CONTACT_TELEPHONE) values (?,?,?,?)";
	private static final String LAST_ID = "SELECT LAST_INSERT_ID()";
	private static final String SQL_READ="SELECT * FROM company_role WHERE ROLE_ID=?";
	private static final String SQL_DELETE="DELETE FROM company_role WHERE ROLE_ID=?";
	
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
	
	public int insert(Connection connection) throws SQLException {
		
		Integer lastKey = null;		
		final PreparedStatement ps = connection.prepareStatement(INSERT_ALL);
		final Statement stmt = connection.createStatement();
		ResultSet rs = null;
		int p=1;
		
		try
		{
			// SQL: COMPANY_ID (INT):
			if (isCompanyIdNull())
			{
				ps.setNull(p, java.sql.Types.NUMERIC);
			}
			else
			{
				ps.setInt(p, getCompanyId());
			}
			p++;
			// SQL: ROLE_NAME (INT):
			if (isRoleNameNull())
			{
				ps.setNull(p, java.sql.Types.VARCHAR);
			}
			else
			{
				ps.setString(p, getRoleName());
			}
			p++;
			// SQL: CONTACT_NAME (STRING):
			if (isContactNameNull())
			{
				ps.setNull(p, java.sql.Types.VARCHAR);
			}
			else
			{
				ps.setString(p, getContactName());
			}
			p++;
			// SQL: CONTACT_TELEPHONE (STRING):
			if (isContactTelephoneNull())
			{
				ps.setNull(p, java.sql.Types.VARCHAR);
			}
			else
			{
				ps.setString(p, getContactTelephone());
			}
			ps.executeUpdate();
			
			rs = stmt.executeQuery(LAST_ID);
			if(rs.next()) {
				lastKey = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			rs.close();
			stmt.close();
			ps.close();
		}
			
		return lastKey;
	}
	
	public static DDBBCompanyRole read(final Connection connection, int roleId)
			throws SQLException {
		
		final PreparedStatement ps = connection.prepareStatement(SQL_READ);
		ResultSet rs = null;
		int p = 1;
		try {
			ps.setInt(p, roleId);
			rs = ps.executeQuery();
			DDBBCompanyRole ddbbCompanyRole;
			if(rs.next()) {
				ddbbCompanyRole = new DDBBCompanyRole();
				ddbbCompanyRole.loadResult(rs);
			} else {
				ddbbCompanyRole = null;
			}
			return ddbbCompanyRole;
		} finally {
			if(rs != null) {
				rs.close();
			}
			ps.close();
		}
	}
	
	public boolean delete(final Connection connection)
			throws java.sql.SQLException {
		
		PreparedStatement ps=connection.prepareStatement(SQL_DELETE);
		int p=1;
		try	{
			ps.setInt(p++, getRoleId());
			//ps.setLong(p++, this.myOptimistLock);
					
			if (ps.executeUpdate() <= 0) {
				throw new SQLException();
			}
		} finally {
			ps.close();
		}
		return true;
	}
}
