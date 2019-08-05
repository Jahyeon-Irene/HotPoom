package com.gear.hotpoom.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gear.hotpoom.vo.Message;

@Repository
public class MessagesDAOImpl implements MessagesDAO{
	@Autowired
	private SqlSession session;
	
	@Override
	public Message selectTitle(int no) {
		return session.selectOne("messages.selectTitle",no);
	}
}
