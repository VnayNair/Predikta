package com.predikta.playerdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.predikta.entity.PlayerDetails;
import com.predikta.playerdetails.service.IPlayerDetailsService;

@Controller
public class PlayerDetailsController {
	
	@Autowired
	IPlayerDetailsService playerDetailsService;
	
	@GetMapping("/addPlayer")
	public String showPlayerDetailsPage(
			@ModelAttribute(name = "playerDetails") PlayerDetails playerDetails) {
		return "addPlayerPage";
	}

	@RequestMapping("/savePlayerInfo")
	public String savePlayerInfo(@ModelAttribute(name = "playerDetails") PlayerDetails playerDetails,
			ModelMap modelMap) {
		PlayerDetails playerDetail = playerDetailsService.addPlayerDetails(playerDetails);
		String message = "Saved " +playerDetail.getPlayerId() +" to the Player Table";
		modelMap.addAttribute("message", message);
		return "addPlayerPage";
	}

	@RequestMapping("/dispPlayerDetails")
	public String dispPlayerDetails(ModelMap modelMap) {
		List<PlayerDetails> players = playerDetailsService.getAllPlayerDetails();
		modelMap.addAttribute("players", players);
		return "displayPlayerDetails";
	}

}
