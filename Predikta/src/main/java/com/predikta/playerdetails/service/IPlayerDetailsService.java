package com.predikta.playerdetails.service;

import java.util.List;

import com.predikta.entity.PlayerDetails;

public interface IPlayerDetailsService {
	
	public PlayerDetails addPlayerDetails(PlayerDetails playerdetail);
	public List<PlayerDetails> getPlayerDetailsForTeam(String teamName);
	List<PlayerDetails> getAllPlayerDetails();
	public List<String> getPlayersInTeam(String teamName);

}
