package dao;

import java.util.List;
import java.util.Map;

public interface SubMenuDAO extends Dao{

	Map<String, List<String>> getSubMenus();

}
