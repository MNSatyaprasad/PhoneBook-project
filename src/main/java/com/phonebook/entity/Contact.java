package com.phonebook.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Contact {
	
	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long contactNum;
	

}
