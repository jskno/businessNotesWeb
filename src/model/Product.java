package model;

public class Product {
	
	private int id;
	private String productCode;
	private String productDescription;
	
	public Product() {
		
	}
	
	public Product(String productCode, String productDescription) {
		
		this.productCode = productCode;
		this.productDescription = productDescription;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productDescription="
				+ productDescription + "]";
	}

}
