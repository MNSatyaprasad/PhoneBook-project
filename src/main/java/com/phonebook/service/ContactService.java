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
		contact = contactRepo.save(contact);
		if(contact.getContactId()!= null) {
			return "Contact Saved sucessfully"; 
		}else {
			return "Contact failed to Save";
		}
	
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> allContacts = contactRepo.findAll();
		return allContacts;
	}

	@Override
	public Contact getContactById(Integer contactId) {
		 Optional<Contact> finByid = contactRepo.findById(contactId);
		 
		 if(finByid.isPresent()) {
			 return finByid.get();
		 }
		return null;
	}

	@Override
	public String updateContact(Contact contact) {
	
		if(contactRepo.existsById(contact.getContactId())) {
			contactRepo.save(contact);
			return "Updated Sucessfully";
		}else {
			return "No Record Found";
		}
		
	}

	@Override
	public String deletecontactById(Integer contactId) {
		if(contactRepo.existsById(contactId)) {
			contactRepo.deleteById(contactId);
			return "Record Deleted Sucessfully";
		}else {
			return "No Record Found";
		}
		
	}

}
