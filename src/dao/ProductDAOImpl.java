package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.Product;

public class ProductDAOImpl extends DaoImpl implements ProductDAO {
	
	private static final String INSERT = "insert into product (product_code, product_description) "
			+ "values (?,?)";
	
	public ProductDAOImpl(Connection connection, HttpSession session) {
		super(connection, session);
	}

	public void insert(Object o){
		Product product = (Product) o;
		String productCode = product.getProductCode();
		String productDescription = product.getProductDescription();
		
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(INSERT);
			ps.setString(1, productCode);
			ps.setString(2, productDescription);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			closeStmt(ps);
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
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		Product product = new Product();
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				product.setId(resultSet.getInt("id"));
				product.setProductCode(resultSet.getString("product_code"));
				product.setProductDescription(resultSet.getString("product_description"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeStmtAndRs(statement, resultSet);
		}
		return product;
		
	}

	@Override
	public List<Product> getProductsList() {
		
		List<Product> result = new ArrayList<Product>();
		
		String sql = "select * from product";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		Product product;
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
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
			closeStmtAndRs(statement, resultSet);
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
