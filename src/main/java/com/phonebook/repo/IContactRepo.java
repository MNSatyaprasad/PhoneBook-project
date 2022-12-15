package com.phonebook.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phonebook.entity.Contact;

@Repository
public interface IContactRepo extends JpaRepository<Contact, Integer> {

}
