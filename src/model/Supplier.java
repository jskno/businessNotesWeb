package model;

import persistence.DDBBCompanyRole;
import persistence.DDBBSupplier;

public class Supplier extends CompanyRole {
	
	private Integer deliveryDays;
	
	public Supplier() {
	}
	
	public Supplier(Integer deliveryDays) {
		this.deliveryDays = deliveryDays;
	}
	
	public Supplier(DDBBCompanyRole ddbbCompanyRole, DDBBSupplier ddbbSupplier) {
		
		this.setFromPersistenceObject(ddbbCompanyRole);
		this.setFromPersistenceObject(ddbbSupplier);
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
	
	@Override
	public String toJson() {
		StringBuffer sb = new StringBuffer();
		sb.append("<supplier>");
		sb.append("<deliveryDays>" + getDeliveryDays() + "</deliveryDays>");
		sb.append("</supplier>");
		sb.append("<supplierAdded>1</supplierAdded>");
		sb.append(super.toJson());
		return sb.toString();
		
	}
	
	

}
