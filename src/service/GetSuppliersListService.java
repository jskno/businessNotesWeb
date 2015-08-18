package service;

import java.util.List;

import model.Supplier;
import dao.SupplierDAO;
import dao.SupplierDAOImpl;

public class GetSuppliersListService extends ServiceImpl {

	@Override
	protected void execute() {
		
		getSuppliersList();
		request.setAttribute("url", "suppliersList.jsp?");
	}
	
	private void getSuppliersList() {
		
		try {
			SupplierDAO supplierDao = new SupplierDAOImpl(getConnection(), getSession());
			List<Supplier> suppliersList = supplierDao.getSuppliersList();
			request.setAttribute("suppliersList", suppliersList);
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}

}
