package service;

import model.Company;
import serviceWS.ServiceWS;
import serviceWS.ServiceWSImpl;
import utils.DBUtil;
import dao.CompanyDAO;
import dao.CompanyDAOImpl;

public class GetCompanyByTaxIDService extends ServiceWSImpl implements ServiceWS{

	@Override
	public void execute(Object o) {	
		
		String taxID = (String) o;
		getCompany(taxID);
	}
	
	private Company getCompany(String taxID) {
		
		Company company = null;
		try {
			CompanyDAO companyDao = new CompanyDAOImpl(DBUtil.getConnection(), null);
			company = companyDao.getCompanyByTaxID(taxID);
		} catch (Exception e) {
			System.out.println(e);
		}
		return company;
	}

}
