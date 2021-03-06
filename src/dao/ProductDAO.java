package dao;

import java.util.List;

import model.ProductVO;

public interface ProductDAO extends DAO {

	ProductVO getProductById(int productId);
	List<ProductVO> getProductsList();
	void insertList(List<ProductVO> productList);

}
