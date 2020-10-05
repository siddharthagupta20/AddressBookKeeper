package com.cg.adp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.cg.adp.dto.AddressBook;
import com.cg.adp.dto.AddressBookKeeper;
import com.cg.adp.dto.PersonContact;

public class AddressBookKeeperService {
	private Map<String, ArrayList<PersonContact>> cityMap;
	private Map<String, ArrayList<PersonContact>> stateMap;

	public AddressBookKeeperService() {
		cityMap = new HashMap<String, ArrayList<PersonContact>>();
		stateMap = new HashMap<String, ArrayList<PersonContact>>();

	}

	public void searchByCity(AddressBookKeeper abKeeper, String fname) {
		for (AddressBook ab : abKeeper.getAddressBookKeeper()) {
			for (PersonContact pc : ab.getAddressBook()) {
				if (cityMap.containsKey(pc.getCity()))
					cityMap.put(pc.getCity(), null);
				else
					cityMap.put(pc.getCity(), null);
			}
		}
		for (Map.Entry<String, ArrayList<PersonContact>> m : cityMap.entrySet()) {
			ArrayList<PersonContact> pcCity = new ArrayList<PersonContact>();
			for (AddressBook ab : abKeeper.getAddressBookKeeper()) {
				for (PersonContact pc : ab.getAddressBook()) {
					if (m.getKey() == pc.getCity())
						pcCity.add(pc);
				}
			}
			cityMap.put((String) m.getKey(), pcCity);
		}
		for (Map.Entry<String, ArrayList<PersonContact>> m : cityMap.entrySet()) {
			for (PersonContact p : m.getValue()) {
				if (fname == p.getFirstName())
					System.out.println(m.getKey());
			}
		}
	}

	public void searchByState(AddressBookKeeper abKeeper, String fname) {
		for (AddressBook ab : abKeeper.getAddressBookKeeper()) {
			for (PersonContact pc : ab.getAddressBook()) {
				if (stateMap.containsKey(pc.getCity()))
					stateMap.put(pc.getState(), null);
				else
					stateMap.put(pc.getState(), null);
			}
		}
		for (Map.Entry<String, ArrayList<PersonContact>> m : cityMap.entrySet()) {
			ArrayList<PersonContact> pcState = new ArrayList<PersonContact>();
			for (AddressBook ab : abKeeper.getAddressBookKeeper()) {
				for (PersonContact pc : ab.getAddressBook()) {
					if (m.getKey() == pc.getState())
						pcState.add(pc);
				}
			}
			cityMap.put(m.getKey(), pcState);
		}
		for (Map.Entry<String, ArrayList<PersonContact>> m : stateMap.entrySet())
			for (PersonContact p : m.getValue()) {
				if (fname == p.getFirstName()) {
					System.out.println(m.getKey());
				}
			}
	}

	public boolean searchAddressBook(AddressBookKeeper abKeeper, String name) {
		for (AddressBook ab : abKeeper.getAddressBookKeeper())
			if (ab.getAname().equalsIgnoreCase(name))
				return true;
		return false;

	}

	public void viewByCity() {
		for (Map.Entry<String, ArrayList<PersonContact>> m : cityMap.entrySet()) {
			System.out.println("City: " + m.getKey());
			for (PersonContact p : m.getValue())
				System.out.print(p.getFirstName() + " " + p.getLastName() + '\t');
		}
	}

	public void viewByState() {
		for (Map.Entry<String, ArrayList<PersonContact>> m : stateMap.entrySet()) {
			System.out.println("State: " + m.getKey());
			for (PersonContact p : m.getValue()) {
				System.out.print(p.getFirstName() + " " + p.getLastName() + '\t');
			}
		}
	}

	public void countByCity() {
		for (Map.Entry<String, ArrayList<PersonContact>> m : cityMap.entrySet()) {
			System.out.println("City: " + m.getKey() + " Persons: " + m.getValue().size());

		}
	}

	public void countByState() {
		for (Map.Entry<String, ArrayList<PersonContact>> m : stateMap.entrySet()) {
			System.out.println("State: " + m.getKey() + " Persons: " + m.getValue().size());

		}
	}
}

