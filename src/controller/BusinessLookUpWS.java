package controller;

import service.GetCompanyByTaxIDService;
import service.Service;
import serviceWS.ServiceWS;

public class BusinessLookUpWS {
	
	private final String HOME_PAGE = "homePage";
	private final String NEW_CUSTOMER_2 = "newCustomer2";
	
	
	private ServiceWS serviceClass;
	
	
	public ServiceWS getBusinessService(String serviceType) {
		
		switch (serviceType) {
		case HOME_PAGE:
		case NEW_CUSTOMER_2:
			serviceClass = new GetCompanyByTaxIDService();
			break;
		default:
			break;
		}
		
		return serviceClass;
		
	}

}
