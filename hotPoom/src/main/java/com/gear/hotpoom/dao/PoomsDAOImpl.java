package com.gear.hotpoom.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gear.hotpoom.vo.Poom;

@Repository
public class PoomsDAOImpl implements PoomsDAO{
	@Autowired
	private SqlSession session;
	
	@Override
	public List<Poom> getPoomCardDetail(int no) {
		// TODO Auto-generated method stub
		return session.selectList("pooms.selectBigCardDetail",no);
	}
	
}
