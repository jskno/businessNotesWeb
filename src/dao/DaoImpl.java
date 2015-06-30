package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoImpl implements Dao {
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
		}
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/businessnotesapp",
				"jskno","1510pkpk");
	}
	protected void closeConnection(Connection connection) {
		if(connection == null) {
			return;
		}
		try {
			connection.close();
		} catch (SQLException ex) {
		}
	}
	
	@Override
	public void closeTripleConnection(Connection conn, PreparedStatement stmt,
			ResultSet rs) {
		if(conn == null) {
			return;
		}
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			
		}
	}
	
	@Override
	public void closeTwoConnection(Connection connection, PreparedStatement ps) {
		if(connection == null) {
			return;
		}
		try {
			if (ps != null) {
				ps.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			
		}
		
	}
	
	public void insert(Object o){
	}
	
	public Object search(Object o) {
		return null;
	}
	
	public void update(Object o) {
	}
	
	public void delete(Object o) {
	}
	

}
