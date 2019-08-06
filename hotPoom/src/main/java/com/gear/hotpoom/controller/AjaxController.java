package com.gear.hotpoom.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gear.hotpoom.service.BankAccountsService;
import com.gear.hotpoom.service.CreditsService;
import com.gear.hotpoom.service.PoomsService;
import com.gear.hotpoom.service.UsersService;
import com.gear.hotpoom.vo.BankAccount;
import com.gear.hotpoom.vo.Credit;
import com.gear.hotpoom.vo.User;

@RestController
@RequestMapping(value = "/ajax")
public class AjaxController {

// *******************************************************************	0803 주하 start
	
	@Autowired
	private UsersService usersService;
	@Autowired
	private CreditsService creditsService;
	@Autowired
	private PoomsService poomsService;
	@Autowired
	private BankAccountsService bankAccountsService;
	
	@RequestMapping(value="/email/{email}", method=RequestMethod.GET)
	public String checkEmail(@PathVariable String email, String check) {
		
		boolean result = usersService.checkEmail(check);
		
				// System.out.println(check);
				// System.out.println(email);
				// System.out.println(result);
		
		return "{\"result\":"+result+"}";
	}//checkEmail() end
	
	@RequestMapping(value="/myCardList/{userNo}", method=RequestMethod.GET)
	public List<Credit> getMyCardList(@PathVariable int userNo) {
		
		return creditsService.getMyCardList(userNo);
	}
	
	@RequestMapping(value="/addCard", method=RequestMethod.POST)
	public int addCard(Credit credit) {
		return creditsService.addCard(credit);
	}
	
	@RequestMapping(value="/removeCard/{cardNo}", method=RequestMethod.DELETE)
	public int removeCard(@PathVariable int cardNo) {
		return creditsService.removeCard(cardNo);
	}
	
	@RequestMapping(value="/setDefault/{userNo}/{no}", method=RequestMethod.PUT)
	public int setDefault(@PathVariable int userNo,@PathVariable int no) {
		System.out.println(userNo);
		System.out.println(no);
		return creditsService.setDefault(userNo, no);
	}
	
	@RequestMapping(value="/updateName/{userNo}/{name}", method=RequestMethod.PUT)
	public int updateName(User user, @PathVariable String name, @PathVariable int userNo) {

		user.setNo(userNo);
		user.setName(name);
		// System.out.println(user.getName());
		
		return usersService.modifyName(user);
	}
	
	@RequestMapping(value="/updatePhoneNum/{userNo}/{phoneNum}", method=RequestMethod.PUT)
	public int updatePhoneNum(User user, @PathVariable String phoneNum, @PathVariable int userNo) {

		user.setNo(userNo);
		user.setPhoneNum(phoneNum);
		System.out.println(user.getPhoneNum());
		
		return usersService.modifyPhoneNum(user);
	}
	
	
	@RequestMapping(value="/compare/{userNo}", method=RequestMethod.GET)
	public Map<String, Object> bookmarkList(@PathVariable int userNo) {
		
	
		return poomsService.getCompareCardDetail(userNo);
	}
	
	@RequestMapping(value="/addAccount", method=RequestMethod.POST)
	public int addAccount(BankAccount bankAccount) {
		
		return bankAccountsService.addAccount(bankAccount);
	}
	
	@RequestMapping(value="/myAccount/{userNo}", method=RequestMethod.GET)
	public BankAccount getMyAccount(@PathVariable int userNo) {
		
		return bankAccountsService.getMyAccount(userNo);
	}
	

}
