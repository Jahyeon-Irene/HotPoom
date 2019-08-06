package com.gear.hotpoom.controller;

import java.sql.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gear.hotpoom.service.BankAccountsService;
import com.gear.hotpoom.service.UsersService;
import com.gear.hotpoom.vo.BankAccount;
import com.gear.hotpoom.vo.User;


@Controller
public class UserController {
	
	@Autowired
	private UsersService usersService;
	@Autowired
	private BankAccountsService BankAccountsService;

	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String signUpForm() {
		
		return "signUpForm";
	}//signUpForm() end
	
	// 회원가입
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String sign(User user, @RequestHeader String referer, int year, int month, int date) {
				
		String birthDateStr = year+"-"+month+"-"+date;
		
		Date birthDate = Date.valueOf(birthDateStr);
		
		user.setBirthDate(birthDate);
		
		user.setProfileImg("defaultProfile.jpg");
		user.setIntroduce("안녕하세요.");

		usersService.sign(user);
		
		return "redirect:/index";
	}//sign() end
	
	// 계정 관리
	@RequestMapping(value="/account/{userNo}", method=RequestMethod.GET)
	public String account(Model model, @PathVariable int userNo) {
		
		model.addAllAttributes(usersService.getAccountDetail(userNo));
		
		return "account";
	}//account() end
	
	// 계좌 삭제
	@RequestMapping(value="/user/account/{no}/{userNo}", method=RequestMethod.DELETE)
	public String deleteAccount(@PathVariable int no, @PathVariable int userNo) {
		
		BankAccountsService.remove(no);
		
		return "redirect:/account/{userNo}";
	}//deleteAccount() end
	
	
}


