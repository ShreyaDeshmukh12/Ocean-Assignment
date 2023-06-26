package com.cg.db;

import java.util.ArrayList;
import java.util.List;

import com.cg.entity.Phonebook;


public class PhonebookDB {
	
	List<Phonebook> allContacts = new ArrayList<>();

	public List<Phonebook> getAllContacts() {

		return allContacts;
	}

	public Phonebook saveContactInDB(Phonebook userInputcontact) {
		
		if(userInputcontact != null) {
			boolean status = allContacts.add(userInputcontact);
			if(status)
				return userInputcontact;
			else
				return null;
		}
		else
            return null;
	}

	public List<Phonebook> getContactsByPhone(long searchuserInputPhoneNumber) {
		
		List<Phonebook> outputContacts = new ArrayList<>();
		
		for(Phonebook contact : allContacts) {
			
			if(contact.getPhoneNumber() ==(searchuserInputPhoneNumber)) {
				
				outputContacts.add(contact);
			}
		}

		return outputContacts;
	}

	public boolean removeContact(long phoneNumber) {
		
		for(Phonebook contact : allContacts) {
			
			if(contact.getPhoneNumber() == phoneNumber) {
				allContacts.remove(contact);
				return true;
			}
			
		}
		return false;
	}

}