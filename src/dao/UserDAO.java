package dao;

import model.UserVO;


public interface UserDAO extends DAO{

	UserVO getUserById(Integer userId);
	UserVO getUserByUsernameId(String username);

}
