package model;

import persistence.DDBBUser;

public class UserVO {
	
	private Integer userId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private Profile profile;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(String profileDesc) {
		this.profile = Profile.getProfile(profileDesc);
	}

	public DDBBUser getPersistenceObject() {
		DDBBUser ddbbUser = new DDBBUser();
		if(getUserId() != null) {
			ddbbUser.setUserId(getUserId());
		} else {
			ddbbUser.setUserIdNull();
		}
		if(getFirstName() != null) {
			ddbbUser.setFirstName(getFirstName());
		} else {
			ddbbUser.setFirstName(null);
		}
		if(getLastName() != null) {
			ddbbUser.setLastName(getLastName());
		} else {
			ddbbUser.setLastName(null);
		}
		if(getUserName() != null) {
			ddbbUser.setUserName(getUserName());
		} else {
			ddbbUser.setUserName(null);
		}
		if(getPassword() != null) {
			ddbbUser.setPassword(getPassword());
		} else {
			ddbbUser.setPassword(null);
		}
		if(getProfile() != null) {
			ddbbUser.setProfile(getProfile().desc());
		} else {
			ddbbUser.setProfile(null);
		}
				
		return ddbbUser;
	}
	
	public void setFromPersistance(final DDBBUser ddbbUser) {
		
		if(!ddbbUser.isUserIdNull()) {
			setUserId(ddbbUser.getUserId());
		} else {
			setUserId(null);
		}
		if(!ddbbUser.isFirstNameNull()) {
			setFirstName(ddbbUser.getFirstName());
		} else {
			setFirstName(null);
		}
		if(!ddbbUser.isLastNameNull()) {
			setLastName(ddbbUser.getLastName());
		} else {
			setLastName(null);
		}
		if(!ddbbUser.isUserNameNull()) {
			setUserName(ddbbUser.getUserName());
		} else {
			setUserName(null);
		}
		if(!ddbbUser.isPasswordNull()) {
			setPassword(ddbbUser.getPassword());
		} else {
			setPassword(null);
		}
		if(!ddbbUser.isProfileNull()) {
			setProfile(ddbbUser.getProfile());
		} else {
			setProfile(null);
		}
	}
}
