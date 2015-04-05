package dao;

import java.sql.Connection;
import java.util.List;

import model.Company;

public interface CompanyDAO extends Dao {
	
	public List<Company> findAllCompanies();
	public List<Company> searchCompaniesByName(String name);
	public Company getCompanyById(int companyId, Connection connection);
	
}
