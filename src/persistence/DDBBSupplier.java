package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;


public class DDBBSupplier {
	
	private int roleId;
	private int deliveryDays;
	
	// 0 is not null, 2 is null
	private int roleIdNull;
	private int deliveryDaysNull;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getDeliveryDays() {
		return deliveryDays;
	}
	public void setDeliveryDays(int deliveryDays) {
		this.deliveryDays = deliveryDays;
	}
	
	public int getRoleIdNull() {
		return roleIdNull;
	}
	public void setRoleIdNull() {
		this.roleIdNull = 2;
	}
	public boolean isRoleIdNull() {
		return getRoleIdNull() == 2;
	}
	public int getDeliveryDaysNull() {
		return deliveryDaysNull;
	}
	public void setDeliveryDaysNull() {
		this.deliveryDaysNull = 2;
	}
	public boolean isDeliveryDaysNull() {
		return getDeliveryDaysNull() == 2;
	}
	
	public void loadResult(ResultSet rs) throws SQLException {
		
		setRoleId(rs.getInt("ROLE_ID"));
		if(rs.wasNull()) {
			setRoleIdNull();
		}
		setDeliveryDays(rs.getInt("DELIVERY_DAYS"));
		if(rs.wasNull()) {
			setDeliveryDaysNull();
		}
	}
	

}
