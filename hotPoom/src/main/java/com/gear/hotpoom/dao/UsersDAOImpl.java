package com.gear.hotpoom.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gear.hotpoom.vo.User;

@Repository
public class UsersDAOImpl implements UsersDAO{ 
	
	// **************************************** 0803 주하 start
	@Autowired
	private SqlSession session;
	
	@Override
	public int selectCheckEmail(String email) {
		// TODO Auto-generated method stub
		return session.selectOne("users.selectCheckEmail",email);
	}
	
	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		return session.insert("users.insert",user);
	}
	
	@Override
	public User getOneUser(int userNo) {
		return session.selectOne("users.selectOne", userNo);
	}
	
	@Override
	public int updateName(User user) {
		// TODO Auto-generated method stub
		return session.update("users.updateName",user);
	}
	
	@Override
	public int updatePhoneNum(User user) {
		// TODO Auto-generated method stub
		return session.update("users.updatePhoneNum",user);
	}
}
