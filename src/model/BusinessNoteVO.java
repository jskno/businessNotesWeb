package model;

import persistence.DDBBBusinessNote;

public class BusinessNoteVO extends NoteVO {
	
	private CustomerVO customer;
	private SupplierVO supplier;
	private ProductVO product;
	
	public CustomerVO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerVO customer) {
		this.customer = customer;
	}
	public SupplierVO getSupplier() {
		return supplier;
	}
	public void setSupplier(SupplierVO supplier) {
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
		CustomerVO customer = null;
		SupplierVO supplier = null;
		ProductVO product = null;
		
		if(!ddbbBusinessNote.isCustomerIdNull()) {
			customer = new CustomerVO();
			customer.setRoleId(ddbbBusinessNote.getCustomerId());
		}
		setCustomer(customer);
		
		if(!ddbbBusinessNote.isSupplierIdNull()) {
			supplier = new SupplierVO();
			supplier.setRoleId(ddbbBusinessNote.getSupplierId());
		} 
		setSupplier(supplier);
		
		if(!ddbbBusinessNote.isProductIdNull()) {
			product = new ProductVO();
			product.setProductId(ddbbBusinessNote.getProductId());
		}
		setProduct(product);
		
	}
	
	public void insert() {
		
	}

}
