package com.cg.main;

import java.util.List;
import java.util.Scanner;

import com.cg.controller.PhonebookController;
import com.cg.entity.Phonebook;

public class Main {
	
	Scanner sc = new Scanner(System.in);
	PhonebookController server = new PhonebookController();
	
	public static void main(String[] args) {
		
		Main app = new Main();
		
		while(true)
		{
			System.out.println("\n\n-------- App MENU ---------");
			System.out.println("1.Add Contact.");
			System.out.println("2.Display all contacts.");
			System.out.println("3.Search contact by phone.");
			System.out.println("4.Remove contact");
			System.out.println("0. EXIT ");
			
			System.out.println(" --- Enter Choice :- ");
			int choice = Integer.parseInt(app.sc.nextLine());
			
			switch (choice) {
			case 1:
				app.takeUserInputForPhonebooks();
				break;
			
			case 2:
				app.displayAllContacts();
				break;
				
			case 3:
				app.getContactsByPhone();
				break;
			

			case 4:
				app.removeContact();
				break;
							
			case 0:
				System.exit(0);
				break;
			


			default:
				break;
		}
		
	}
	
}


	private void takeUserInputForPhonebooks() {

		try {
			System.out.println("\n\t Enter Contact Details \n");
			
			System.out.println("\n Enter First Name ");
			String firstName = sc.nextLine();
			
			System.out.println("\n Enter Last Name ");
			String lastName = sc.nextLine();
			
			System.out.println("\n Enter Phone Number ");
			long phoneNumber = Long.parseLong(sc.nextLine());
			
			System.out.println("\n Enter Email ");
			String emailId = sc.nextLine();
			
			
			Phonebook userInputPhonebook = new Phonebook(firstName, lastName, phoneNumber, emailId);

			Phonebook serverSavedContact = server.insertContact(userInputPhonebook);
			
			if(serverSavedContact != null)
				displayContacts(serverSavedContact,"Contact Inserted !!!");
			else
				displayErrors("Contact Not Saved , Try again or check Authority ");
			
		}
		catch (Exception e) {
			displayErrors(" Wrong Input , Enter Again");
			takeUserInputForPhonebooks();
		}
	
	}
	

	private void displayAllContacts() {

        List<Phonebook> allContacts = server.getAllContacts();
		
		System.out.println("\n\n ----All Saved Contacts---");
		
		for (Phonebook contact : allContacts) {
			displayContacts(contact, "");
		}
	}
	
	public void displayErrors(String errorMsg)
	{
		System.out.println("_______ !!! Error !!! _________________________");
		System.out.println(errorMsg);
	}


	private void displayContacts(Phonebook contact, String string) {

		System.out.println(string);
		System.out.println(contact.getFirstName()+" - "+contact.getLastName()+" - "+contact.getPhoneNumber()+" - "+contact.getEmailId());
	
	}

	private void getContactsByPhone() {

		System.out.println("\n Enter Search Contact Phone Number ");
		long phoneNumber = Long.parseLong(sc.nextLine());
		
		List<Phonebook> outputDate = server.getContactsByPhone(phoneNumber);
		
		System.out.println("----- ALL "+phoneNumber+" Contacts-----");
		
		for(Phonebook contact : outputDate) {
			
			displayContacts(contact,"");
		}
		
	}

	private void removeContact() {

		System.out.println("\n Enter Contact Phone Number To Remove");
		long phoneNumber = Long.parseLong(sc.nextLine());
		
	    boolean removed = server.removeContact(phoneNumber);
	    
	    if (removed) {
	        System.out.println("Contact with phone number " + phoneNumber + " has been removed successfully.");
	    } else {
	        System.out.println("Contact with phone number " + phoneNumber + " was not found.");
	    }

	}

}