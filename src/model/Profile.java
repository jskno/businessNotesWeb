package model;

public enum Profile {
	
	MANAGER ("Manager"),
	SALES_TEAM ("Sales Team");
	
	private final String desc;
	
	Profile(String desc) {
		this.desc = desc;
	}

	public String desc() {
		return this.desc;
	}
	
	public static Profile getProfile(String profileName) {
		Profile profile = null;
		for(Profile eachProfile : Profile.values()) {
			if(eachProfile.desc().equals(profileName)) {
				profile = eachProfile;
				break;
			}
		}
		return profile;
	}
	
	

}
