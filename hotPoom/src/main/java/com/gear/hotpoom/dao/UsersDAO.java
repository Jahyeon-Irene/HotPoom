package com.gear.hotpoom.dao;

import com.gear.hotpoom.vo.User;

public interface UsersDAO {

	// **************************************** 0803 주하 start
	
	public int selectCheckEmail(String email);

	public int insert(User user);

	public User getOneUser(int userNo);

	public int updateName(User user);

	public int updatePhoneNum(User user);;
}
