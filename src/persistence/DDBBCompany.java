package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DDBBCompany {
	
	private static final String INSERT_ALL = "insert into company (TAX_ID" +
		"COMPANY_NAME, COMPANY_TELEPHONE, COMPANY_EMAIL) values (?,?,?,?)";
	private static final String LAST_ID = "SELECT LAST_INSERT_ID()";
	private static final String SQL_READ="SELECT * FROM company WHERE COMPANY_ID=?";
	private static final String SQL_DELETE="DELETE FROM company WHERE COMPANY_ID=?";
	
	private int companyId;
	private String taxID;
	private String companyName;
	private String companyTelephone;
	private String companyEmail;
	
	// 1 is not null, 2 is null
	private int companyIdNull;
		
	public int getCompanyId() {
		return companyId;
	}
	public void setId(int companyId) {
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
	
	// Fields to indicate and set a primitive values to Null
	private int getCompanyIdNull() {
		return companyIdNull;
	}
	public boolean isCompanyIdNull() {
		return getCompanyIdNull() == 2;
	}
	public void setCompanyIdNull() {
		this.companyIdNull = 2;
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
		
		setId(rs.getInt("COMPANY_ID"));
		if(rs.wasNull()) {
			setCompanyIdNull();
		}
		
		setTaxID(rs.getString("TAX_ID"));
		setCompanyName(rs.getString("COMPANY_NAME"));
		setCompanyTelephone(rs.getString("COMPANY_TELEPHONE"));
		setCompanyEmail(rs.getString("COMPANY_EMAIL"));
					
	}
	
	public int insert(Connection connection) throws SQLException {
		
		int lastKey;		
		final PreparedStatement ps = connection.prepareStatement(INSERT_ALL);
		final Statement stmt = connection.createStatement();
		ResultSet rs = null;
		int p=1;
		
		try
		{
			// SQL: TAX_ID (STRING):
			if (isTaxIDNull())
			{
				ps.setNull(p, java.sql.Types.VARCHAR);
			}
			else
			{
				ps.setString(p, getTaxID());
			}
			p++;
			// SQL: COMPANY_NAME (STRING):
			if (isCompanyNameNull())
			{
				ps.setNull(p, java.sql.Types.VARCHAR);
			}
			else
			{
				ps.setString(p, getCompanyName());
			}
			p++;
			// SQL: COMPANY_TELEPHONE (STRING):
			if (isCompanyTelephoneNull())
			{
				ps.setNull(p, java.sql.Types.VARCHAR);
			}
			else
			{
				ps.setString(p, getCompanyTelephone());
			}
			p++;
			// SQL: COMPANY_EMAIL (STRING):
			if (isCompanyEmailNull())
			{
				ps.setNull(p, java.sql.Types.VARCHAR);
			}
			else
			{
				ps.setString(p, getCompanyEmail());
			}
			ps.executeUpdate();
			
			rs = stmt.executeQuery(LAST_ID);
			lastKey = rs.getInt(0);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ps.close();
			rs.close();
			stmt.close();
		}
			
		return lastKey;
	}
	
	public static DDBBCompany read(final Connection connection, int companyId)
			throws SQLException {
		
		final PreparedStatement ps = connection.prepareStatement(SQL_READ);
		ResultSet rs = null;
		int p = 1;
		try {
			ps.setInt(p, companyId);
			rs = ps.executeQuery();
			DDBBCompany ddbbCompany;
			if(rs.next()) {
				ddbbCompany = new DDBBCompany();
				ddbbCompany.loadResult(rs);
			} else {
				ddbbCompany = null;
			}
			return ddbbCompany;
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
			ps.setInt(p++, getCompanyId());
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
