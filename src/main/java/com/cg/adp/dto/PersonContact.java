package com.cg.adp.dto;

import com.opencsv.bean.CsvBindByName;

public class PersonContact implements Comparable<PersonContact> {

	@CsvBindByName(column = "FirstName", required = true)
	String firstName;
	@CsvBindByName
	String lastName;
	@CsvBindByName
	String address;
	@CsvBindByName
	String city;
	@CsvBindByName
	String state;
	@CsvBindByName
	long zip;
	@CsvBindByName(column="PNo")
	String phoneNumber;
	@CsvBindByName(column = "Email", required = true)
	String email;

	public PersonContact() {
		// TODO Auto-generated constructor stub
		this.firstName = "";
		this.lastName = "";
		this.address = "";
		this.city = "";
		this.state = "";
		this.zip = 0l;
		this.phoneNumber = "";
		this.email = "";
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
		return firstName + ", " + lastName + ", " + address + ", " + city + ", " + state + ",  " + zip + ", "
				+ phoneNumber + ",  " + email + "\n";
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof PersonContact))
			return false;
		PersonContact pc = (PersonContact) o;
		return ((this.firstName == pc.firstName) && (this.lastName == pc.lastName));

	}

	@Override
	public int compareTo(PersonContact other) {
		int compareFName = this.firstName.compareTo(other.firstName);
		return (compareFName == 0) ? this.lastName.compareTo(other.lastName) : compareFName;

	}

}