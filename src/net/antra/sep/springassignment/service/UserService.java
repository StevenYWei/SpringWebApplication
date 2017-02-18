package net.antra.sep.springassignment.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private HashMap<String, String>  loginInfo;
	
	public UserService() {
		// Initialize the login info data
		loginInfo = new HashMap<String, String>();
		loginInfo.put("a1", "1");
		loginInfo.put("a2", "2");
	}
	
	// validate the user login information
	public boolean validateUser(String userName, String password) {
		if(loginInfo.containsKey(userName)) {
			if(loginInfo.get(userName).equals(password)) {
				return true;
			}
		}
		return false;
	}
}
