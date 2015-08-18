package service;

import java.util.List;

import model.Product;
import dao.ProductDAO;
import dao.ProductDAOImpl;

public class GetProductsListService extends ServiceImpl implements Service {

	@Override
	protected void execute() {

		getProductsList();
		request.setAttribute("url", "productsList.jsp?");
	}
	
	private void getProductsList() {

		try {
			ProductDAO productDao = new ProductDAOImpl(getConnection(), getSession());
			List<Product> productsList = productDao.getProductsList();
			request.setAttribute("productsList", productsList);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
