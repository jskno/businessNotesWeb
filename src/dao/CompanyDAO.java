package dao;

import java.util.List;

import model.CompanyVO;

public interface CompanyDAO extends DAO {
	
	public List<CompanyVO> getCompaniesList();
	public List<CompanyVO> searchCompaniesByName(String name);
	public CompanyVO getCompanyById(int companyId);
	public void insertList(List<CompanyVO> companiesList);
	public CompanyVO getCompanyByTaxID(String taxID);
	List<CompanyVO> getNoRoleCompanies(String origin);
	
}
