package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import persistence.DDBBProductsOrder;

public class ProductsOrderVO {
	
	private Integer orderId;
	private Date creationDate;
	private Supplier supplier;
	private Customer customer;
	private List<OrderItemVO> orderItems;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<OrderItemVO> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItemVO> orderItems) {
		this.orderItems = orderItems;
	}
	
	public DDBBProductsOrder getPersistenceObject() {
		DDBBProductsOrder ddbbProductsOrder = new DDBBProductsOrder();
		if(getOrderId() != null) {
			ddbbProductsOrder.setOrderId(getOrderId());
		} else {
			ddbbProductsOrder.setOrderIdNull();
		}
		if(getCreationDate() != null) {
			ddbbProductsOrder.setCreationDate(new java.sql.Date 
					(getCreationDate().getTime()));
		} else {
			ddbbProductsOrder.setCreationDateNull();
		}
		if(getCustomer() != null) {
			ddbbProductsOrder.setCustomerId(getCustomer().getRoleId());
		} else {
			ddbbProductsOrder.setCustomerIdNull();
		}
		if(getSupplier() != null) {
			ddbbProductsOrder.setSupplierId(getSupplier().getRoleId());
		} else {
			ddbbProductsOrder.setSupplierIdNull();
		}
		return ddbbProductsOrder;
	}
	
	public void setFromPersistenceObject(DDBBProductsOrder ddbbProductsOrder) {
		
		Customer customer = new Customer();
		Supplier supplier = new Supplier();
		List<OrderItemVO> orderItems = new ArrayList<OrderItemVO>();
		
		if(!ddbbProductsOrder.isOrderIdNull()) {
			setOrderId(ddbbProductsOrder.getOrderId());
		} else {
			setOrderId(null);
		}
		if(!ddbbProductsOrder.isCreationDateNull()) {
			setCreationDate(new Date(
					ddbbProductsOrder.getCreationDate().getTime()));
		} else {
			setCreationDate(null);
		}
		if(!ddbbProductsOrder.isCustomerIdNull()) {
			customer.setRoleId(ddbbProductsOrder.getCustomerId());
		}
		setCustomer(customer);
		if(!ddbbProductsOrder.isSupplierIdNull()) {
			supplier.setRoleId(ddbbProductsOrder.getSupplierId());
		}
		setSupplier(supplier);
		
		setOrderItems(orderItems);
	}
	
	

}
