package com.predikta.tournament.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.predikta.entity.TournamentDetails;

public interface TournamentDetailsRepository extends JpaRepository<TournamentDetails, Long> {

	@Transactional
	void deleteByIdTournamentName(String name);
	
	Optional<TournamentDetails> findByIdTournamentName(String name);

}