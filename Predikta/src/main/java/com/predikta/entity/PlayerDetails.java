package com.predikta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="SQUADS")
public class PlayerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PLAYER_ID")
	private int playerId;
	@Column(name = "PLAYER_NAME")
	private String playerName;
	@Column(name = "TEAM_NAME")
	private String teamName;
	@Column(name = "POSITION")
	private String position;

}
