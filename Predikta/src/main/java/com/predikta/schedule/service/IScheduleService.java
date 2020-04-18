package com.predikta.schedule.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.predikta.entity.Schedule;
import com.predikta.types.DailyMatchInfo;

public interface IScheduleService {
	
	Schedule addScheduleInformation(Schedule schedule);

	List<Schedule> showCompleteSchedule();
	
	List<DailyMatchInfo> showMatchOnDate(Date inputDate);

}
