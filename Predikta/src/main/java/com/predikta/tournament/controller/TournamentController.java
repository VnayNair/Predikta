package com.predikta.tournament.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.predikta.entity.TournamentDetails;
import com.predikta.tournament.service.ITournamentService;

@Controller
public class TournamentController {

	@Autowired
	ITournamentService tournamentService;

	@GetMapping("/addTournament")
	public String showTournamentDetailsPage(
			@ModelAttribute(name = "tournamentDetails") TournamentDetails tournamentDetails) {
		return "createTournament";
	}

	@RequestMapping("/saveTournamentInfo")
	public String saveTournamentInfo(@ModelAttribute(name = "tournamentDetails") TournamentDetails tournamentDetails,
			ModelMap modelMap) {
		TournamentDetails tournament = tournamentService.addTournamentDetail(tournamentDetails);
		String message = "Saved " +tournament.getId().getTournamentName()+ " to the Tournament Table";
		modelMap.addAttribute("message", message);
		return "createTournament";
	}

	@RequestMapping("/dispTournamentDetails")
	public String dispTournamentDetails(ModelMap modelMap) {
		List<TournamentDetails> tournaments = tournamentService.showAllTournaments();
		modelMap.addAttribute("tournaments", tournaments);
		return "displayTournamentDetails";
	}
	
	@RequestMapping("/deleteTournamentEntry")
	public String deleteTournamentEntry(@RequestParam("name") String name, ModelMap modelMap) {
		tournamentService.deleteTournamentById(name);
		List<TournamentDetails> tournaments = tournamentService.showAllTournaments();
		modelMap.addAttribute("tournaments", tournaments);
		return "displayTournamentDetails";
	}
	
	@RequestMapping("/showUpdateTournament")
	public String showUpdateTournament(@RequestParam("name") String name, ModelMap modelMap) {
		TournamentDetails tournamentToBeUpdated = tournamentService.getTournamentById(name);
		modelMap.addAttribute("tournament", tournamentToBeUpdated);
		return "updateTournament";
	}
	
	@RequestMapping("/updateTournament")
	public String updateTournament(@ModelAttribute("tournament") TournamentDetails tournament, ModelMap modelMap) {
		System.out.println(tournament);
		tournamentService.updateTournamentDetails(tournament);
		List<TournamentDetails> tournaments = tournamentService.showAllTournaments();
		modelMap.addAttribute("tournaments", tournaments);
		return "displayTournamentDetails";
	}

}