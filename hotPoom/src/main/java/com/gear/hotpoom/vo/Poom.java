package com.gear.hotpoom.vo;

import java.sql.Timestamp;
import java.util.List;




public class Poom {
	private int no, userNo, speciesNo, price, petCnt;
	//************************************************ 0804 주하 추가

	private double lat, lng;
	private String type, title, checkIn, checkOut, introduce, amenity, mainAddress, subAddress, postNum, phoneNum, transport,
	//************************************************ 0804 주하 추가
	speciesName, reviewScore, reviewCnt;
	private Timestamp regdate;
	// *********************************************** 0805 주하
	private List<Photo> photoList;
	
	public Poom() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Photo> getPhotoList() {
		return photoList;
	}




	public void setPhotoList(List<Photo> photoList) {
		this.photoList = photoList;
	}




	public String getSpeciesName() {
		return speciesName;
	}



	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}



	public String getReviewScore() {
		return reviewScore;
	}



	public void setReviewScore(String reviewScore) {
		this.reviewScore = reviewScore;
	}



	public String getReviewCnt() {
		return reviewCnt;
	}



	public void setReviewCnt(String reviewCnt) {
		this.reviewCnt = reviewCnt;
	}



	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getSpeciesNo() {
		return speciesNo;
	}

	public void setSpeciesNo(int speciesNo) {
		this.speciesNo = speciesNo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPetCnt() {
		return petCnt;
	}

	public void setPetCnt(int petCnt) {
		this.petCnt = petCnt;
	}


	public double getLat() {
		return lat;
	}


	public void setLat(double lat) {
		this.lat = lat;
	}


	public double getLng() {
		return lng;
	}


	public void setLng(double lng) {
		this.lng = lng;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getAmenity() {
		return amenity;
	}

	public void setAmenity(String amenity) {
		this.amenity = amenity;
	}

	public String getMainAddress() {
		return mainAddress;
	}

	public void setMainAddress(String mainAddress) {
		this.mainAddress = mainAddress;
	}

	public String getSubAddress() {
		return subAddress;
	}

	public void setSubAddress(String subAddress) {
		this.subAddress = subAddress;
	}

	public String getPostNum() {
		return postNum;
	}

	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
}
