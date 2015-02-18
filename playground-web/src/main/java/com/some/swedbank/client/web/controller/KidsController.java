package com.some.swedbank.client.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.some.swedbank.client.service.KidService;
import com.some.swedbank.client.service.entity.person.Kid;

@Controller
@RequestMapping("/kids")
//@SessionAttributes("kids")
public class KidsController {

	@Autowired
	private KidService kidService;
	
	@RequestMapping("/list")
	public String viewListOfKids(Model model) {
		return initialKidsListForReview(model);
	}
	
	@RequestMapping(value = "/addNewKid", method = RequestMethod.POST)
	public String addNewKid(@ModelAttribute("newKid") Kid addedKid, Model model) {
		//model.a
		return prepareKidsListForReview(model);
	}
	
	private String initialKidsListForReview(Model model) {
		List<Kid> kids = kidService.getAllKids();
		model.addAttribute("kids", kids);
		model.addAttribute("newKid", new Kid( (long) kids.size()));
		return "kids/list";
	}
	
	private String prepareKidsListForReview(Model model) {
		//model.addAttribute("kids", kids);
		//model.addAttribute("newKid", new Kid( (long) kids.size()));
		return "kids/list";
	}
}
