package com.cg.adp;

import java.util.Scanner;

import com.cg.adp.service.AddressBookService;
import com.cg.adp.service.PersonContactService;

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
		System.out.println("Add Address Book(s).");
		boolean compuKeeper = true;
		while (compuKeeper) {
			System.out.println("1.Add address book.");
			System.out.println("2.Search by city");
			System.out.println("3.Search by state");
			System.out.println("4.Exit.");
			int op = abe.sc.nextInt();
			switch (op) {
			case 1:
				abService.addAddressBook();
				break;
			case 2:
				PersonContactService pcService = new PersonContactService();
				abService.getAbks().searchByCity(abService.getAbe(), pcService.gettingFirstName());
				break;
			case 3:
				pcService = new PersonContactService();
				abService.getAbks().searchByState(abService.getAbe(), pcService.gettingFirstName());
				break;

			case 4:
				compuKeeper = false;
				System.out.println("THANKS :)");
				break;
			}
			System.out.println("Enter the address book you want to work on:");
			String abName = abe.sc.next();
			if (abService.getAbks().searchAddressBook(abService.getAbe(), abName)) {

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
						computation = false;
						System.out.println("THANKS :)");
						break;
					}

				}
			}
		}

	}
}
