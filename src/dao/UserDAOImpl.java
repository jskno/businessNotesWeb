package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import model.UserVO;
import persistence.DDBBUser;

public class UserDAOImpl extends DAOImpl implements UserDAO {

	public UserDAOImpl(Connection connection, HttpSession session) {
		super(connection, session);
	}

	@Override
	public int insert(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object search(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserVO getUserById(Integer userId) {
		String sql = "select * from user where USER_ID = " + userId;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		UserVO user = null;
		DDBBUser ddbbUser = new DDBBUser();
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				user = new UserVO();
				ddbbUser.loadResult(resultSet);
				user.setFromPersistenceObject(ddbbUser);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeStmtAndRs(statement, resultSet);
		}
		return user;
	}
	
	@Override
	public UserVO getUserByUsernameId(String username) {
		String sql = "select * from user where USERNAME LIKE '" + username + "'";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		UserVO user = null;
		DDBBUser ddbbUser = new DDBBUser();
		try {
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			if(resultSet.next()) {
				ddbbUser.loadResult(resultSet);
				user = new UserVO();
				user.setFromPersistenceObject(ddbbUser);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeStmtAndRs(statement, resultSet);
		}
		return user;
	}

}
