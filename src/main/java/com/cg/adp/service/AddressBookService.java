package com.cg.adp.service;

import java.util.Collections;
import java.util.Scanner;

import com.cg.adp.dto.AddressBook;
import com.cg.adp.dto.AddressBookKeeper;
import com.cg.adp.dto.PersonContact;
import com.cg.adp.sortclasses.SortByCity;
import com.cg.adp.sortclasses.SortByState;
import com.cg.adp.sortclasses.SortByZip;

public class AddressBookService {
	
	public enum SortingAddressBook{BY_CITY,BY_STATE,BY_ZIP}
	
	private PersonContactService pcService;
	private AddressBook ab;
	private Scanner sc;
	private AddressBookKeeper abe;
	private AddressBookKeeperService abks;

	public AddressBookService() {
		pcService=new PersonContactService();
		ab=new AddressBook();
		sc=new Scanner(System.in);
		abe=new AddressBookKeeper();
		abks=new AddressBookKeeperService();
	}
	public AddressBookKeeper getAbe() {
		return abe;
	}
	public AddressBook getAb() {
		return ab;
	}
	public PersonContactService getPcService() {
		return pcService;
	}
	public AddressBookKeeperService getAbks() {
		return abks;
	}
	
	public void addAddressBook() {
		System.out.println("Enter address book name: ");
		ab.setAname(sc.next());
		abe.getAddressBookKeeper().add(ab);
	}
	public void addContact() {
		if(pcService.addContact()!=null)
			ab.getAddressBook().add(pcService.addContact());
		this.sortAddressBook();
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
	//sorting done after every addition of person contact to address book
	public void sortAddressBook() {
		Collections.sort(this.ab.getAddressBook());
	}
	public void sortAddressBookWithoutNaturalOrder(SortingAddressBook sort) {
		if(sort==SortingAddressBook.BY_CITY)
			Collections.sort(ab.getAddressBook(),new SortByCity());
		if(sort==SortingAddressBook.BY_STATE)
			Collections.sort(ab.getAddressBook(),new SortByState());
		if(sort==SortingAddressBook.BY_ZIP)
			Collections.sort(ab.getAddressBook(),new SortByZip());
	}

}
