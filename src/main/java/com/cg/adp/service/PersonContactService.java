package com.cg.adp.service;

import java.util.Scanner;

import com.cg.adp.PersonContactValidator;
import com.cg.adp.dto.*;

public class PersonContactService {

	private PersonContact personContact;
	private Scanner sc;
	private PersonContactValidator pcValidator;

	public PersonContactService() {
		personContact = new PersonContact();
		sc = new Scanner(System.in);
		pcValidator = new PersonContactValidator();
	}

	public PersonContact getPersonContact() {
		return personContact;
	}

	public void setPersonContact(PersonContact personContact) {
		this.personContact = personContact;
	}

	public String gettingFirstName() {
		System.out.println("Enter first name: ");
		String firstName = sc.nextLine();
		while (!pcValidator.firstNameValidator(firstName)) {
			System.out.println("Enter first name: ");
			firstName = sc.nextLine();
		}
		return firstName;
	}

	public String gettingLastName() {
		System.out.println("Enter last name: ");
		String lastName = sc.nextLine();
		while (!pcValidator.lastNameValidator(lastName)) {
			System.out.println("Enter Last Name: ");
			lastName = sc.nextLine();
		}
		return lastName;
	}

	public String gettingAddress() {
		System.out.println("Enter address: ");
		return sc.nextLine();
	}

	public String gettingCity() {
		System.out.println("Enter city: ");
		return sc.nextLine();
	}

	public String gettingState() {
		System.out.println("Enter state: ");
		return sc.nextLine();
	}

	public long gettingZip() {
		System.out.println("Enter zip: ");
		long zip = sc.nextLong();
		while (!pcValidator.zipValidator(zip)) {
			System.out.println("Enter zip: ");
			zip = sc.nextLong();
		}
		return zip;
	}

	public String gettingPhoneNumber() {
		System.out.println("Enter phone number: ");
		sc.nextLine();
		String phoneNumber = sc.nextLine();
		while (!pcValidator.mobileNoValidator(phoneNumber)) {
			System.out.println("Enter phone no: ");
			phoneNumber = sc.nextLine();
		}
		return phoneNumber;
	}

	public String gettingEmail() {
		System.out.println("Enter email: ");
		String email = sc.nextLine();
		while (!pcValidator.emailValidator(email)) {
			System.out.println("Enter email: ");
			email = sc.nextLine();
		}
		return email;
	}

	public PersonContact addContact() {

		System.out.println("Enter person details: ");
		personContact = new PersonContact(gettingFirstName(), gettingLastName(), gettingAddress(), gettingCity(),
				gettingState(), gettingZip(), gettingPhoneNumber(), gettingEmail());
		return personContact;
	}

	public void updateContact(PersonContact personContact) {

		boolean computation = true;
		while (computation) {

			System.out.println("1.) FirstName Update");
			System.out.println("2.) LastName Update");
			System.out.println("3.) Address Update");
			System.out.println("4.) City Update");
			System.out.println("5.) State Update");
			System.out.println("6.) Zip Update");
			System.out.println("7.) Phone Update");
			System.out.println("8.) Email Update");
			System.out.println("9.) Exit");
			int options = sc.nextInt();

			switch (options) {
			case 1:
				personContact.setFirstName(gettingFirstName());
				break;
			case 2:
				personContact.setLastName(gettingLastName());

				break;
			case 3:
				personContact.setAddress(gettingAddress());

				break;
			case 4:
				personContact.setCity(gettingCity());

				break;
			case 5:
				personContact.setState(gettingState());

				break;
			case 6:
				personContact.setZip(gettingZip());

				break;
			case 7:
				personContact.setPhoneNumber(gettingPhoneNumber());

				break;
			case 8:
				personContact.setFirstName(gettingEmail());

				break;
			case 9:
				System.out.println("Exit");
				computation = false;

				return;
			default:
				System.out.println("INVALID ENTRY");
				break;
			}
		}

	}
}
