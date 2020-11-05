package com.cg.adp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cg.adp.dto.AddressBook;
import com.cg.adp.dto.PersonContact;
import com.cg.adp.service.AddressBookService;

public class AddressBookTester {

	public static final String AB1 = "AB1.txt";
	public static final String AB2 = "AB2.txt";
	public static final String AB3 = "AB3.csv";
	public static final String AB4 = "AB4.csv";
	public static final String AB5 = "AB5.json";
	public static final String AB6 = "AB6.json";
	public AddressBookService abService;

	@Before
	public void setUp() {
		abService = new AddressBookService();
	}

	@Test
	public void givenAddressBookFileshouldRead() {
		Path p = Paths.get(AB1);
		List<PersonContact> ab = new ArrayList<>();
		try {
			ab = AddressBookFileIOService.readFile(p);
		} catch (PersonContactException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(ab);
		assertTrue(Files.exists(p));

	}

	@Test
	public void givenPersonContactShouldWriteOnFile() {
		Path p = Paths.get(AB2);
		PersonContact personToWrite = new PersonContact("The", "Weeknd", "DontKnow", "Cali", "SomeState", 666666l,
				"00 9999999999", "weeknd.420@gmail.com");
		AddressBookFileIOService.writeToFile(p, personToWrite);
		assertTrue(true);
	}

	@Test
	public void givenAddressBookCSVFileShoudRead() {
		Path p = Paths.get(AB3);
		List<PersonContact> addressBookRead = AddressBookCSVIOService.readCSV(p);
		System.out.println(addressBookRead);
		assertEquals("Donald", addressBookRead.get(0).getFirstName());

	}

	@Test
	public void givenAddressBookShouldWriteOnCSVFile() {
		Path p = Paths.get(AB4);
		PersonContact personToWrite = new PersonContact("The", "Weeknd", "DontKnow", "Cali", "SomeState", 666666l,
				"00 9999999999", "weeknd.420@gmail.com");
		PersonContact personToWrite2 = new PersonContact("Gerard", "Eazy", "DontKnow", "Cali", "SomeState", 666666l,
				"00 9999999999", "weeknd.420@gmail.com");
		List<PersonContact> addressBookWrite = new ArrayList<>();
		addressBookWrite.add(personToWrite);
		addressBookWrite.add(personToWrite2);
		AddressBook abObj = new AddressBook();
		abObj.setAddressBook(addressBookWrite);
		AddressBookCSVIOService.writeCSV(p, abObj);
		List<PersonContact> addressBookRead = AddressBookCSVIOService.readCSV(p);
		assertEquals("The", addressBookRead.get(0).getFirstName());

	}

	@Test
	public void givenAddressBookJSONFileShoudRead() {
		Path p = Paths.get(AB5);
		List<PersonContact> addressBookRead = AddressBookJSON1OService.readJson(p);
		System.out.println(addressBookRead);
		assertEquals("Justin", addressBookRead.get(0).getFirstName());
	}

	@Test
	public void givenAddressBookShouldWriteOnJSONFile() {
		Path p = Paths.get(AB6);
		PersonContact personToWrite = new PersonContact("The", "Weeknd", "DontKnow", "Cali", "SomeState", 666666l,
				"00 9999999999", "weeknd.420@gmail.com");
		PersonContact personToWrite2 = new PersonContact("Gerard", "Eazy", "DontKnow", "Cali", "SomeState", 666666l,
				"00 9999999999", "weeknd.420@gmail.com");
		List<PersonContact> addressBookWrite = new ArrayList<>();
		addressBookWrite.add(personToWrite);
		addressBookWrite.add(personToWrite2);
		AddressBook abObj = new AddressBook();
		abObj.setAddressBook(addressBookWrite);
		AddressBookJSON1OService.writeJson(p, addressBookWrite);
		List<PersonContact> addressBookRead = AddressBookJSON1OService.readJson(p);
		assertEquals("The", addressBookRead.get(0).getFirstName());
	}

	@Test
	public void givenAddressBookDB_ShouldRead() {
		abService.getAddressBookFromDB();
		assertEquals(5, abService.countEntries());
		System.out.println(abService.getAb().getAddressBook());
	}

	@Test
	public void givenAddressBookDB_WhenUpdated_ShouldSyncWithDB() {
		List<PersonContact> personToUpdate=Arrays.asList(new PersonContact("Ashraf", "Ghani", "gardens of babur", "Kabul", "Afghanistan",  555555l, "33 3333333333",  "ashraf-420@gmail.com"));
		abService.getAddressBookFromDB();
		abService.updateAddressBookinDB(personToUpdate);
		assertTrue(abService.checkSync(personToUpdate.get(0).getFirstName(),personToUpdate.get(0).getEmail()));
	}

}
