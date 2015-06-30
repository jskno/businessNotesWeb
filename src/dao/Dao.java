package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Dao {
	
	public void insert(Object o);
	public Object search(Object o);
	public void update(Object o);
	public void delete(Object o);
	
	public Connection getConnection() throws SQLException;
	public void closeTripleConnection(Connection conn, PreparedStatement stmt,
			ResultSet rs);
	public void closeTwoConnection(Connection connection, PreparedStatement ps);

}
