package com.gear.hotpoom.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gear.hotpoom.dao.BankAccountsDAO;
import com.gear.hotpoom.dao.BanksDAO;
import com.gear.hotpoom.dao.ChatRoomsDAO;
import com.gear.hotpoom.dao.ChatUsersDAO;
import com.gear.hotpoom.dao.UsersDAO;
import com.gear.hotpoom.vo.ChatRoom;
import com.gear.hotpoom.vo.User;

@Service
public class UsersServiceImpl implements UsersService{

	// *************************************************** 0803 주하 start

	@Autowired
	private UsersDAO usersDAO;
	@Autowired
	private BanksDAO banksDAO;
	@Autowired
	private BankAccountsDAO bankAccountsDAO;
	@Autowired
	private ChatRoomsDAO chatRoomsDAO;
	@Autowired
	private ChatUsersDAO chatUsersDAO;
	

	@Override
	public boolean checkEmail(String email) {
		return 0 == usersDAO.selectCheckEmail(email);
	}
	
	@Override
	public int sign(User user) {
	
		usersDAO.insert(user);
		ChatRoom chatRoom = new ChatRoom();
		chatRoomsDAO.addChatRoom(chatRoom);
		System.out.println("addChatRoom");
		int roomNo = chatRoom.getNo();
		
		chatUsersDAO.insertAdminChatUser(roomNo);
		System.out.println("insertAdminChatUser");
		// setRoomNo
		user.setRoomNo(roomNo);
		chatUsersDAO.insert(user);
		System.out.println("insert");
		
		System.out.println("sign");
		
		return 1;
	}
	
	@Override
	public Map<String, Object> getAccountDetail(int userNo) {
		Map<String, Object> map = new ConcurrentHashMap<String, Object>();
		
	
		if(bankAccountsDAO.selectMyAccount(userNo)!=null) {

			map.put("bankList", banksDAO.banksList());
			map.put("cardList", banksDAO.banksList());
			map.put("user", usersDAO.getOneUser(userNo));
			map.put("userAccount", bankAccountsDAO.selectMyAccount(userNo));
		}else {
			map.put("bankList", banksDAO.banksList());
			map.put("cardList", banksDAO.banksList());
			map.put("user", usersDAO.getOneUser(userNo));
			
		}
	
		return map;
	}
	
	@Override
	public int modifyName(User user) {
		// TODO Auto-generated method stub
		return usersDAO.updateName(user);
	}
	
	@Override
	public int modifyPhoneNum(User user) {
		// TODO Auto-generated method stub
		return usersDAO.updatePhoneNum(user);
	}
	
}
