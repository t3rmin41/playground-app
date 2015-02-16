package com.some.swedbank.client.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.some.swedbank.client.service.AmusementParkService;
import com.some.swedbank.client.service.entity.park.AmusementPark;

@Controller
@RequestMapping("/park")
public class AmusementParkController {
	
	@Autowired
	private AmusementParkService amusementParkService;
	
	@RequestMapping("/list")
	public String viewListOfAmusementParks(Model model) {
		return prepareAmusementParkListForReview(model);
	}
	
	private String prepareAmusementParkListForReview(Model model) {
		AmusementPark amusementPark = amusementParkService.loadById(1L); 
		model.addAttribute("amusementPark", amusementPark);
		return "park/list";
	}
}
