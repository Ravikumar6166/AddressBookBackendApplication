package com.example.addressbook.model;

import com.example.addressbook.dto.AddressbookDatadto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AddressbookData {

	@Id
	@Column(name = "person")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int personId;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;
	private String email;

	
	

	public AddressbookData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressbookData(AddressbookDatadto addressbookDatadto) {
		// TODO Auto-generated constructor stub
		/*
		 * this.personId=addressbookDatadto.personId; this.firstName =
		 * addressbookDatadto. firstName; this.lastName = addressbookDatadto.lastName;
		 * this.address =addressbookDatadto. address; this.city =
		 * addressbookDatadto.city; this.state = addressbookDatadto.state; this.zip =
		 * addressbookDatadto.zip; this.phone =addressbookDatadto. phone; this.email
		 * =addressbookDatadto. email;
		 */
	}
	
	public void updateAddressbookData(AddressbookDatadto addressbookDatadto) {
		this.firstName = addressbookDatadto. firstName;
		this.lastName = addressbookDatadto.lastName;
		this.address =addressbookDatadto. address;
		this.city = addressbookDatadto.city;
		this.state = addressbookDatadto.state;
		this.zip = addressbookDatadto.zip;
		this.phone =addressbookDatadto. phone;
		this.email =addressbookDatadto. email;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
