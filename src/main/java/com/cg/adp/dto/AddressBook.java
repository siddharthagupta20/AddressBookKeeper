package com.cg.adp.dto;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

	private String aname;
	private List<PersonContact> addressBook;

	public AddressBook() {
		aname = "";
		addressBook = new ArrayList<PersonContact>();
	}

	public void setAddressBook(List<PersonContact> addressBook) {
		this.addressBook = addressBook;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public List<PersonContact> getAddressBook() {
		return addressBook;
	}

	public String getAname() {
		return aname;
	}

}
