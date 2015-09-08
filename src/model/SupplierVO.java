package model;

import persistence.DDBBCompanyRole;
import persistence.DDBBSupplier;

public class SupplierVO extends CompanyRoleVO {
	
	private Integer deliveryDays;
	
	public SupplierVO() {
	}
	
	public SupplierVO(CompanyVO company, String roleName, String contactName,
				String contactTelephone, Integer deliveryDays) {
		super(company, roleName, contactName, contactTelephone);
		this.deliveryDays = deliveryDays;
	}
	
	public SupplierVO(DDBBCompanyRole ddbbCompanyRole, DDBBSupplier ddbbSupplier) {
		
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
		sb.append("<supplierAdded>1</supplierAdded>");
		sb.append("</supplier>");
		sb.append(super.toJson());
		return sb.toString();
		
	}
	
	

}
