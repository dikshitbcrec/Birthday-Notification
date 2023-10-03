package com.notifier.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailDetails {
	
	 private String recipient;
	    private String msgBody;
	    private String subject;
	    private String attachment;

}
