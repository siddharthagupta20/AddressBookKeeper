package com.cg.adp;

import java.util.Scanner;

import com.cg.adp.dto.AddressBook;
import com.cg.adp.dto.PersonContact;
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
		PersonContactService pcService = new PersonContactService();
		AddressBook ab = new AddressBook();
		boolean computation = true;
		while (computation) {
			System.out.println("1.Add contact. ");
			System.out.println("2.Edit Contact.");
			int option = abe.sc.nextInt();

			switch (option) {
			case 1:
				ab.getAddressBook().add(pcService.addContact());
				break;
			case 2:
				String firstName = pcService.gettingFirstName();
				int y = 0;
				for (PersonContact x : ab.getAddressBook()) {
					if (x.getFirstName().equalsIgnoreCase(firstName)) {
						break;
					}
					y++;
				}
				pcService.updateContact(ab.getAddressBook().get(y));
				break;
			default:
				break;
			}
			System.out.println("Want to add more?(Y/N)");
			char c = abe.sc.next().charAt(0);
			if (c == 'y' || c == 'Y')
				continue;
			else
				computation = false;

		}

	}
}
