package com.predikta.types;

import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class DailyMatchInfo {
	
	private Long matchNumber;
	private Date matchDate;
	private Map<String, List<String>> firstTeam;
	private Map<String, List<String>> secondTeam;

}
