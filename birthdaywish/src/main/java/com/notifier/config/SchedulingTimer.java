package com.notifier.config;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.notifier.model.BirthdayDetails;
import com.notifier.service.impl.BirthDayServiceImpl;
import com.notifier.service.impl.EmailServiceImpl;

@Service
public class SchedulingTimer {
	
	@Autowired
	private BirthDayServiceImpl birthDayServiceImpl;
	
	@Autowired
	private EmailServiceImpl emailServiceImpl;
	
	
	@Scheduled(cron = "0 00 00 * * *" )
	public void Update() {
		System.out.println("Hello");
		List<BirthdayDetails> birthdayDetails=birthDayServiceImpl.getTodayBirthDay();
	
		if(birthdayDetails.size()>0)
		{
			birthdayDetails.forEach((e)->{
				System.out.println(emailServiceImpl.sendEmailWithAttachment(e.getEmail(), e.getName()));
			});
			
		}
		else {
			System.out.println("No Data for today"+new Date().toLocaleString());
		}
		
		
		birthDayServiceImpl.getAllBdayBoy();
	}
	
	@Scheduled(cron = "0 05 00 * * *")
	public void reset() {
		System.out.println("Reset");
		birthDayServiceImpl.resetAllBday();
	}

}
