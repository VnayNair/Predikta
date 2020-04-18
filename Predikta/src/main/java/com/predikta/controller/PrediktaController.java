package com.predikta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.predikta.entity.UserUpdate;

@Controller
public class PrediktaController {
	
	@RequestMapping("/makePrediction")
	public String makePredictionsPage(@ModelAttribute(name = "userUpdate") UserUpdate userUpdate)
	{
		return "makePredictions";
	}
	
	@RequestMapping("/submitPrediction")
	@ResponseBody
	public String submitPredictionsPage(@ModelAttribute(name = "userUpdate") UserUpdate userUpdate)
	{
		return "<h1>"+userUpdate.getPlayerOfMatch1()+"</h1>";
		//return "makePredictions";
	}

}
