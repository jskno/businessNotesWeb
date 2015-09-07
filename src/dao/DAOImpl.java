package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

public abstract class DAOImpl implements DAO {
	
	protected Connection connection;
	protected HttpSession session;
	
	protected DAOImpl(Connection connection, HttpSession session) {
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
	
	@Override
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
	
	@Override
	public void closeStmt(PreparedStatement ps) {
		
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			
		}
	}
	
	@Override
	public void closeStmtAndRs(Statement stmt, ResultSet rs) {
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
}
