package com.cg.adp.service;

import java.util.Scanner;

import com.cg.adp.dto.AddressBook;
import com.cg.adp.dto.AddressBookKeeper;
import com.cg.adp.dto.PersonContact;

public class AddressBookService {
	
	private PersonContactService pcService;
	private AddressBook ab;
	private Scanner sc;
	private AddressBookKeeper abe;

	public AddressBookService() {
		pcService=new PersonContactService();
		ab=new AddressBook();
		sc=new Scanner(System.in);
		abe=new AddressBookKeeper();
	}
	
	public void addAddressBook() {
		System.out.println("Enter address book name: ");
		ab.setAname(sc.next());
		abe.getAddressBookKeeper().add(ab);
	}
	public void addContact() {
		if(pcService.addContact()!=null)
			ab.getAddressBook().add(pcService.addContact());
	}
	public void updateAddressBook() {
		String firstName = pcService.gettingFirstName();
		int y = 0;
		for (PersonContact x : ab.getAddressBook()) {
			if (x.getFirstName().equalsIgnoreCase(firstName)) {
				break;
			}
			y++;
		}
		pcService.updateContact(ab.getAddressBook().get(y));
	}
	public void removeContact() {
		String firstName = pcService.gettingFirstName();
		int y = 0;
		for (PersonContact x : ab.getAddressBook()) {
			if (x.getFirstName().equalsIgnoreCase(firstName)) {
				break;
			}
			y++;
		}
		ab.getAddressBook().remove(y);
	}

}
