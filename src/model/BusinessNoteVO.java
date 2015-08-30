package model;

import persistence.DDBBBusinessNote;

public class BusinessNoteVO extends Note {
	
	private Customer customer;
	private Supplier supplier;
	private ProductVO product;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public ProductVO getProduct() {
		return product;
	}
	public void setProduct(ProductVO product) {
		this.product = product;
	}
	
	public DDBBBusinessNote getPersistenceBusNote() {
		DDBBBusinessNote ddbbBusinessNote = new DDBBBusinessNote();
		if(getCustomer() != null) {
			ddbbBusinessNote.setCustomerId(getCustomer().getRoleId());
		} else {
			ddbbBusinessNote.setCustomerIdNull();
		}
		if(getSupplier() != null) {
			ddbbBusinessNote.setSupplierId(getSupplier().getRoleId());
		} else {
			ddbbBusinessNote.setSupplierIdNull();
		}
		if(getProduct() != null) {
			ddbbBusinessNote.setProductId(getProduct().getProductId());
		} else {
			ddbbBusinessNote.setProductIdNull();
		}
		return ddbbBusinessNote;
	}
	
	public void setFromPersistenceBusNote(DDBBBusinessNote ddbbBusinessNote) {
		Customer customer = null;
		Supplier supplier = null;
		ProductVO product = null;
		
		if(!ddbbBusinessNote.isCustomerIdNull()) {
			customer = new Customer();
			customer.setRoleId(ddbbBusinessNote.getCustomerId());
		}
		setCustomer(customer);
		
		if(!ddbbBusinessNote.isSupplierIdNull()) {
			supplier = new Supplier();
			supplier.setRoleId(ddbbBusinessNote.getSupplierId());
		} 
		setSupplier(supplier);
		
		if(!ddbbBusinessNote.isProductIdNull()) {
			product = new ProductVO();
			product.setProductId(ddbbBusinessNote.getProductId());
		}
		setProduct(product);
		
	}
	

}
