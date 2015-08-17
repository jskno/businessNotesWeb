package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.w3c.dom.Document;

public abstract class ServiceImpl implements Service{
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
		}
	}
	private Connection connection;
	private HttpSession session;
	private Document document;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	private Result result;
	private String profileId; // Perfil de conexi�n a la BBDD

	
	/**
	 * En este m�todo se crea un objeto Session y un objeto Connection y se llama
	 * al otro m�todo execute donde se realiza todo el proceso.
	 *
	 * @param     Request - XML de entrada
	 * @return    Result - XML de salida
	 * @exception BusinessRuleException - Violaci�n de una regla de negocio
	 * @exception SQLException - Error en la base de datos
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) //throws BusinessRuleException,SQLException 
	{
		//Pool pool = null;
		request = request;
		response = response;
		connection = null;
		session = request.getSession();

		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			result = service(request);
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
	}
	
	/**
	 * M�todo donde se deber� implementar toda la l�gica del servicio
	 *
	 */
	protected abstract void execute(); // throws BusinessRuleException, SQLException
	
	
	/** Metodo que contine la estructura basica del servicio.<br>
	 <b>NOTA: Si este m�todo es utilizado en la clase Hija no se llamar� a los m�todos getDomainData, validateData, execute, validateResult y getReturnData.</b> */
	protected Result service(HttpServletRequest request) //throws BusinessRuleException 
	{
		
		getDomainData(request);
		validateData();
		execute();
		validateResult();
		result = getReturnData();
	
		return result;
	}
	
	protected void validateData() {
	}
	
	protected void validateResult() {
	}
	
	protected void getDomainData(HttpServletRequest request) {
	}
	
	protected Result getReturnData() {
		return result;
	}
	
	protected HttpSession getSession() {
		if(null == session) {
			session = request.getSession();
		}
		return session;
	}
	
	
	
	/////// COPIADO DEL DAO IMPLEMENTATION ///////////////////
	/////// UTILIDADES DE BBDD ///////////////////////////////
	
	public Connection getConnection() throws SQLException {
		if(null == connection) {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/businessnotesapp",
					"jskno","1510pkpk");
		}
		return connection;
	}
	protected void closeConnection(Connection connection) {
		if(connection == null) {
			return;
		}
		try {
			connection.rollback();
		} catch (SQLException ex) {
			System.err.println("No se ha podido realizar rollback");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
