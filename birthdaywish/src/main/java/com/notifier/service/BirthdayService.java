package com.notifier.service;

import java.text.ParseException;
import java.util.List;

import com.notifier.entity.RequestBirthday;
import com.notifier.model.BirthdayDetails;



public interface BirthdayService {
	
	BirthdayDetails add(RequestBirthday details);
	List<BirthdayDetails> getTodayBirthDay();
	List<BirthdayDetails> getByName(String name);
	List<BirthdayDetails> getAll();
	String getAllBdayBoy();
	String resetAllBday();

}
