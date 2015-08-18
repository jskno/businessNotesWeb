package service;

import java.util.List;

import model.Company;
import dao.CompanyDAO;
import dao.CompanyDAOImpl;

public class GetCompaniesListService extends ServiceImpl implements Service {

	@Override
	protected void execute() {
		
		getCompaniesList();
		request.setAttribute("url", "companiesList.jsp?");
	}
	
	private void getCompaniesList() {
		
		try {
			CompanyDAO companyDao = new CompanyDAOImpl(null, null);
			List<Company> companiesList = companyDao.getCompaniesList();
			request.setAttribute("companiesList", companiesList);
		} catch (Exception e) {
			System.out.println(e);
		}
			
	}

}
