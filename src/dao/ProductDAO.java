package dao;

import java.util.List;

import model.Product;

public interface ProductDAO extends Dao {

	Product getProductById(int productId);
	List<Product> getProductsList();
	void insertList(List<Product> productList);

}
