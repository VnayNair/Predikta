package com.predikta.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "TOURNAMENT")
public class TournamentDetails {
		
	@EmbeddedId
	private TournamentDetailsPk id;
	
	@Column(name = "PLAYER_OF_THE_SERIES")
	private String playerOfTheSeries;

}