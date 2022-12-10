package com.phonebook.service;

import java.util.List;
import java.util.Optional;

import com.phonebook.entity.Contact;

public interface IContactService {

	public String saveContact(Contact contact);
	
	public List<Contact> getAllContacts();
	
	public Contact getContactById(Integer contactId);
	
	public String updateContact(Contact contact);
	
	public String deletecontactById(Integer contactId);
	
}
