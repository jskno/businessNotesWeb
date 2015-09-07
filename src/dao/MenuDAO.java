package dao;

import java.util.List;
import java.util.Map;

import model.MenuVO;
import model.SubMenuVO;

public interface MenuDAO extends DAO{

	Map<Integer, MenuVO> getMenu();

}
