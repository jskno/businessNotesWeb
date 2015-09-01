package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DDBBSupplier {
	
	private static final String INSERT_ALL = "insert into supplier (ROLE_ID, " +
			"DELIVERY_DAYS) values (?,?)";
	private static final String SQL_READ="SELECT * FROM supplier WHERE ROLE_ID=?";
	private static final String SQL_DELETE="DELETE FROM supplier WHERE ROLE_ID=?";
	
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
	
	public void insert(Connection connection) throws SQLException {
		
		final PreparedStatement ps = connection.prepareStatement(INSERT_ALL);
		int p=1;
		
		try
		{
			// SQL: ROLE_ID (INT):
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
			if (isDeliveryDaysNull())
			{
				ps.setNull(p, java.sql.Types.NUMERIC);
			}
			else
			{
				ps.setInt(p, getDeliveryDays());
			}
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ps.close();
		}
	}
	
	public static DDBBSupplier read(final Connection connection, int roleId)
			throws SQLException {
		
		final PreparedStatement ps = connection.prepareStatement(SQL_READ);
		ResultSet rs = null;
		int p = 1;
		try {
			ps.setInt(p, roleId);
			rs = ps.executeQuery();
			DDBBSupplier ddbbSupplier;
			if(rs.next()) {
				ddbbSupplier = new DDBBSupplier();
				ddbbSupplier.loadResult(rs);
			} else {
				ddbbSupplier = null;
			}
			return ddbbSupplier;
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
