package com.predikta.playerdetails.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.predikta.entity.PlayerDetails;
import com.predikta.playerdetails.repository.PlayerDetailsRepository;

@Service
public class PlayerDetailsServiceImpl implements IPlayerDetailsService {

	@Autowired
	PlayerDetailsRepository playerDetailsRepo;
	
	@Override
	public PlayerDetails addPlayerDetails(PlayerDetails playerdetail) {
		return playerDetailsRepo.save(playerdetail);

	}
	
	@Override
	public List<PlayerDetails> getAllPlayerDetails() {
		return playerDetailsRepo.findAll();
	}

	@Override
	public List<PlayerDetails> getPlayerDetailsForTeam(String teamName) {
		List<PlayerDetails> allPlayerDetails = getAllPlayerDetails();
		return allPlayerDetails.stream().filter(player -> player.getTeamName().equals(teamName))
				.collect(Collectors.toList());
	}

	@Override
	public List<String> getPlayersInTeam(String teamName) {
		List<String> playerInTeam = new ArrayList<>();
		getPlayerDetailsForTeam(teamName).forEach(player -> playerInTeam.add(player.getPlayerName()));
		return playerInTeam;
	}

}
