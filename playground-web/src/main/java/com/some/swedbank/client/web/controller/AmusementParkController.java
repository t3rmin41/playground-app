package com.some.swedbank.client.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.some.swedbank.client.service.AmusementParkService;
import com.some.swedbank.client.service.KidService;
import com.some.swedbank.client.service.entity.park.AmusementPark;
import com.some.swedbank.client.service.entity.person.Kid;

@Controller
@RequestMapping("/park")
public class AmusementParkController {
	
	@Autowired
	private AmusementParkService amusementParkService;
	
	@Autowired 
	private KidService kidService;
	
	@RequestMapping("/list")
	public String viewListOfAmusementParks(Model model) {
		return prepareAmusementParkListForReview(model);
	}
	
	@RequestMapping("/add-kid-to-playsite")
	public String addKidToPlaySite(Model model) {
		return prepareAmusementParkListForReview(model);
	}
	
	private String prepareAmusementParkListForReview(Model model) {
		List<AmusementPark> amusementParkList = amusementParkService.getAllAmusementParks();
		List<Kid> kids = kidService.getAllKids();
		model.addAttribute("amusementParkList", amusementParkList);
		model.addAttribute("kids", kids);
		return "park/list";
	}
}
