package com.predikta.schedule.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.predikta.entity.Schedule;
import com.predikta.schedule.service.IScheduleService;
import com.predikta.types.DailyMatchInfo;

@Controller
public class ScheduleController {
	
	@Autowired
	IScheduleService scheduleService;
	
	@GetMapping("/addSchedule")
	public String showTournamentDetailsPage(
			@ModelAttribute(name = "schedule") Schedule schedule) {
		return "addSchedulePage";
	}
	
	@RequestMapping("/saveSchedule")
	public String saveTournamentInfo(@ModelAttribute(name = "schedule") Schedule schedule,
			ModelMap modelMap) {
		Schedule savedSchedule = scheduleService.addScheduleInformation(schedule);
		String message = "Saved " +savedSchedule.getMatchNumber()+ " information to the Schedule Table";
		modelMap.addAttribute("message", message);
		return "addSchedulePage";
	}
	
	@RequestMapping("/dispScheduleDetails")
	public String dispTournamentDetails(ModelMap modelMap) {
		List<Schedule> scheduleList = scheduleService.showCompleteSchedule();
		modelMap.addAttribute("scheduleInfo", scheduleList);
		return "displayScheduleDetails";
	}
	
	@GetMapping(value = "/showMatch/{date}", produces = "application/json")
	@ResponseBody
	public List<DailyMatchInfo> showMatchOnDate(@PathVariable("date") String date) throws ParseException {
				
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date matchDate = sdf.parse(date);
		
		return scheduleService.showMatchOnDate(matchDate);
	}
	
//	@RequestMapping(value = "/hello/{name}", produces = "application/json")
//	@ResponseBody
//	public String getHello(@PathVariable("name") String name)
//	{
//		return "Hello World " +name;
//	}

}
