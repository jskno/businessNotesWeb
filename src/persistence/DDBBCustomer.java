package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DDBBCustomer {
	
	/** Static SQL FOR UPDATE sentence: SELECT ... FOR UPDATE. */
	private static final String SQL_READ_FOR_UPDATE="SELECT * FROM customer WHERE ROLE_ID=? FOR UPDATE";

	/** Static SQL sentence: INSERT (all columns). */
	private static final String INSERT_ALL="INSERT /*INSERT_ALL*/ INTO customer(ROLE_ID, CREDIT_RATING, CUSTOMER_DISCOUNT) VALUES(?,?,?)"; //SEC_GCCC_VPSUPPLIESLIST1.NEXTVAL

	/** Static SQL sentence: DELETE. */
	private static final String SQL_DELETE="DELETE FROM customer WHERE ROLE_ID=?"; // AND OPTIMIST_LOCK=?";

	/** Static SQL sentence: SELECT. */
	private static final String SQL_READ="SELECT * FROM customer WHERE ROLE_ID=?";

	private int roleId;
	private int creditRating;
	private double customerDiscount;
	
	private int roleIdNull;
	private int creditRatingNull;
	private int customerDiscountNull;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getCreditRating() {
		return creditRating;
	}
	public void setCreditRating(int creditRating) {
		this.creditRating = creditRating;
	}
	public double getCustomerDiscount() {
		return customerDiscount;
	}
	public void setCustomerDiscount(double customerDiscount) {
		this.customerDiscount = customerDiscount;
	}
	
	private int getRoleIdNull() {
		return roleIdNull;
	}
	public boolean isRoleIdNull() {
		return getRoleIdNull() == 2;
	}
	public void setRoleIdNull() {
		this.roleIdNull = 2;
	}
	
	private int getCreditRatingNull() {
		return creditRatingNull;
	}
	public void setCreditRatingNull() {
		this.creditRatingNull = 2;
	}
	public boolean isCreditRatingNull() {
		return getCreditRatingNull() == 2;
	}
	
	private int getCustomerDiscountNull() {
		return customerDiscountNull;
	}
	public void setCustomerDiscountNull() {
		this.customerDiscountNull = 2;
	}
	public boolean isCustomerDiscountNull() {
		return getCustomerDiscountNull() == 2;
	}
	
	public void loadResult(ResultSet rs) throws SQLException {
		
		this.setRoleId(rs.getInt("ROLE_ID"));
		if(rs.wasNull()) {
			this.setRoleIdNull();
		}
		this.setCreditRating(rs.getInt("CREDIT_RATING"));
		if(rs.wasNull()) {
			this.setCreditRatingNull();
		}
		this.setCustomerDiscount(rs.getDouble("CUSTOMER_DISCOUNT"));
		if(rs.wasNull()) {
			this.setCustomerDiscountNull();
		}
	}
	
	public void insert(Connection connection) throws SQLException {
		
		final PreparedStatement ps = connection.prepareStatement(INSERT_ALL);
		int p=1;
		
		try
		{
			// SQL: NOTE_ID (INT):
			if (isRoleIdNull())
			{
				ps.setNull(p, java.sql.Types.NUMERIC);
			}
			else
			{
				ps.setInt(p, getRoleId());
			}
			p++;
			// SQL: USER_ID (INT):
			if (isCreditRatingNull())
			{
				ps.setNull(p, java.sql.Types.NUMERIC);
			}
			else
			{
				ps.setInt(p, getCreditRating());
			}
			p++;
			// SQL: CREATION_DATE (DOUBLE):
			if (isCustomerDiscountNull())
			{
				ps.setNull(p, java.sql.Types.DECIMAL);
			}
			else
			{
				ps.setDouble(p, getCustomerDiscount());
			}
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ps.close();
		}
			
	}
	
	public static DDBBCustomer read(final Connection connection, int roleId)
			throws SQLException {
		
		final PreparedStatement ps = connection.prepareStatement(SQL_READ);
		ResultSet rs = null;
		int p = 1;
		try {
			ps.setInt(p, roleId);
			rs = ps.executeQuery();
			DDBBCustomer ddbbCustomer;
			if(rs.next()) {
				ddbbCustomer = new DDBBCustomer();
				ddbbCustomer.loadResult(rs);
			} else {
				ddbbCustomer = null;
			}
			return ddbbCustomer;
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
