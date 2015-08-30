package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DDBBBusinessNote {
	
	private int noteId;
	private int customerId;
	private int supplierId;
	private int productId;
	
	private int noteIdNull;
	private int customerIdNull;
	private int supplierIdNull;
	private int productIdNull;
	
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	private int getNoteIdNull() {
		return noteIdNull;
	}
	public void setNoteIdNull() {
		this.noteIdNull = 2;
	}
	public boolean isNoteIdNull() {
		return getNoteIdNull() == 2;
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
	private int getSupplierIdNull() {
		return supplierIdNull;
	}
	public void setSupplierIdNull() {
		this.supplierIdNull = 2;
	}
	public boolean isSupplierIdNull() {
		return getSupplierIdNull() == 2;
	}
	private int getProductIdNull() {
		return productIdNull;
	}
	public void setProductIdNull() {
		this.productIdNull = 2;
	}
	public boolean isProductIdNull() {
		return getProductIdNull() == 2;
	}
	
	public void loadResult(ResultSet rs) throws SQLException {
		
		setNoteId(rs.getInt("NOTE_ID"));
		if(rs.wasNull()) {
			setNoteIdNull();
		}
		setCustomerId(rs.getInt("CUSTOMER_ID"));
		if(rs.wasNull()) {
			setCustomerIdNull();
		}
		setSupplierId(rs.getInt("SUPPLIER_ID"));
		if(rs.wasNull()) {
			setSupplierIdNull();
		}
		setProductId(rs.getInt("PRODUCT_ID"));
		if(rs.wasNull()) {
			setProductIdNull();
		}
	}

	
}
