package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DDBBProductsOrder {
	
	private static final String INSERT_ALL = "insert into products_order (CREATION_DATE, " +
		"SUPPLIER_ID, CUSTOMER_ID) values (?,?,?)";
	private static final String LAST_ID = "SELECT LAST_INSERT_ID()";
	private static final String SQL_READ="SELECT * FROM products_order WHERE ORDER_ID=?";
	private static final String SQL_DELETE="DELETE FROM products_order WHERE ORDER_ID=?";
	
	private int orderId;
	private Date creationDate;
	private int supplierId;
	private int customerId;
	
	private int orderIdNull;
	private int supplierIdNull;
	private int customerIdNull;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	private int getOrderIdNull() {
		return orderIdNull;
	}
	public void setOrderIdNull() {
		this.orderIdNull = 2;
	}
	public boolean isOrderIdNull() {
		return getOrderIdNull() == 2;
	}
	public boolean isCreationDateNull() {
		return creationDate == null;
	}
	public void setCreationDateNull() {
		this.creationDate = null;
	}
	private int getSupplierIdNull() {
		return supplierIdNull;
	}
	public void setSupplierIdNull() {
		this.supplierIdNull = 2;
	}
	public boolean isSupplierIdNull() {
		return getSupplierIdNull() == 2;
	}
	private int getCustomerIdNull() {
		return customerIdNull;
	}
	public void setCustomerIdNull() {
		this.customerIdNull = 2;
	}
	public boolean isCustomerIdNull() {
		return getCustomerIdNull() == 2;
	}
	
	public void loadResult(ResultSet rs) throws SQLException {
		
		setOrderId(rs.getInt("ORDER_ID"));
		setCreationDate(rs.getDate("CREATION_DATE"));
		setCustomerId(rs.getInt("CUSTOMER_ID"));
		setSupplierId(rs.getInt("SUPPLIER_ID"));
		
	}
	
	public int insert(Connection connection) throws SQLException {
		
		Integer lastKey = null;		
		final PreparedStatement ps = connection.prepareStatement(INSERT_ALL);
		final Statement stmt = connection.createStatement();
		ResultSet rs = null;
		int p=1;
		
		try
		{
			// SQL: CREATION_DATE (DATE):
			if (isCreationDateNull())
			{
				ps.setNull(p, java.sql.Types.DATE);
			}
			else
			{
				ps.setDate(p, new Date(getCreationDate().getTime()));
			}
			p++;
			// SQL: SUPPLIER_ID (INT):
			if (isCustomerIdNull())
			{
				ps.setNull(p, java.sql.Types.NUMERIC);
			}
			else
			{
				ps.setInt(p, getCustomerId());
			}
			p++;
			// SQL: CUSTOMER_ID (INT):
			if (isSupplierIdNull())
			{
				ps.setNull(p, java.sql.Types.NUMERIC);
			}
			else
			{
				ps.setInt(p, getSupplierId());
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
			ps.close();
			stmt.close();
		}
		return lastKey;
	}
	
	public static DDBBProductsOrder read(final Connection connection, int orderId)
			throws SQLException {
		
		final PreparedStatement ps = connection.prepareStatement(SQL_READ);
		ResultSet rs = null;
		int p = 1;
		try {
			ps.setInt(p, orderId);
			rs = ps.executeQuery();
			DDBBProductsOrder ddbbProductsOrder;
			if(rs.next()) {
				ddbbProductsOrder = new DDBBProductsOrder();
				ddbbProductsOrder.loadResult(rs);
			} else {
				ddbbProductsOrder = null;
			}
			return ddbbProductsOrder;
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
			ps.setInt(p++, getOrderId());
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
