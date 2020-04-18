package com.predikta.schedule.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.predikta.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>  {
	
	List<Schedule> findByMatchDate(Date inputDate);

}
