package com.cg.adp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import com.cg.adp.dto.PersonContact;
import com.google.gson.Gson;

public class AddressBookJSON1OService {
	
	public static List<PersonContact> readJson(Path p){
		PersonContact[] persons=new PersonContact[2];
		try {
			BufferedReader br=new BufferedReader(new FileReader(p.toFile()));
			Gson gson=new Gson();
			persons=gson.fromJson(br,PersonContact[].class);
			
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return Arrays.asList(persons);
	}
	public static void writeJson(Path p,List<PersonContact> addressBook) {
		try {
			Gson gson=new Gson();
			FileWriter writer=new FileWriter(p.toFile());
			String str=gson.toJson(addressBook);
			writer.write(str);
			writer.close();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
