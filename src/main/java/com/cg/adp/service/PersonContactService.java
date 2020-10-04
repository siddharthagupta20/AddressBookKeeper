package com.cg.adp.service;

import java.util.Scanner;

import com.cg.adp.PersonContactValidator;
import com.cg.adp.dto.*;

public class PersonContactService {

	private PersonContact personContact;
	private Scanner sc;

	public PersonContactService() {
		personContact = new PersonContact();
		sc = new Scanner(System.in);
	}

	public PersonContact addContact() {
		PersonContactValidator pcValidator = new PersonContactValidator();
		System.out.println("Enter person details: ");
		System.out.println("Enter first name: ");
		String firstName = sc.nextLine();
		while (!pcValidator.firstNameValidator(firstName)) {
			System.out.println("Enter first name: ");
			firstName = sc.nextLine();
		}

		System.out.println("Enter last name: ");
		String lastName = sc.nextLine();
		while(!pcValidator.lastNameValidator(lastName)) {
			System.out.println("Enter Last Name: ");
			lastName=sc.nextLine();
		}
		System.out.println("Enter address: ");
		String address = sc.nextLine();
		System.out.println("Enter city: ");
		String city = sc.nextLine();
		System.out.println("Enter state: ");
		String state = sc.nextLine();
		System.out.println("Enter zip: ");
		long zip = sc.nextLong();
		while(!pcValidator.zipValidator(zip)) {
			System.out.println("Enter zip: ");
			zip=sc.nextLong();
		}
		System.out.println("Enter phone number: ");
		sc.nextLine();
		String phoneNumber = sc.nextLine();
		while(!pcValidator.mobileNoValidator(phoneNumber)) {
			System.out.println("Enter phone no: ");
			phoneNumber=sc.nextLine();
		}
		System.out.println("Enter email: ");
		String email = sc.nextLine();
		while(!pcValidator.emailValidator(email)) {
			System.out.println("Enter email: ");
			email=sc.nextLine();
		}
		personContact = new PersonContact(firstName, lastName, address, city, state, zip, phoneNumber, email);
		return personContact;
	}

}
