package model;

import persistence.DDBBProduct;

public class ProductVO {
	
	private Integer productId;
	private String productCode;
	private String productDescription;
	private Integer stock;
	
	public ProductVO() {
		
	}
	
	public ProductVO(String productCode, String productDescription, Integer stock) {
		
		this.productCode = productCode;
		this.productDescription = productDescription;
		this.stock = stock;
	}
	
	public ProductVO(DDBBProduct ddbbProduct) {
		this.setFromPersistenceObject(ddbbProduct);
	}

	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
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
	
	
	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public DDBBProduct getPersistenceObject() {
		DDBBProduct ddbbProduct = new DDBBProduct();
		if(getProductId() != null) {
			ddbbProduct.setProductId(getProductId());
		} else {
			ddbbProduct.setProductIdNull();
		}
		if(getProductCode() != null) {
			ddbbProduct.setProductCode(getProductCode());
		} else {
			ddbbProduct.setProductCodeNull();
		}
		if(getProductDescription() != null) {
			ddbbProduct.setProductDescription(getProductDescription());
		} else {
			ddbbProduct.setProductDescriptionNull();
		}
		if(getStock() != null) {
			ddbbProduct.setStock(getStock());
		} else {
			ddbbProduct.setStockNull();
		}
		return ddbbProduct;
	}
	
	public void setFromPersistenceObject(DDBBProduct ddbbProduct) {
		
		if(!ddbbProduct.isProductIdNull()) {
			setProductId(ddbbProduct.getProductId());
		} else {
			setProductId(null);
		}
		if(!ddbbProduct.isProductCodeNull()) {
			setProductCode(ddbbProduct.getProductCode());
		} else {
			setProductCode(null);
		}
		if(!ddbbProduct.isProductDescriptionNull()) {
			setProductDescription(ddbbProduct.getProductDescription());
		} else {
			setProductDescription(null);
		}
		if(ddbbProduct.isStockNull()) {
			setStock(ddbbProduct.getStock());
		} else {
			setStock(null);
		}
	}
	
	
	@Override
	public String toString() {
		return "ProductVO [productId=" + productId + ", productCode="
				+ productCode + ", productDescription=" + productDescription
				+ ", stock=" + stock + "]";
	}

}
