package service;

import model.CompanyVO;
import dao.CompanyDAO;
import dao.CompanyDAOImpl;

public class AddCompanyService extends ServiceImpl implements Service {

	@Override
	protected void execute() {

		createCompany();
		request.setAttribute("nextStep", "newCompany");
	}
	
	private void createCompany() {
		
		CompanyVO company = new CompanyVO();
		CompanyDAO companyDao;
		companyDao = new CompanyDAOImpl(getConnection(), getSession());
		company.setTaxID((String) request.getParameter("taxID"));
		company.setCompanyName((String) request.getParameter("companyName"));
		company.setCompanyTelephone((String) request.getParameter("companyTelephone"));
		company.setCompanyEmail((String) request.getParameter("companyEmail"));
		
		companyDao.insert(company);
			
	}

}
