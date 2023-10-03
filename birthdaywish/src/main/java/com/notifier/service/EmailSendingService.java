package com.notifier.service;

import com.notifier.entity.EmailDetails;

public interface EmailSendingService {
	
	String sendEmailWithsimple(EmailDetails emailDetails,String name);
	String sendEmailWithAttachment(String email,String name);

}
