package com.predikta.tournament.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.predikta.entity.TournamentDetails;
import com.predikta.tournament.repository.TournamentDetailsRepository;

@Service
public class TournamentServiceImpl implements ITournamentService {

	@Autowired
	TournamentDetailsRepository tournamentDetailsRepository;
	
	@Override
	public TournamentDetails addTournamentDetail(TournamentDetails tournament) {
		return tournamentDetailsRepository.save(tournament);
	}

	@Override
	public List<TournamentDetails> showAllTournaments() {
		return tournamentDetailsRepository.findAll();
	}
	
	@Override
	public TournamentDetails getTournamentById(String name) {
		return tournamentDetailsRepository.findByIdTournamentName(name.trim()).get();
	}

	@Override
	public void deleteTournamentById(String name) {
		tournamentDetailsRepository.deleteByIdTournamentName(name.trim());
	}

	@Override
	public void updateTournamentDetails(TournamentDetails tournament) {
		tournamentDetailsRepository.save(tournament);
		
	}

}
