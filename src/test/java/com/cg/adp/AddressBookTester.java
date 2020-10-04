package com.cg.adp;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AddressBookTester {

	@Test
	public void givenName_whenValid_returnsTrue() {
		PersonContactValidator pcValidator = new PersonContactValidator();
		try {
			assertTrue("Valid", pcValidator.firstNameValidator("John"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
