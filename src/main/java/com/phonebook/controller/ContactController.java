package com.phonebook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phonebook.entity.Contact;
import com.phonebook.service.IContactService;

@RestController
public class ContactController {
	
	@Autowired
	private IContactService contactService;
	
	@PostMapping("/contact")
	public String createContact(@RequestBody Contact contact) {
		String savecontact =contactService.saveContact(contact);
		return savecontact;
	}
	
	@GetMapping("/contacts")
	public List<Contact> getAllContacts(){
		List<Contact> allContacts =contactService.getAllContacts();
		return allContacts;
	}
	@GetMapping("/contact/{contactId}")
	public Contact getContactById(@PathVariable Integer contactId){
		Contact contactById = contactService.getContactById(contactId);
		return contactById;
	}
	@PutMapping("/contact")
	public String updateContact(@RequestBody Contact contact) {
		String updateContact =contactService.updateContact(contact);
		return updateContact;
	}

	@DeleteMapping("/contact/{contactId}")
	public String deleteContact(@PathVariable Integer contactId) {
		String status = contactService.deletecontactById(contactId);
		return status;
	}
}
