package com.cg.adp.sortclasses;

import java.util.Comparator;

import com.cg.adp.dto.PersonContact;

public class SortByZip implements Comparator<PersonContact> {
	public int compare(PersonContact p1, PersonContact p2) {
		return ((Long) p1.getZip()).compareTo(p2.getZip());
	}

}
