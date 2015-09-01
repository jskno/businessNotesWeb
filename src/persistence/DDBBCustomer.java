package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DDBBCustomer {
	
	/** Static SQL FOR UPDATE sentence: SELECT ... FOR UPDATE. */
	private static final java.lang.String SQL_READ_FOR_UPDATE="SELECT /*UPDATE LOB*/ * FROM GCCC_VP_SUPPLIES_LIST WHERE ID_SUPPLIES_LIST=? FOR UPDATE";

	/** Static SQL sentence: INSERT (all columns). */
	private static final java.lang.String SQL_INSERT_ALL="INSERT /*INSERT_ALL*/ INTO customer(CREDIT_RATING, CUSTOMER_DISCOUNT) VALUES(?,?)"; //SEC_GCCC_VPSUPPLIESLIST1.NEXTVAL

	/** Static SQL sentence: DELETE. */
	private static final java.lang.String SQL_DELETE="DELETE /*DELETE*/ FROM customer WHERE ROLE_ID=?"; // AND OPTIMIST_LOCK=?";

	/** Static SQL sentence: SELECT. */
	private static final java.lang.String SQL_READ="SELECT /*READ*/ * FROM customer WHERE ROLE_ID=?";

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
		
}
