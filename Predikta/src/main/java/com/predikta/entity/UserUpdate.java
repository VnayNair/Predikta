package com.predikta.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
@Table(name="USER_UPDATE")
public class UserUpdate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "PLAYER_ID")
	private int predictionId;
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "MATCH_DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date matchDate;
	@Column(name = "MATCH_NUMBER")
	private int matchNumber;
	@Column(name = "PLAYER_OF_THE_MATCH_1")
	private String playerOfMatch1;
	@Column(name = "PLAYER_OF_THE_MATCH_2")
	private String playerOfMatch2;
	@Column(name = "PLAYER_OF_THE_MATCH_3")
	private String playerOfMatch3;
	@Column(name = "WINNING_TEAM")
	private String winningTeam;
	@Column(name = "SCORE")
	private String score;

}
