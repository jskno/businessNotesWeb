package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DDBBOrderItem {
	
	private static final String INSERT_ALL = "insert into order_item (ORDER_ID, " + 
		"PRODUCT_ID, QUANTITY) values (?,?,?)";
	private static final String LAST_ID = "SELECT LAST_INSERT_ID()";
	private static final String SQL_READ="SELECT * FROM order_item WHERE ORDER_ITEM_ID=?";
	private static final String SQL_DELETE="DELETE FROM order_item WHERE ORDER_ITEM_ID=?";
	
	private int orderItemId;
	private int orderId;
	private int productId;
	private int quantity;
	
	private int orderItemIdNull;
	private int orderIdNull;
	private int productIdNull;
	private int quantityNull;
	
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	private int getOrderItemIdNull() {
		return orderItemIdNull;
	}
	public void setOrderItemIdNull() {
		this.orderItemIdNull = 2;
	}
	public boolean isOrderItemIdNull() {
		return getOrderItemIdNull() == 2;
	}
	private int getOrderIdNull() {
		return orderIdNull;
	}
	public void setOrderIdNull( ) {
		this.orderIdNull = 2;
	}
	public boolean isOrderIdNull() {
		return getOrderIdNull() == 2;
	}
	public int getProductIdNull() {
		return productIdNull;
	}
	public void setProductIdNull( ) {
		this.productIdNull = 2;
	}
	public boolean isProductIdNull() {
		return getProductIdNull() == 2;
	}
	public int getQuantityNull() {
		return quantityNull;
	}
	public void setQuantityNull( ) {
		this.quantityNull = 2;
	}
	public boolean isQuantityNull() {
		return getQuantityNull() == 2;
	}
	
	public void loadResult(ResultSet rs) throws SQLException {
		
		setOrderItemId(orderItemId);
		if(rs.wasNull()) {
			setOrderItemIdNull();
		}
		setOrderId(orderId);
		if(rs.wasNull()) {
			setOrderIdNull();
		}
		setProductId(productId);
		if(rs.wasNull()) {
			setProductIdNull();
		}
		setQuantity(quantity);
		if(rs.wasNull()) {
			setQuantityNull();
		}
		
	}
	
	public int insert(Connection connection) throws SQLException {
		
		Integer lastKey = null;		
		final PreparedStatement ps = connection.prepareStatement(INSERT_ALL);
		final Statement stmt = connection.createStatement();
		ResultSet rs = null;
		int p=1;
		
		try
		{
			// SQL: ORDER_ID (INT):
			if (isOrderIdNull())
			{
				ps.setNull(p, java.sql.Types.NUMERIC);
			}
			else
			{
				ps.setInt(p, getOrderId());
			}
			p++;
			// SQL: PRODUCT_ID (INT):
			if (isProductIdNull())
			{
				ps.setNull(p, java.sql.Types.NUMERIC);
			}
			else
			{
				ps.setInt(p, getProductId());
			}
			p++;
			// SQL: QUANTITY (INT):
			if (isQuantityNull())
			{
				ps.setNull(p, java.sql.Types.NUMERIC);
			}
			else
			{
				ps.setInt(p, getQuantity());
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
	
	public static DDBBOrderItem read(final Connection connection, int orderItemId)
			throws SQLException {
		
		final PreparedStatement ps = connection.prepareStatement(SQL_READ);
		ResultSet rs = null;
		int p = 1;
		try {
			ps.setInt(p, orderItemId);
			rs = ps.executeQuery();
			DDBBOrderItem ddbbOrderItem;
			if(rs.next()) {
				ddbbOrderItem = new DDBBOrderItem();
				ddbbOrderItem.loadResult(rs);
			} else {
				ddbbOrderItem = null;
			}
			return ddbbOrderItem;
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
			ps.setInt(p++, getOrderItemId());
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
