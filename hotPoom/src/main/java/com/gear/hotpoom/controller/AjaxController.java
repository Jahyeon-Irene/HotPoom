package com.gear.hotpoom.controller;


import java.util.List; 
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gear.hotpoom.service.BookingsService;
import com.gear.hotpoom.service.UsersService;
import com.gear.hotpoom.vo.User;

import com.gear.hotpoom.service.AddressesService;
import com.gear.hotpoom.service.PoomsService;
import com.gear.hotpoom.service.SpeciesService;
import com.gear.hotpoom.vo.Address;
import com.gear.hotpoom.vo.Poom;
import com.gear.hotpoom.vo.Species;
import com.gear.hotpoom.service.PoomsService;
import com.gear.hotpoom.service.SpeciesService;

@RestController
@RequestMapping(value="/ajax")
public class AjaxController {
	@Autowired
	private BookingsService bookingsService;
	@Autowired
	private SpeciesService speciesService;
	@Autowired
	private PoomsService poomsService;
	@Autowired
	private AddressesService addressesService;
	
	//booking
	@RequestMapping(value="/booking",method=RequestMethod.GET)
	public Map<String,Object> getBookingList(int userNo, int pageNo) {
		return bookingsService.getList(userNo, pageNo);
	}
	
	//Species 자동완성
	@RequestMapping(value="/species/auto/{species}", method=RequestMethod.GET)
	public List<Species> autocompleteSpecies(@PathVariable String species ) {
		
		return speciesService.getList(species);
	}//autocompleteSpecies() end
	
	
	//hot poom list
	@RequestMapping(value="/hot/poom", method=RequestMethod.GET)
	public List<Poom> getHotPoomList() {
		return poomsService.getListHP();
	}//getHotPoomList() end
	
	
	//location 자동완성
	@RequestMapping(value="/location/auto/{location}", method=RequestMethod.GET)
	public List<Address> autocompleteLocation(@PathVariable String location) {
		return addressesService.getList(location);
	}//autocompleteLocation() end
	
	
	@RequestMapping(value="poom/page/{page}", method=RequestMethod.GET)
	public Map<String, Object> getPoomList(@PathVariable int page, int speciesNo, int petCnt, int lowPrice, int highPrice, int sort){
		return poomsService.getPoomList(page, 5, speciesNo, petCnt, lowPrice, highPrice, sort);
	}
	
	@RequestMapping(value="poom/species/{name}", method=RequestMethod.GET)
	public Map<String, Object> searchSpeciesName(@PathVariable String name){
		System.out.println("controller"+name);
		return speciesService.searchSpeciesName(name);
	}
	
}
