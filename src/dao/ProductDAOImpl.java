package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Product;

public class ProductDAOImpl extends DaoImpl implements ProductDAO {
	
	public void insert(Object o){
		
	}
	
	public Object search(Object o) {
		return null;
	}
	
	public void update(Object o) {
		
	}
	
	public void delete(Object o) {
		
	}

	@Override
	public Product getProductById(int productId, Connection connection) {
		
		String sql = "select * from product where id = " + productId;
		Product product = new Product();
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				product.setId(resultSet.getInt("id"));
				product.setProductCode(resultSet.getString("product_code"));
				product.setProductDescription(resultSet.getString("product_description"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} //finally {
		//	closeConnection(connection);
		//}
		return product;
		// see when to close connections.
	}

}
