package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

public abstract class DaoImpl implements Dao {
	
	protected Connection connection;
	protected HttpSession session;
	
	protected DaoImpl(Connection connection, HttpSession session) {
		this.connection = connection;
		this.session = session;
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
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
	
	public void closeStmtAndRs(PreparedStatement stmt,
			ResultSet rs) {
		
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			
		}
	}
	
	public void closeStmt(PreparedStatement ps) {
		
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			
		}
	}
}
