package service;

import java.util.List;

import model.Customer;
import model.ProductVO;
import model.Supplier;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import dao.ProductDAO;
import dao.ProductDAOImpl;
import dao.SupplierDAO;
import dao.SupplierDAOImpl;

public class NewNoteFormService extends ServiceImpl {

	@Override
	protected void execute() {
		getCustomersList();
		getSuppliersList();
		getProductsList();
		request.setAttribute("url", "newNoteForm.jsp?");
		
	}
	
	private void getCustomersList() {
		
		try {
			CustomerDAO customerDao = new CustomerDAOImpl(getConnection(), getSession());
			List<Customer> customersList = customerDao.getCustomersList();
			request.setAttribute("customersList", customersList);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	private void getProductsList() {

		try {
			ProductDAO productDao = new ProductDAOImpl(getConnection(), getSession());
			List<ProductVO> productsList = productDao.getProductsList();
			request.setAttribute("productsList", productsList);
		} catch (Exception e) {
			System.out.println(e);
		}
		
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
