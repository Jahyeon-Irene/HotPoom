package com.gear.hotpoom.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookingsDAOImpl implements BookingsDAO{
	@Autowired
	private SqlSession session;
	
	
}
