package com.cg.controller;

import java.util.ArrayList;
import java.util.List;


import com.cg.db.PhonebookDB;
import com.cg.entity.Phonebook;

public class PhonebookController {
	private List<Phonebook> allContacts;
		
    PhonebookDB db ;
	
	public PhonebookController() {
		db = new PhonebookDB();
		allContacts = new ArrayList<>();
	}
	
	public List<Phonebook> getAllContacts()
	{
		return db.getAllContacts();
	}
	
	public Phonebook insertContact(Phonebook userInputcontact)
	{
	
		Phonebook savedContact = db.saveContactInDB(userInputcontact);
		return savedContact;
		
	}

	public List<Phonebook> getContactsByPhone(Long userInputcontact)
	{
		return db.getContactsByPhone(userInputcontact);
	}

	public boolean removeContact(Long userInputcontact)
	{
		return db.removeContact(userInputcontact);
	}


}