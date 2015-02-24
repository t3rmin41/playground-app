package com.some.client.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.some.client.service.PlaySiteService;
import com.some.client.service.entity.playsite.PlaySite;

@Controller
@RequestMapping("/playsite")
public class PlaySiteController {
	
	@Autowired
	private PlaySiteService playSiteService;
	
	@RequestMapping("/list")
	public String viewPlaySiteList(Model model) {
		return preparePlaySitekListForReview(model);
	}
	
	private String preparePlaySitekListForReview(Model model) {
		List<PlaySite> playsites = playSiteService.getAllPlaySites(); 
		model.addAttribute("playsites", playsites);
		return "playsite/list";
	}
}
