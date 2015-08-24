package dao;

import java.util.List;
import java.util.Map;

import model.Menu;
import model.SubMenu;

public interface MenuDAO extends Dao{

	Map<Integer, Menu> getMenu();

}
