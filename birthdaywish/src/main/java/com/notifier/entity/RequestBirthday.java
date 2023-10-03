package com.notifier.entity;

import java.util.Date;

import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestBirthday {
	private int id;
	private String name;
	@Email(message = "Required Proper Email")
	private String email;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date bdayDate;
}
