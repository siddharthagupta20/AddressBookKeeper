package com.cg.adp;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cg.adp.dto.AddressBook;
import com.cg.adp.dto.PersonContact;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class AddressBookCSVIOService {
	
	public static List<PersonContact> readCSV(Path p){
		List<PersonContact> addressBookCsv=new ArrayList<>();
		try {
			Reader reader=Files.newBufferedReader(p);
			CsvToBean<PersonContact> csvToBean=new CsvToBeanBuilder<PersonContact>(reader)
					.withType(PersonContact.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			Iterator<PersonContact> iterator=csvToBean.iterator();
			while(iterator.hasNext()) {
				addressBookCsv.add(iterator.next());
			}
			
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return addressBookCsv;
	}
	public static void writeCSV(Path p, AddressBook addressBook) {
		try {
			Writer writer=Files.newBufferedWriter(p);
			StatefulBeanToCsv<PersonContact> beanToCsv=new StatefulBeanToCsvBuilder<PersonContact>(writer)
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
			beanToCsv.write(addressBook.getAddressBook());
			writer.close();
			
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		catch(CsvDataTypeMismatchException e) {
			System.out.println(e.getMessage());
		}
		catch(CsvRequiredFieldEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

}
