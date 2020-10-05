package com.cg.adp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonContactValidator {
	
	public boolean firstNameValidator(String fname) {
		String firstName = fname;
		Pattern pattern = Pattern.compile("^([A-Z])[a-z]{2,}$");
		Matcher matcher = pattern.matcher(firstName);
		Boolean b = matcher.find();
		try {
			if (b)
				return true;
			else
				throw new PersonContactException("Enter a valid first name");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean lastNameValidator(String lname) {
		String lastName = lname;
		Pattern pattern = Pattern.compile("^([A-Z])[a-z]{2,}$");
		Matcher matcher = pattern.matcher(lastName);
		Boolean b = matcher.find();
		try {
			if (b)
				return true;
			else
				throw new PersonContactException("Enter a valid last name");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean emailValidator(String email) {
		String emailString = email;
		Pattern pattern = Pattern.compile("^[a-zA-Z]*([_+-.][a-zA-Z0-9]+){0,1}@[a-z0-9]+[.][a-z]{2,3}([.][a-zA-Z]{2,3}){0,1}$");
		Matcher matcher = pattern.matcher(emailString);
		Boolean b = matcher.find();
		try {
			if (b)
				return true;
			else
				throw new PersonContactException("Enter a valid email");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean mobileNoValidator(String mobileNo) {
		String mob = mobileNo;
		Pattern pattern = Pattern.compile("^\\d{2} [1-9]\\d{9}$");
		Matcher matcher = pattern.matcher(mob);
		Boolean b = matcher.find();
		try {
			if (b)
				return true;
			else
				throw new PersonContactException("Enter a valid mobile no.");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean zipValidator(long zip) {
		String zip1 =Long.toString(zip);
		Pattern pattern = Pattern.compile("^\\d{6}$");
		Matcher matcher = pattern.matcher(zip1);
		Boolean b = matcher.find();
		try {
			if (b)
				return true;
			else
				throw new PersonContactException("Enter a valid zip");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
