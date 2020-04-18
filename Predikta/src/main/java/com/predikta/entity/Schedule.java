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
@Table(name="SCHEDULE")
public class Schedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MATCH_NUMBER")
	private Long matchNumber;
	@Column(name = "MATCH_DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date matchDate;
	@Column(name = "FIRST_TEAM")
	private String firstTeam;
	@Column(name = "SECOND_TEAM")
	private String secondTeam;
	@Column(name = "WINNER")
	private String winner;
	@Column(name = "PLAYER_OF_THE_MATCH")
	private String playerOfTheMatch;

}
