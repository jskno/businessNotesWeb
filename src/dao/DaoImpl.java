package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoImpl implements Dao {
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
		}
	}
	
	protected Connection getConnection() throws SQLException {
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
