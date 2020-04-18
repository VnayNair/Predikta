package com.predikta.schedule.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.predikta.entity.Schedule;
import com.predikta.playerdetails.service.IPlayerDetailsService;
import com.predikta.schedule.repository.ScheduleRepository;
import com.predikta.types.DailyMatchInfo;

@Service
public class ScheduleServiceImpl implements IScheduleService {

	@Autowired
	ScheduleRepository scheduleRepository;
	
	@Autowired
	IPlayerDetailsService playerDetailsService;
	
	DailyMatchInfo dailyMatchInfo;

	@Override
	public Schedule addScheduleInformation(Schedule schedule) {
		return scheduleRepository.save(schedule);
	}

	@Override
	public List<Schedule> showCompleteSchedule() {
		return scheduleRepository.findAll();
	}

	@Override
	public List<DailyMatchInfo> showMatchOnDate(Date inputDate) {
		List<Schedule> matchOnDate = scheduleRepository.findByMatchDate(inputDate);
		System.out.println(inputDate);
		System.out.println(matchOnDate);
		
		//Map<Long, Map<String, List<String>>> matchDetails = new HashMap<>();
		//Map<String, List<String>> playersInTeam = new HashMap<>();
		
		List<DailyMatchInfo> dailyMatchInfoList = new ArrayList<>();
		
		matchOnDate.forEach(match -> {
//			playersInTeam.put(match.getFirstTeam(), playerDetailsService.getPlayersInTeam(match.getFirstTeam()));
//			playersInTeam.put(match.getSecondTeam(), playerDetailsService.getPlayersInTeam(match.getSecondTeam()));
//			matchDetails.put(match.getMatchNumber(), playersInTeam);
			DailyMatchInfo dailyMatchInfo = new DailyMatchInfo();
			dailyMatchInfo.setMatchNumber(match.getMatchNumber());
			dailyMatchInfo.setMatchDate(match.getMatchDate());
			Map<String, List<String>> firstTeam = new HashMap<>();
			firstTeam.put(match.getFirstTeam(), playerDetailsService.getPlayersInTeam(match.getFirstTeam()));
			dailyMatchInfo.setFirstTeam(firstTeam);
			Map<String, List<String>> secondTeam = new HashMap<>();
			secondTeam.put(match.getSecondTeam(), playerDetailsService.getPlayersInTeam(match.getSecondTeam()));
			dailyMatchInfo.setSecondTeam(secondTeam);
			dailyMatchInfoList.add(dailyMatchInfo);
		});
		
		System.out.println(dailyMatchInfoList);
		
		return dailyMatchInfoList;
	}

}
