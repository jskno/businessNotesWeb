package service;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Company;
import serviceWS.ServiceWS;
import serviceWS.ServiceWSImpl;
import utils.DBUtil;
import dao.CompanyDAO;
import dao.CompanyDAOImpl;

public class GetCompanyByTaxIDService extends ServiceWSImpl implements ServiceWS{
	
	private Company company;
	private static ObjectMapper mapper = new ObjectMapper();

	@Override
	public void execute(Object o) {	
		
		String taxID = (String) o;
		company = getCompany(taxID);
		this.sendJsonMessage(company);
	}
	
	private void sendJsonMessage(Company company2) {

		try {
			GetCompanyByTaxIDService.mapper.writeValueAsString(company);
		} catch(IOException e) {
			System.err.println(e);
		}
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
