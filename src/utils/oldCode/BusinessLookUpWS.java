package utils.oldCode;

import service.GetCompanyByTaxIDService;
import utils.oldCode.serviceWS.ServiceWS;

public class BusinessLookUpWS {
	
	private final String HOME_PAGE = "homePage";
	private final String CHECK_TAX_ID = "checkTaxID";
	
	
	private ServiceWS serviceClass;
	
	
	public ServiceWS getBusinessService(String serviceType) {
		
		switch (serviceType) {
		case HOME_PAGE:
		case CHECK_TAX_ID:
			serviceClass = new GetCompanyByTaxIDService();
			break;
		default:
			break;
		}
		
		return serviceClass;
		
	}

}
