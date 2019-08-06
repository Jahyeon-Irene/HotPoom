package com.gear.hotpoom.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gear.hotpoom.dao.BookmarksDAO;
import com.gear.hotpoom.dao.PhotosDAO;
import com.gear.hotpoom.dao.PoomsDAO;
import com.gear.hotpoom.dao.UsersDAO;
import com.gear.hotpoom.vo.Bookmark;
import com.gear.hotpoom.vo.Photo;
import com.gear.hotpoom.vo.Poom;

@Service
public class PoomsServiceImpl implements PoomsService{

	@Autowired
	private PoomsDAO poomsDAO;
	@Autowired
	private BookmarksDAO bookmarksDAO;
	@Autowired
	private PhotosDAO photosDAO;
	@Autowired
	private UsersDAO usersDAO;
	
	@Override
	public Map<String, Object> getCompareCardDetail(int userNo) {
		
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();

		map.put("user", usersDAO.getOneUser(userNo));
		
		List<Bookmark> poomNoList = bookmarksDAO.getPoomNo(userNo);
		List<Poom> poomList = poomsDAO.getPoomCardDetail(userNo);


		for(Poom poom : poomList) {

			List<Photo> photoList = photosDAO.getPoomCardPhoto(poom.getNo());

			poom.setPhotoList(photoList);
			
		
		}
		
		map.put("pooms",poomList);

		return map;
	
	}
}
