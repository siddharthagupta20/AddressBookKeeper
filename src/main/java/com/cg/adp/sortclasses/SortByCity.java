package com.cg.adp.sortclasses;

import java.util.Comparator;

import com.cg.adp.dto.PersonContact;

public class SortByCity implements Comparator<PersonContact> {
	public int compare(PersonContact p1, PersonContact p2) {
		return p1.getCity().compareTo(p2.getCity());
	}
}
