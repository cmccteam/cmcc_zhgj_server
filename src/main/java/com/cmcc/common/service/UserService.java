package com.cmcc.common.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	public String getUserId(){
		return "userid001";
	}
	
	public String getUserName(){
		return "username111";
	}
	
	public String getUserName(String userId){
		return "username111";
	}
}
