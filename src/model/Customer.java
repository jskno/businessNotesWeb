package model;

import persistence.DDBBCustomer;

public class Customer extends CompanyRole {
	
	private Integer creditRating;
	private Double customerDiscount;
	
	public Customer() {
	}
	
	public Customer(Integer creditRating, Double customerDiscount) {
		
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
	
	

}
