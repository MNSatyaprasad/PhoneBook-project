package com.phonebook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phonebook.entity.Contact;
import com.phonebook.service.IContactService;

@RestController
public class ContactController {
	
	@Autowired
	private IContactService contactService;
	
	@PostMapping("/save")
	public String saveContact(@RequestBody Contact contact) {
		String savecontact =contactService.saveContact(contact);
		return savecontact;
	}
	
	@GetMapping("/getAllContacts")
	public List<Contact> getAllContacts(){
		List<Contact> allContacts =contactService.getAllContacts();
		return allContacts;
	}
	@GetMapping("/{id}")
	public Optional<Contact> getContactById(@PathVariable("id") Integer contactId){
		Optional<Contact> contactById = contactService.getContactById(contactId);
		return contactById;
	}
	public String updateContact(@RequestBody Contact contact) {
		String updateContact =contactService.updateContact(contact);
		return updateContact;
	}

}