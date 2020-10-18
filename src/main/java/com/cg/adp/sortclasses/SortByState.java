package com.cg.adp.sortclasses;

import java.util.Comparator;

import com.cg.adp.dto.PersonContact;

public class SortByState implements Comparator<PersonContact> {
	public int compare(PersonContact p1, PersonContact p2) {
		return p1.getState().compareTo(p2.getState()); 
	}

}
