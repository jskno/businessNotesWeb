package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import persistence.DDBBProduct;
import model.ProductVO;

public class ProductDAOImpl extends DAOImpl implements ProductDAO {
	
	public ProductDAOImpl(Connection connection, HttpSession session) {
		super(connection, session);
	}

	public int insert(Object o){
		
		int newProductId; 
		ProductVO product = (ProductVO) o;
		DDBBProduct ddbbProduct = product.getPersistenceObject();
		
		try {
			newProductId = ddbbProduct.insert(connection);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return newProductId;
	}
	
	public Object search(Object o) {
		return null;
	}
	
	public void update(Object o) {
		
	}
	
	public void delete(Object o) {
		
	}

	@Override
	public ProductVO getProductById(int productId) {
		
		String sql = "select * from product where PRODUCT_ID = " + productId;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		ProductVO product = new ProductVO();
		DDBBProduct ddbbProduct = new DDBBProduct();
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			ddbbProduct.loadResult(resultSet);
			product.setFromPersistenceObject(ddbbProduct);
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeStmtAndRs(statement, resultSet);
		}
		return product;
		
	}

	@Override
	public List<ProductVO> getProductsList() {
		
		List<ProductVO> productsList = new ArrayList<ProductVO>();
		
		String sql = "select * from product order by product_code";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		ProductVO product;
		
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				product = getProductFromRs(resultSet);
				productsList.add(product);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeStmtAndRs(statement, resultSet);
		}
		return productsList;
	}

	@Override
	public void insertList(List<ProductVO> productList) {
		
		for(ProductVO eachProduct : productList) {
			insert(eachProduct);
		}
	}
	
	private ProductVO getProductFromRs(ResultSet resultSet) throws SQLException {
		
		ProductVO product;
		DDBBProduct ddbbProduct = new DDBBProduct();
		ddbbProduct.loadResult(resultSet);
		product = new ProductVO(ddbbProduct);
		return product;
	}

}
