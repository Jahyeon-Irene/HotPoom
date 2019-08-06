package com.gear.hotpoom.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gear.hotpoom.vo.Photo;

@Repository
public class PhotosDAOImpl implements PhotosDAO{
	@Autowired
	private SqlSession session;
	
	@Override
	public List<Photo> getPoomCardPhoto(int poomNo) {
		// TODO Auto-generated method stub
		return session.selectList("photos.selectPoomCardPhotoList",poomNo);
	}
	
	
}
