package com.cg.adp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.adp.dto.PersonContact;

public class AddressBookDBService {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/address_book?useSSL=false";
	private static final String USER = System.getenv("DB_USER");
	private static final String PASS = System.getenv("DB_PASS");

	private static AddressBookDBService abDBService;

	private AddressBookDBService() {
	}

	public static AddressBookDBService getInstance() {
		if (abDBService == null)
			abDBService = new AddressBookDBService();
		return abDBService;
	}

	public Connection getConnection() {
		try {
			Connection con = DriverManager.getConnection(JDBC_URL, USER, PASS);
			System.out.println("Connection success");
			return con;
		} catch (SQLException e) {
			System.out.println("Connection failure!!");
			return null;
		}
	}

	public List<PersonContact> readAddressBook() {
		String sql = "select * from person_contact;";
		List<PersonContact> ab = new ArrayList<>();
		try (Statement read = this.getConnection().createStatement()) {
			ResultSet result = read.executeQuery(sql);
			while (result.next()) {
				int id = result.getInt("person_id");
				String firstname = result.getString("first_name");
				String lastname = result.getString("last_name");
				String address = "";
				String city = "";
				String state = "";
				long zip = 0;
				String phoneNumber = "";
				String email = result.getString("email");
				Statement readAddress = this.getConnection().createStatement();
				ResultSet resultAddress = readAddress
						.executeQuery("select * from address where person_id =" + id + ";");
				while (resultAddress.next()) {
					address = resultAddress.getString("address");
					city = resultAddress.getString("city");
					state = resultAddress.getString("state");
					zip = resultAddress.getLong("zip");
				}
				Statement readPhoneNumber = this.getConnection().createStatement();
				ResultSet resultPhoneNumber = readAddress
						.executeQuery("select * from phone_numbers where person_id =" + id + ";");
				// getting the last phone number that matches that id
				while (resultPhoneNumber.next())
					phoneNumber = resultPhoneNumber.getString("ph_no");
				ab.add(new PersonContact(id, firstname, lastname, address, city, state, zip, phoneNumber, email));
				readAddress.close();
				readPhoneNumber.close();
			}
			return ab;

		} catch (SQLException e) {
			System.out.println("Cannot read.");
			return null;
		}
	}

	public String getAddressBookName() {
		String sql = "select * from address_books where ab_id=1;";

		try (Statement readAddressBooks = this.getConnection().createStatement()) {
			ResultSet result = readAddressBooks.executeQuery(sql);
			if (result.next())
				return result.getString("ab_name");
			return null;
		} catch (SQLException e) {
			System.out.println("Cannot read address_books table.");
			return null;
		}
	}

	public void updateAddressBook(List<PersonContact> personToUpdate) {
		String sql = "update person_contact set email= ? where first_name= ? ;";
		List<PersonContact> ab = new ArrayList<>();
		try (PreparedStatement read = this.getConnection().prepareStatement(sql)) {
			for (PersonContact p : personToUpdate) {
				read.setString(2, p.getFirstName());
				read.setString(1, p.getEmail());
				int result = read.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("Cannot update.");

		}

	}

	public List<PersonContact> readAddressBook(LocalDate startDate, LocalDate endDate) {
		Date start = Date.valueOf(startDate);
		Date end = Date.valueOf(endDate);
		String sql = "select * from person_contact where date_added between ? and ? ;";
		List<PersonContact> ab = new ArrayList<>();
		try (PreparedStatement read = this.getConnection().prepareStatement(sql)) {
			read.setDate(1, start);
			read.setDate(2, end);
			ResultSet result = read.executeQuery();
			while (result.next()) {
				int id = result.getInt("person_id");
				String firstname = result.getString("first_name");
				String lastname = result.getString("last_name");
				String address = "";
				String city = "";
				String state = "";
				long zip = 0;
				String phoneNumber = "";
				String email = result.getString("email");
				Statement readAddress = this.getConnection().createStatement();
				ResultSet resultAddress = readAddress
						.executeQuery("select * from address where person_id =" + id + ";");
				while (resultAddress.next()) {
					address = resultAddress.getString("address");
					city = resultAddress.getString("city");
					state = resultAddress.getString("state");
					zip = resultAddress.getLong("zip");
				}
				Statement readPhoneNumber = this.getConnection().createStatement();
				ResultSet resultPhoneNumber = readAddress
						.executeQuery("select * from phone_numbers where person_id =" + id + ";");
				// getting the last phone number that matches that id
				while (resultPhoneNumber.next())
					phoneNumber = resultPhoneNumber.getString("ph_no");
				ab.add(new PersonContact(id, firstname, lastname, address, city, state, zip, phoneNumber, email));
				readAddress.close();
				readPhoneNumber.close();
			}
			return ab;

		} catch (SQLException e) {
			System.out.println("Cannot read.");
			return null;
		}
	}

	public Map<String, Integer> readAddressBookCityWise() {
		String sql = "select a.city , count(person_id) as count from person_contact pc\r\n" + "join address a	\r\n"
				+ "	using(person_id)\r\n" + "    group by city;";
		Map<String, Integer> cityWiseCount = new HashMap<>();
		try (Statement read = this.getConnection().createStatement()) {
			ResultSet result = read.executeQuery(sql);
			while (result.next()) {
				cityWiseCount.put(result.getString("city"), result.getInt("count"));
			}
			return cityWiseCount;
		} catch (SQLException e) {
			System.out.println("Cannot read city wise data.");
			return null;
		}
	}

	public Map<String, Integer> readAddressBookStateWise() {
		String sql = "select a.state , count(person_id) as count from person_contact pc\r\n" + "join address a	\r\n"
				+ "	using(person_id)\r\n" + "    group by state;";
		Map<String, Integer> stateWiseCount = new HashMap<>();
		try (Statement read = this.getConnection().createStatement()) {
			ResultSet result = read.executeQuery(sql);
			while (result.next()) {
				stateWiseCount.put(result.getString("state"), result.getInt("count"));
			}
			return stateWiseCount;
		} catch (SQLException e) {
			System.out.println("Cannot read state wise data.");
			return null;
		}
	}

	public void insertInAddressBook(PersonContact personToWrite) {
		String sql="insert into person_contact (first_name,last_name, email,ab_id,type_id,date_added)"
				+ "values(?,?,?,?,?,?);";
		try(PreparedStatement read=this.getConnection().prepareStatement(sql)){
			read.setString(1,personToWrite.getFirstName());
			read.setString(2,personToWrite.getLastName());
			read.setString(3,personToWrite.getEmail());
			read.setInt(4,1);
			read.setInt(5,2);
			read.setDate(6,Date.valueOf(LocalDate.now()));
			int result=read.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println("Cannot insert in person_contact table.");
			
		}
		
	}
}
