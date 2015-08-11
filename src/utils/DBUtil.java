package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
		}
	}
	
	private static String USERNAME = "jskno";
	private static String PASSWORD = "1510pkpk";
	private static String CONN_STRING = "jdbc:mysql://localhost:3306/businessnotesapp";
	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.err.println(e);
		}
		
		return conn;
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

}
