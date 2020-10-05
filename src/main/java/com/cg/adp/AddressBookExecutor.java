package com.cg.adp;

import java.util.Scanner;

import com.cg.adp.service.PersonContactService;

public class AddressBookExecutor {
	private Scanner sc;

	public AddressBookExecutor() {
		// TODO Auto-generated constructor stub
		sc = new Scanner(System.in);
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program: ");
		AddressBookExecutor abe=new AddressBookExecutor();
		boolean computation = true;
		while (computation) {
			System.out.println("Adding a contact in an address book: ");
			PersonContactService pcService = new PersonContactService();
			pcService.addContact();
			System.out.println("Want to add more?(Y/N)");
			char c = abe.sc.next().charAt(0);
			if (c == 'y' || c == 'Y')
				continue;
			else
				computation = false;
		}
	}

}
