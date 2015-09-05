package service;

import model.ProductVO;
import dao.ProductDAO;
import dao.ProductDAOImpl;

public class AddProductService extends ServiceImpl implements Service {

	@Override
	protected void execute() {

		createProduct();
		request.setAttribute("newAction", "newProduct");
	}
	
	private void createProduct() {

		ProductVO product = new ProductVO();
		ProductDAO productDao = null;
		productDao = new ProductDAOImpl(getConnection(), getSession());
		product.setProductCode((String) request.getParameter("productCode"));
		product.setProductDescription((String) request.getParameter("productDescription"));
		
		productDao.insert(product);	
	}

}
