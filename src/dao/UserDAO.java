package dao;

import model.UserVO;


public interface UserDAO extends Dao{

	UserVO getUserById(Integer userId);

}
