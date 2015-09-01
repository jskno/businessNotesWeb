package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DDBBOrderItem {
	
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
}
