package service;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.CompanyVO;
import utils.DBUtil;
import utils.oldCode.serviceWS.ServiceWS;
import utils.oldCode.serviceWS.ServiceWSImpl;
import dao.CompanyDAO;
import dao.CompanyDAOImpl;

public class GetCompanyByTaxIDService extends ServiceWSImpl implements ServiceWS{
	
	private CompanyVO company;
	private static ObjectMapper mapper = new ObjectMapper();

	@Override
	public void execute(Object o) {	
		
		String taxID = (String) o;
		company = getCompany(taxID);
		this.sendJsonMessage(company);
	}
	
	private void sendJsonMessage(CompanyVO company2) {

		try {
			GetCompanyByTaxIDService.mapper.writeValueAsString(company);
		} catch(IOException e) {
			System.err.println(e);
		}
	}

	private CompanyVO getCompany(String taxID) {
		
		CompanyVO company = null;
		try {
			CompanyDAO companyDao = new CompanyDAOImpl(DBUtil.getConnection(), null);
			company = companyDao.getCompanyByTaxID(taxID);
		} catch (Exception e) {
			System.out.println(e);
		}
		return company;
	}

}
