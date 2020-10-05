package com.cg.adp.dto;

import java.util.ArrayList;
import java.util.List;

public class AddressBookKeeper {

	private List<AddressBook> addressBookKeeper;

	public AddressBookKeeper() {
		addressBookKeeper = new ArrayList<AddressBook>();

	}

	public List<AddressBook> getAddressBookKeeper() {
		return addressBookKeeper;
	}

	public void setAddressBookKeeper(List<AddressBook> addressBookKeeper) {
		this.addressBookKeeper = addressBookKeeper;
	}

}
