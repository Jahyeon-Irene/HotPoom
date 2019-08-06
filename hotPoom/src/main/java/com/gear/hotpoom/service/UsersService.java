package com.gear.hotpoom.service;

import java.util.Collection;
import java.util.Map;

import com.gear.hotpoom.vo.User;

public interface UsersService {

	// ****************************************** 0803 주하 start
	public boolean checkEmail(String email);

	public int sign(User user);

	public Map<String,Object> getAccountDetail(int userNo);

	public int modifyName(User user);

	public int modifyPhoneNum(User user);;
}
