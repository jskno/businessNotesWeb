package dao;

import java.util.Map;

import model.MenuVO;

public interface MenuDAO extends DAO{

	Map<Integer, MenuVO> getMenu();

}
