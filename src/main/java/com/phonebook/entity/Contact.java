package com.phonebook.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
	@Id
	@GeneratedValue
	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long contactNum;
	

}
