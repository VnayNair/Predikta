package com.predikta.tournament.service;

import java.util.List;

import com.predikta.entity.TournamentDetails;

public interface ITournamentService {
	
	public TournamentDetails addTournamentDetail(TournamentDetails tournament);
	
	public List<TournamentDetails> showAllTournaments();
	
	public void deleteTournamentById(String name);

	TournamentDetails getTournamentById(String name);

	public void updateTournamentDetails(TournamentDetails tournament);
}