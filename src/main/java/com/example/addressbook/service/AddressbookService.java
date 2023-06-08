package com.example.addressbook.service;

import java.util.List;

import com.example.addressbook.dto.AddressbookDatadto;
import com.example.addressbook.model.AddressbookData;

public interface AddressbookService {

	AddressbookData createAddressbookData(AddressbookDatadto addressbookDatadto);

	AddressbookData getAddressbookDataById(int personId);

	List<AddressbookData> getAddressbookData();

	AddressbookData updateAddressbookData(int personId, AddressbookDatadto addressbookDatadto);

	void daleteAddressbookData(int personId);

	List<AddressbookData> getAddressbookDataByCity(String city);
	
	List<AddressbookData> sortAddressbookByName();
	
	List<AddressbookData> searchByState(String state);
}
