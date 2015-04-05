package dao;

import java.sql.Connection;

import model.Product;

public interface ProductDAO extends Dao {

	Product getProductById(int productId, Connection connection);

}
