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

		abKeeper.getAddressBookKeeper().stream().forEach(ab -> ab.getAddressBook().stream()
				.filter(pc -> !cityMap.containsKey(pc.getCity()))
					.forEach(pc -> cityMap.put(pc.getCity(), null)));

		for (Map.Entry<String, ArrayList<PersonContact>> m : cityMap.entrySet()) {
			ArrayList<PersonContact> pcCity = new ArrayList<PersonContact>();
			for (AddressBook ab : abKeeper.getAddressBookKeeper())
				ab.getAddressBook().stream().filter(pc -> m.getKey() == pc.getCity())
					.forEach(pc -> pcCity.add(pc));
			cityMap.put(m.getKey(), pcCity);
		}
		
		for (Map.Entry<String, ArrayList<PersonContact>> m : cityMap.entrySet()) {
			m.getValue().stream().filter(pc->fname==pc.getFirstName())
				.forEach(System.out::println);
		}
	}

	public void searchByState(AddressBookKeeper abKeeper, String fname) {

		abKeeper.getAddressBookKeeper().stream().forEach(ab -> ab.getAddressBook().stream()
				.filter(pc->!stateMap.containsKey(pc.getState()))
					.forEach(pc->stateMap.put(pc.getState(),null)));
		
		for (Map.Entry<String, ArrayList<PersonContact>> m : cityMap.entrySet()) {
			ArrayList<PersonContact> pcState = new ArrayList<PersonContact>();
			for (AddressBook ab : abKeeper.getAddressBookKeeper()) 
				ab.getAddressBook().stream().filter(pc -> m.getKey() == pc.getState())
					.forEach(pc -> pcState.add(pc));
			
			stateMap.put(m.getKey(), pcState);
		}
		
		stateMap.entrySet().stream().map(Map.Entry::getValue)
			.forEach(pcList->pcList.stream()
					.filter(pc->fname==pc.getFirstName())
						.forEach(System.out::println));
	}

	public boolean searchAddressBook(AddressBookKeeper abKeeper, String name) {
		return abKeeper.getAddressBookKeeper().parallelStream()
				.anyMatch(abk->name==abk.getAname());

	}

	public void viewByCity() {
		for (Map.Entry<String, ArrayList<PersonContact>> m : cityMap.entrySet()) {
			System.out.println("City: " + m.getKey());
			m.getValue().stream().forEach(System.out::println);
		}
	}

	public void viewByState() {
		for (Map.Entry<String, ArrayList<PersonContact>> m : stateMap.entrySet()) {
			System.out.println("State: " + m.getKey());
			m.getValue().parallelStream().forEach(System.out::println);
		}
	}

	public void countByCity() {
		cityMap.entrySet().stream().filter(cities->
			{System.out.print("City:"+cities.getKey());
			return true;})
			.map(Map.Entry::getValue).forEach(pcList->
					System.out.println(" No of person: " + pcList.size()));
		
	}

	public void countByState() {
		stateMap.entrySet().stream().filter(states->
		{ System.out.println("State: "+states.getKey());
		return true;
		}).map(Map.Entry::getValue).forEach(pcList->System.out.println("No of person:"+pcList.size()));
	}
}
