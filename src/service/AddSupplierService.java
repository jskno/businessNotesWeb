package service;

import model.Company;
import model.RoleName;
import model.Supplier;
import dao.CompanyDAO;
import dao.CompanyDAOImpl;
import dao.SupplierDAO;
import dao.SupplierDAOImpl;

public class AddSupplierService extends ServiceImpl implements Service {
	
	private int companyId;

	@Override
	protected void execute() {
		
		String companyIdFromRq = request.getParameter("companyId");
		if(companyIdFromRq == null || companyIdFromRq.equals("")) {
			createSupplierAndCompany();
		} else {
			companyId = Integer.parseInt(companyIdFromRq);
			createSupplier(companyId);
		}
		request.setAttribute("nextStep", "newSupplier");
	}
	
	private void createSupplierAndCompany() {
		
		Company company = new Company();
		company.setTaxID(request.getParameter("taxID"));
		company.setCompanyName(request.getParameter("companyName"));
		company.setCompanyTelephone(request.getParameter("companyTelephone"));
		company.setCompanyEmail(request.getParameter("companyEmail"));
		CompanyDAO companyDao = new CompanyDAOImpl(getConnection(), getSession());
		companyId = companyDao.insert(company);
		
		createSupplier(companyId);
		
	}

	private void createSupplier(Integer companyId) {
		
		Supplier supplier = new Supplier();
		Company company = new Company();
		company.setCompanyId(companyId);
		supplier.setCompany(company);
		supplier.setRoleName(RoleName.SUPPLIER);
		supplier.setContactName((String) request.getParameter("contactName"));
		supplier.setContactTelephone((String) request.getParameter("contactTelephone"));
		supplier.setDeliveryDays(Integer.parseInt(request.getParameter("deliveryDays")));
		SupplierDAO supplierDao = new SupplierDAOImpl(getConnection(), getSession());
		
		supplierDao.insert(supplier);
		
	}

}
