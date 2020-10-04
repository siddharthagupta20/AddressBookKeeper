package com.cg.adp.dto;

public class PersonContact {

	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	long zip;
	String phoneNumber;
	String email;

	public PersonContact() {
		// TODO Auto-generated constructor stub
	}

	public PersonContact(String firstname, String lastname, String address, String city, String state, long zip,
			String phoneNumber, String email) {
		this.firstName = firstname;
		this.lastName = lastname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setZip(long zip) {
		this.zip = zip;
	}

	public long getZip() {
		return zip;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "First Name: " + firstName + "\nLast Name: " + lastName + "\nAddress: " + address + "\nCity: " + city
				+ "\nState: " + state + "\nZip: " + zip + "\nPhone Number: " + phoneNumber + "\nEmail: " + email;
	}

}