package service;

import java.sql.SQLException;

import dao.CompanyDAO;
import dao.CompanyDAOImpl;
import dao.SupplierDAO;
import dao.SupplierDAOImpl;
import model.Company;
import model.Supplier;

public class AddSupplierService extends ServiceImpl implements Service {

	@Override
	protected void execute() {

		createSupplier();
		request.setAttribute("newAction", "newSupplier");
	}
	
	private void createSupplier() {
		
		Supplier supplier = new Supplier();
		CompanyDAO companyDao = null;
		SupplierDAO supplierDao = null;
		try {
			companyDao = new CompanyDAOImpl(getConnection(), getSession());
			supplierDao = new SupplierDAOImpl(getConnection(), getSession());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Company company = companyDao.getCompanyById(Integer.parseInt(request.getParameter("companyId")));
		supplier.setCompany(company);
		supplier.setContactName((String) request.getParameter("contactName"));
		supplier.setContactTelephone((String) request.getParameter("contactTelephone"));
		
		supplierDao.insert(supplier);
		
	}

}
