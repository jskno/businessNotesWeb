package dao;

import java.util.List;

import model.Company;

public interface CompanyDAO extends Dao {
	
	public List<Company> getCompaniesList();
	public List<Company> searchCompaniesByName(String name);
	public Company getCompanyById(int companyId);
	
}
