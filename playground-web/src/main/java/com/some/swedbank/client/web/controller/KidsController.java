package com.some.swedbank.client.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.some.swedbank.client.service.KidService;
import com.some.swedbank.client.service.entity.person.Kid;

@Controller
@RequestMapping("/kids")
public class KidsController {

	@Autowired
	private KidService kidService;
	
	@RequestMapping("/list")
	public String viewListOfKids(Model model) {
		return prepareKidsListForReview(model);
	}
	
	private String prepareKidsListForReview(Model model) {
		List<Kid> kids = kidService.getAllKids();
		model.addAttribute("kids", kids);
		return "kids/list";
	}
}
