package com.notifier.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.notifier.entity.RequestBirthday;
import com.notifier.model.BirthdayDetails;
import com.notifier.service.impl.BirthDayServiceImpl;
@CrossOrigin("*")
@RestController()
@RequestMapping("v1/birthday")
public class BirthdayController {
	
	@Autowired
	private BirthDayServiceImpl birthDayServiceImpl;
	

	@PostMapping()
	public ResponseEntity<BirthdayDetails> add(@Valid @RequestBody RequestBirthday birthdayDetails)
	{
		return new ResponseEntity<BirthdayDetails>(birthDayServiceImpl.add(birthdayDetails), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/findBy")
	public ResponseEntity<List<BirthdayDetails>> getAllByName(@RequestParam("name") String name)
	{
		return new ResponseEntity<List<BirthdayDetails>>(birthDayServiceImpl.getByName(name),HttpStatus.OK);
	}
	
	
	@GetMapping()
	public ResponseEntity<List<BirthdayDetails>> getAll()
	{
		return new ResponseEntity<List<BirthdayDetails>>(birthDayServiceImpl.getAll(),HttpStatus.FOUND);
	}
	@GetMapping("/today")
	public ResponseEntity<List<BirthdayDetails>> getAllTodayBirthday()
	{
		return new ResponseEntity<List<BirthdayDetails>>(birthDayServiceImpl.getTodayBirthDay(),HttpStatus.FOUND);
	}
	
	@GetMapping("/all")
	public ResponseEntity<String> SendMessageToALLBDAY()
	{
		return new ResponseEntity<String>(birthDayServiceImpl.getAllBdayBoy(),HttpStatus.FOUND);
	}
	
	@GetMapping("/hello")
	public ResponseEntity<String> hello()
	{
		
		
		return new ResponseEntity<String>("Hello Birthday",HttpStatus.OK);
		
	}
	
}
