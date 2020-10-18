package com.cg.adp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.cg.adp.dto.PersonContact;

public class AddressBookFileIOService {

	public static List<PersonContact> readFile(Path p) throws PersonContactException {
		List<PersonContact> ab = new ArrayList<PersonContact>();
		PersonContactValidator pcValidator = new PersonContactValidator();
		try {
			Files.lines(p).map(line -> line.trim()).forEach(line -> {
				String[] data = line.split("[\\s,]+");
				String fname = data[0];
				String lname = data[1];
				String address = data[2];
				String city = data[3];
				String state = data[4];
				long zip = Long.parseLong(data[5]);
				String pno = data[6] + " " + data[7];
				String email = data[8];
				if (pcValidator.firstNameValidator(fname) && pcValidator.lastNameValidator(lname)
						&& pcValidator.zipValidator(zip) && pcValidator.mobileNoValidator(pno)
						&& pcValidator.emailValidator(email))
					ab.add(new PersonContact(fname, lname, address, city, state, zip, pno, email));

			});
			return ab;
		}

		catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public static void writeToFile(Path p, PersonContact personDetailToWrite) {
		try {
			Files.write(p, personDetailToWrite.toString().getBytes());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
