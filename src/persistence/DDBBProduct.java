package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DDBBProduct {
	
	private static final String INSERT_ALL = "insert into product (PRODUCT_CODE, " +
		"PRODUCT_DESCRIPTION, STOCK) values (?,?,?)";
	private static final String LAST_ID = "SELECT LAST_INSERT_ID()";
	private static final String SQL_READ="SELECT * FROM product WHERE PRODUCT_ID=?";
	private static final String SQL_DELETE="DELETE FROM product WHERE PRODUCT_ID=?";
	
	private int productId;
	private String productCode;
	private String productDescription;
	private int stock;
	
	private int productIdNull;
	private int stockNull;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getProductIdNull() {
		return productIdNull;
	}
	public void setProductIdNull() {
		this.productIdNull = 2;
	}
	public boolean isProductIdNull() {
		return getProductIdNull() == 2;
	}
	public boolean isProductCodeNull() {
		return getProductCode() == null;
	}
	public void setProductCodeNull() {
		setProductCode(null);
	}
	public boolean isProductDescriptionNull() {
		return getProductDescription() == null;
	}
	public void setProductDescriptionNull() {
		setProductDescription(null);
	}
	private int getStockNull() {
		return stockNull;
	}
	public void setStockNull() {
		this.stockNull = 2;
	}
	public boolean isStockNull() {
		return getStockNull() == 2;
	}
	
	public void loadResult(ResultSet rs) throws SQLException {
		
		setProductId(rs.getInt("PRODUCT_ID"));
		if(rs.wasNull()) {
			setProductIdNull();
		}
		setProductCode(rs.getString("PRODUCT_CODE"));
		if(rs.wasNull()) {
			setProductCodeNull();
		}
		setProductDescription(rs.getString("PRODUCT_DESCRIPTION"));
		if(rs.wasNull()) {
			setProductDescriptionNull();
		}
		
	}
	
	public int insert(Connection connection) throws SQLException {
		
		int lastKey;		
		final PreparedStatement ps = connection.prepareStatement(INSERT_ALL);
		final Statement stmt = connection.createStatement();
		ResultSet rs = null;
		int p=1;
		
		try
		{
			// SQL: PRODUCT_CODE (STRING):
			if (isProductCodeNull())
			{
				ps.setNull(p, java.sql.Types.VARCHAR);
			}
			else
			{
				ps.setString(p, getProductCode());
			}
			p++;
			// SQL: PRODUCT_DESCRIPTION (STRING):
			if (isProductDescriptionNull())
			{
				ps.setNull(p, java.sql.Types.VARCHAR);
			}
			else
			{
				ps.setString(p, getProductDescription());
			}
			p++;
			// SQL: STOCK (INT):
			if (isStockNull())
			{
				ps.setNull(p, java.sql.Types.NUMERIC);
			}
			else
			{
				ps.setInt(p, getStock());
			}
			ps.executeUpdate();
			
			rs = stmt.executeQuery(LAST_ID);
			lastKey = rs.getInt(0);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ps.close();
			rs.close();
			stmt.close();
		}
			
		return lastKey;
	}
	
	public static DDBBProduct read(final Connection connection, int productId)
			throws SQLException {
		
		final PreparedStatement ps = connection.prepareStatement(SQL_READ);
		ResultSet rs = null;
		int p = 1;
		try {
			ps.setInt(p, productId);
			rs = ps.executeQuery();
			DDBBProduct ddbbProduct;
			if(rs.next()) {
				ddbbProduct = new DDBBProduct();
				ddbbProduct.loadResult(rs);
			} else {
				ddbbProduct = null;
			}
			return ddbbProduct;
		} finally {
			if(rs != null) {
				rs.close();
			}
			ps.close();
		}
	}
	
	public boolean delete(final Connection connection)
			throws java.sql.SQLException {
		
		PreparedStatement ps=connection.prepareStatement(SQL_DELETE);
		int p=1;
		try	{
			ps.setInt(p++, getProductId());
			//ps.setLong(p++, this.myOptimistLock);
					
			if (ps.executeUpdate() <= 0) {
				throw new SQLException();
			}
		} finally {
			ps.close();
		}
		return true;
	}
	
}
