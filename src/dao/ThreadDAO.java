package dao;

import java.util.List;

import model.ThreadVO;

public interface ThreadDAO extends DAO {

	List<ThreadVO> getThreadsList();

}
