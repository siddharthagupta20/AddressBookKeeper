package com.cg.adp;

import com.cg.adp.service.PersonContactService;

public class AddressBookExecutor {
	
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program: ");
		
		System.out.println("Adding a contact in an address book: ");
		PersonContactService pcService=new PersonContactService();
		pcService.addContact();
	}

}
