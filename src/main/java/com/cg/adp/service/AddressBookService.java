package com.cg.adp.service;

import com.cg.adp.dto.AddressBook;
import com.cg.adp.dto.PersonContact;

public class AddressBookService {
	
	private PersonContactService pcService;
	private AddressBook ab;

	public AddressBookService() {
		pcService=new PersonContactService();
		ab=new AddressBook();
	}
	public void addContact() {
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
