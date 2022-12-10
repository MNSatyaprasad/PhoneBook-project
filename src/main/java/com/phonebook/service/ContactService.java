package com.phonebook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebook.entity.Contact;
import com.phonebook.repo.IContactRepo;

@Service
public class ContactService implements IContactService{
   
	@Autowired
	private IContactRepo contactRepo;
	
	@Override
	public String saveContact(Contact contact) {
		contactRepo.save(contact);
		return "Contact Saved sucessfully";
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> allContacts = contactRepo.findAll();
		return allContacts;
	}

	@Override
	public Optional<Contact> getContactById(Integer contactId) {
		 Optional<Contact> contact = contactRepo.findById(contactId);
		return contact;
	}

	@Override
	public String updateContact(Contact contact) {
		Contact UpdateContact =contactRepo.save(contact);
		return UpdateContact+"Updated SucessFully";
	}

	@Override
	public String deletecontactById(Integer contactId) {
		 contactRepo.deleteById(contactId);
		return "deletecContact SucessFully";
	}

}
