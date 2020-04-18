package com.predikta.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class TournamentDetailsPk implements Serializable{
	
	private static final long serialVersionUID = -1027463557770860185L;
	
	@Column(name = "TOURNAMENT_NAME")
	private String tournamentName;
	@Column(name = "TOURNAMENT_COUNTRY")
	private String tournamentCountry;
	@Column(name = "TOURNAMENT_SPORT")
	private String tournamentSport;

}
