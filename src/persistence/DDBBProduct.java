package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;


public class DDBBProduct {
	
	private int productId;
	private String productCode;
	private String productDescription;
	
	private int productIdNull;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public int getProductIdNull() {
		return productIdNull;
	}
	public void setProductIdNull() {
		this.productIdNull = 2;
	}
	public boolean isProductIdNull() {
		return getProductIdNull() == 2;
	}
	public boolean isProductCodeNull() {
		return getProductCode() == null;
	}
	public void setProductCodeNull() {
		setProductCode(null);
	}
	public boolean isProductDescriptionNull() {
		return getProductDescription() == null;
	}
	public void setProductDescriptionNull() {
		setProductDescription(null);
	}
	
	public void loadResult(ResultSet rs) throws SQLException {
		
		setProductId(rs.getInt("PRODUCT_ID"));
		if(rs.wasNull()) {
			setProductIdNull();
		}
		setProductCode(rs.getString("PRODUCT_CODE"));
		if(rs.wasNull()) {
			setProductCodeNull();
		}
		setProductDescription(rs.getString("PRODUCT_DESCRIPTION"));
		if(rs.wasNull()) {
			setProductDescriptionNull();
		}
		
	}
	
}
