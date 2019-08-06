package com.gear.hotpoom.dao;

import java.util.List;

import com.gear.hotpoom.vo.Bookmark;

public interface BookmarksDAO {

	public List<Bookmark> getPoomNo(int userNo);

}
