package com.tka;

import java.sql.Date;

public class AuthorsData {
	private String firstName;
	private String lastName;
	private String email;
	private Date date;

	public AuthorsData() {

	}

	public AuthorsData(String firstName, String lastName, String email, Date date) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.date = date;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "AuthorsData [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", date=" + date
				+ "]";
	}

}
