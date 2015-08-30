package service;

import java.sql.SQLException;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import model.ProductVO;

public class AddProductService extends ServiceImpl implements Service {

	@Override
	protected void execute() {

		createProduct();
		request.setAttribute("newAction", "newProduct");
	}
	
	private void createProduct() {

		ProductVO product = new ProductVO();
		ProductDAO productDao = null;
		try {
			productDao = new ProductDAOImpl(getConnection(), getSession());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		product.setProductCode((String) request.getParameter("productCode"));
		product.setProductDescription((String) request.getParameter("productDescription"));
		
		productDao.insert(product);	
	}

}
