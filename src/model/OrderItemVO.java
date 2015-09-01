package model;

import persistence.DDBBOrderItem;

public class OrderItemVO {
	
	private Integer orderItemId;
	private Integer orderId;
	private ProductVO product;
	private Integer quantity;
	
	public Integer getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public ProductVO getProduct() {
		return product;
	}
	public void setProduct(ProductVO product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public DDBBOrderItem getPersistenceObject() {
		
		DDBBOrderItem ddbbOrderItem = new DDBBOrderItem();
		if(getOrderItemId() != null) {
			ddbbOrderItem.setOrderId(getOrderId());
		} else {
			ddbbOrderItem.setOrderIdNull();
		}
		if(getOrderId() != null) {
			ddbbOrderItem.setOrderId(getOrderId());
		} else {
			ddbbOrderItem.setOrderIdNull();
		}
		if(getProduct() != null) {
			ddbbOrderItem.setProductId(getProduct().getProductId());
		} else {
			ddbbOrderItem.setProductIdNull();
		}
		if(getQuantity() != null) {
			ddbbOrderItem.setQuantity(getQuantity());
		} else {
			ddbbOrderItem.setQuantityNull();
		}
		
		return ddbbOrderItem;
	}
	
	public void setFromPersistenceObject(DDBBOrderItem ddbbOrderItem) {
		
		ProductVO product = new ProductVO();
		if(!ddbbOrderItem.isOrderItemIdNull()) {
			setOrderItemId(ddbbOrderItem.getOrderItemId());
		} else {
			setOrderItemId(null);
		}
		if(!ddbbOrderItem.isOrderIdNull()) {
			setOrderId(ddbbOrderItem.getOrderId());
		} else {
			setOrderId(null);
		}
		if(!ddbbOrderItem.isProductIdNull()) {
			product.setProductId(ddbbOrderItem.getProductId());
		}
		setProduct(product);
		
		if(!ddbbOrderItem.isQuantityNull()) {
			setQuantity(ddbbOrderItem.getQuantity());
		} else {
			setQuantity(null);
		}
	}
		
}
