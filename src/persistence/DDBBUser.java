package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DDBBUser {
	
	private int userId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String profile;
	
	private int userIdNull;

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userrId) {
		this.userId = userrId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}

	private int getUserIdNull() {
		return userIdNull;
	}
	public void setUserIdNull() {
		this.userIdNull = 2;
	}
	public boolean isUserIdNull() {
		return getUserIdNull() == 2;
	}
	public boolean isFirstNameNull() {
		return getFirstName() == null;
	}
	public void setFirstNameNull() {
		this.firstName = null;
	}
	public boolean isLastNameNull() {
		return getLastName() == null;
	}
	public void setLastNameNull() {
		this.lastName = null;
	}
	public boolean isUserNameNull() {
		return getUserName() == null;
	}
	public void setUserNameNull() {
		this.userName = null;
	}
	public boolean isPasswordNull() {
		return getPassword() == null;
	}
	public void setPasswordNull() {
		this.password = null;
	}
	public boolean isProfileNull() {
		return getProfile() == null;
	}
	public void setProfileNull() {
		this.profile = null;
	}
		
	public void loadResult(ResultSet rs) throws SQLException {
		
		setUserId(rs.getInt("USER_ID"));
		if(rs.wasNull()) {
			setUserIdNull();
		}
		setFirstName(rs.getString("FIRST_NAME"));
		setLastName(rs.getString("LAST_NAME"));
		setUserName(rs.getString("USERNAME"));
		setPassword(rs.getString("PASSWORD"));
		setProfile(rs.getString("PROFILE"));
	}

}
