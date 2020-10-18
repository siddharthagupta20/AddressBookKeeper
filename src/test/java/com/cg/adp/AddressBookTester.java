package com.cg.adp;

import static org.junit.Assert.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.cg.adp.dto.PersonContact;

public class AddressBookTester {

	public static final String AB1 = "AB1.txt";

	@Test
	public void givenAddressBookFileshouldRead() {
		Path p = Paths.get(AB1);
		List<PersonContact> ab=new ArrayList<>();
		try {
			ab=AddressBookFileIOService.readFile(p);
		} catch (PersonContactException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(ab);
		assertTrue(Files.exists(p));

	}
	@Test
	public void givenPersonContactShouldWriteOnFile() {
		Path p=Paths.get(AB1);
		PersonContact personToWrite=new PersonContact("The","Weeknd","DontKnow","Cali","SomeState",666666l,"00 9999999999","weeknd.420@gmail.com");
		AddressBookFileIOService.writeToFile(p, personToWrite);
		assertTrue(true);
	}

}
