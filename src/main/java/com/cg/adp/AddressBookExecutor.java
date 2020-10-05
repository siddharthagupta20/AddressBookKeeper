package com.cg.adp;

import java.util.Scanner;

import com.cg.adp.service.AddressBookService;

public class AddressBookExecutor {
	private Scanner sc;

	public AddressBookExecutor() {
		// TODO Auto-generated constructor stub
		sc = new Scanner(System.in);
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program: ");
		AddressBookExecutor abe = new AddressBookExecutor();
		AddressBookService abService = new AddressBookService();
		boolean computation = true;
		while (computation) {
			System.out.println("1.Add contact. ");
			System.out.println("2.Edit Contact.");
			System.out.println("3.Remove Contact");
			System.out.println("4.Exit.");
			int option = abe.sc.nextInt();

			switch (option) {
			case 1:
				abService.addContact();
				break;
			case 2:
				abService.updateAddressBook();
				break;
			case 3:
				abService.removeContact();
				break;
			case 4:
				computation=false;
				break;
			}

		}

	}
}
