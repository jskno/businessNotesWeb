package persistence;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DDBBProductsOrder {
	
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
	
	

}
