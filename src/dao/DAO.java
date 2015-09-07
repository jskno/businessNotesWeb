package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public interface DAO {
	
	int insert(Object o);
	Object search(Object o);
	void update(Object o);
	void delete(Object o);
	
	void closeStmt(PreparedStatement ps);
	void closeStmtAndRs(Statement stmt, ResultSet rs);
	void closeStmtAndRs(PreparedStatement stmt, ResultSet rs);
}
