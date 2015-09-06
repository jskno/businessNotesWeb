package model;

import persistence.DDBBCompanyRole;
import persistence.DDBBCustomer;

public class CustomerVO extends CompanyRoleVO {
	
	private Integer creditRating;
	private Double customerDiscount;
	
	public CustomerVO() {
		super();
	}
	
	public CustomerVO(DDBBCompanyRole ddbbCompanyRole, DDBBCustomer ddbbCustomer) {
		this.setFromPersistenceObject(ddbbCompanyRole);
		this.setFromPersistenceObject(ddbbCustomer);
	}
	
	public CustomerVO(CompanyVO company, String roleName, String contactName, 
			String contactTelephone, Integer creditRating, Double customerDiscount) {
		super(company, roleName, contactName, contactTelephone);
		this.creditRating = creditRating;
		this.customerDiscount = customerDiscount;
	}

	public Integer getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(Integer creditRating) {
		this.creditRating = creditRating;
	}

	public Double getCustomerDiscount() {
		return customerDiscount;
	}

	public void setCustomerDiscount(Double customerDiscount) {
		this.customerDiscount = customerDiscount;
	}
	
	public DDBBCustomer getPersistenceCustomer() {

		DDBBCustomer ddbbCustomer = new DDBBCustomer();
		if(getRoleId() != null) {
			ddbbCustomer.setRoleId(getRoleId());
		} else {
			ddbbCustomer.setRoleIdNull();
		}
		if(getCreditRating() != null) {
			ddbbCustomer.setCreditRating(getCreditRating());
		} else {
			ddbbCustomer.setCreditRatingNull();
		}
		if(getCustomerDiscount() != null) {
			ddbbCustomer.setCustomerDiscount(getCustomerDiscount());
		} else {
			ddbbCustomer.setCustomerDiscountNull();
		}
		return ddbbCustomer;
	}
	
	public void setFromPersistenceObject(final DDBBCustomer ddbbCustomer) {
		
		if(!ddbbCustomer.isCreditRatingNull()) {
			setCreditRating(ddbbCustomer.getCreditRating());
		} else {
			setCreditRating(null);
		}
		if(!ddbbCustomer.isCustomerDiscountNull()) {
			setCustomerDiscount(ddbbCustomer.getCustomerDiscount());
		} else {
			setCustomerDiscount(null);
		}
	}

	@Override
	public String toString() {
		return "Customer [creditRating=" + creditRating + ", customerDiscount="
				+ customerDiscount + ", toString()=" + super.toString() + "]";
	}
	
	@Override
	public String toJson() {
		StringBuffer sb = new StringBuffer();
		sb.append("<customer>");
		sb.append("<creditRating>" + getCreditRating() + "</creditRating>");
		sb.append("<customerDiscount>" + getCustomerDiscount() + "</customerDiscount>");
		sb.append("</customer>");
		sb.append("<customerAdded>1</customerAdded>");
		sb.append(super.toJson());
		return sb.toString();
		
	}
	
	

}
