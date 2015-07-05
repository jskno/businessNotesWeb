package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductDAOImpl extends DaoImpl implements ProductDAO {
	
	private static final String INSERT = "insert into product (product_code, product_description) "
			+ "values (?,?)";
	
	public void insert(Object o){
		Product product = (Product) o;
		String productCode = product.getProductCode();
		String productDescription = product.getProductDescription();
		
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = getConnection();
			ps = connection.prepareStatement(INSERT);
			ps.setString(1, productCode);
			ps.setString(2, productDescription);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			closeTwoConnection(connection, ps);
		}
	}
	
	public Object search(Object o) {
		return null;
	}
	
	public void update(Object o) {
		
	}
	
	public void delete(Object o) {
		
	}

	@Override
	public Product getProductById(int productId) {
		
		String sql = "select * from product where id = " + productId;
		Product product = new Product();
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				product.setId(resultSet.getInt("id"));
				product.setProductCode(resultSet.getString("product_code"));
				product.setProductDescription(resultSet.getString("product_description"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return product;
		
	}

	@Override
	public List<Product> getProductsList() {
		
		List<Product> result = new ArrayList<Product>();
		
		String sql = "select * from product";
		
		Connection connection = null;
		Product product;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				product = new Product();
				product.setId(resultSet.getInt("id"));
				product.setProductCode(resultSet.getString("product_code"));
				product.setProductDescription(resultSet.getString("product_description"));
				result.add(product);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;
	}

	@Override
	public void insertList(List<Product> productList) {
		
		for(Product eachProduct : productList) {
			insert(eachProduct);
		}
	}

}
