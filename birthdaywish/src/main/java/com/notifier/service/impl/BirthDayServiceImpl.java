package com.notifier.service.impl;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notifier.entity.RequestBirthday;
import com.notifier.model.BirthdayDetails;
import com.notifier.repository.BirthdayRepository;
import com.notifier.service.BirthdayService;

@Service
public class BirthDayServiceImpl implements BirthdayService {
	
	@Autowired
	private BirthdayRepository birthdayRepository;

	@Override
	public BirthdayDetails add(RequestBirthday details){
		
		
		
		
		
		BirthdayDetails birthdayDetail = BirthdayDetails
				.builder()
				.bdayDate(details.getBdayDate())
				.email(details.getEmail())
				.name(details.getName())
				.build();
		
		return birthdayRepository.save(birthdayDetail);
	}

	@Override
	public List<BirthdayDetails> getTodayBirthDay() {
		
		return birthdayRepository.findAllBirthday();
	}

	@Override
	public List<BirthdayDetails> getByName(String name) {
		return birthdayRepository.findAllByName(name);
	}

	@Override
	public List<BirthdayDetails> getAll() {
		return birthdayRepository.findAll();
	}

	@Override
	public String  getAllBdayBoy() {
		
		try {
			birthdayRepository.findAllBdayBoy();
			return "Updated Successfully";
		}
		catch(Exception exception)
		{
			
			exception.printStackTrace();
			return "Problem Occurs";
			
		}
		
	}

	@Override
	public String resetAllBday() {
		try {
			birthdayRepository.resetBirthday();
			return "Reset Successfully";
		}
		catch(Exception exception)
		{
			
			exception.printStackTrace();
			return "Problem  Occured in Reset_Account";
			
		}
		
	}

}
