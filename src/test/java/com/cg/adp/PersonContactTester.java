package com.cg.adp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PersonContactTester {

	@Test
	public void givenFirstName_whenValid_returnsTrue() {
		PersonContactValidator pcValidator = new PersonContactValidator();
		try {
			assertTrue("Valid", pcValidator.firstNameValidator("John"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void givenFirstName_whenInvalid_returnsFalse() {
		PersonContactValidator pcValidator = new PersonContactValidator();
		try {
			assertFalse("InValid", pcValidator.firstNameValidator("JOhn"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void givenLastName_whenValid_returnsTrue() {
		PersonContactValidator pcValidator = new PersonContactValidator();
		try {
			assertTrue("Valid", pcValidator.lastNameValidator("Doe"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void givenLastName_whenInvalid_returnsFalse() {
		PersonContactValidator pcValidator = new PersonContactValidator();
		try {
			assertFalse("InValid", pcValidator.lastNameValidator("Do"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void givenEmail_whenValid_returnsTrue() {
		PersonContactValidator pcValidator = new PersonContactValidator();
		try {
			assertTrue("Valid", pcValidator.emailValidator("johndoe-20@gmail.com"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void givenEmail_whenInvalid_returnsFalse() {
		PersonContactValidator pcValidator = new PersonContactValidator();
		try {
			assertFalse("InValid", pcValidator.emailValidator("johndoe---20@gmail.com"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void givenZip_whenValid_returnsTrue() {
		PersonContactValidator pcValidator = new PersonContactValidator();
		try {
			assertTrue("Valid", pcValidator.zipValidator(999999l));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void givenZip_whenInvalid_returnsFalse() {
		PersonContactValidator pcValidator = new PersonContactValidator();
		try {
			assertFalse("InValid", pcValidator.zipValidator(99999997686l));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void givenMobileNumber_whenValid_returnsTrue() {
		PersonContactValidator pcValidator = new PersonContactValidator();
		try {
			assertTrue("Valid", pcValidator.mobileNoValidator("00 9999999999"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void givenMobileNumber_whenInvalid_returnsFalse() {
		PersonContactValidator pcValidator = new PersonContactValidator();
		try {
			assertFalse("InValid", pcValidator.mobileNoValidator("00 99999999998"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
