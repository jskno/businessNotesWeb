package model;

import persistence.DDBBSupplier;

public class Supplier extends CompanyRole {
	
	private Integer deliveryDays;
	
	public Supplier() {
	}
	
	public Supplier(Integer deliveryDays) {
		this.deliveryDays = deliveryDays;
	}
	
	public Integer getDeliveryDays() {
		return deliveryDays;
	}
	public void setDeliveryDays(Integer deliveryDays) {
		this.deliveryDays = deliveryDays;
	}

	public DDBBSupplier getPersistenceSupplier() {
		
		DDBBSupplier ddbbSupplier = new DDBBSupplier();
		if(getRoleId() != null) {
			ddbbSupplier.setRoleId(getRoleId());
		} else {
			ddbbSupplier.setRoleIdNull();
		}
		if(getDeliveryDays() != null) {
			ddbbSupplier.setDeliveryDays(getDeliveryDays());
		} else {
			ddbbSupplier.setDeliveryDaysNull();
		}
		
		return ddbbSupplier;
	}
	
	public void setFromPersistenceObject(DDBBSupplier ddbbSupplier) {
		
		if(!ddbbSupplier.isDeliveryDaysNull()) {
			setDeliveryDays(ddbbSupplier.getDeliveryDays());
		} else {
			setDeliveryDays(null);
		}
		
	}
	
	

}
