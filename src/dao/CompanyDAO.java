package dao;

import java.util.List;

import model.CompanyVO;

public interface CompanyDAO extends DAO {
	
	public List<CompanyVO> getCompaniesList();
	public List<CompanyVO> searchCompaniesByName(String name);
	public CompanyVO getCompanyById(int companyId);
	public List<CompanyVO> getNoCustomerCompanies();
	public List<CompanyVO> getNoSupplierCompanies();
	public void insertList(List<CompanyVO> companiesList);
	public CompanyVO getCompanyByTaxID(String taxID);
	
}
