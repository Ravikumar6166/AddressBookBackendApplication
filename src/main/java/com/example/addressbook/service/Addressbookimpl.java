package com.example.addressbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.addressbook.dto.AddressbookDatadto;
import com.example.addressbook.model.AddressbookData;
import com.example.addressbook.repository.AddressbookRepository;

@Service
public class Addressbookimpl implements AddressbookService {

	@Autowired
	private AddressbookRepository addressbookRepository;

	@Override
	public AddressbookData createAddressbookData(AddressbookDatadto addressbookDatadto) {
		// TODO Auto-generated method stub
		AddressbookData addressbookData = new AddressbookData(addressbookDatadto);
		addressbookData.setPersonId(addressbookDatadto.getPersonId());
		addressbookData.setFirstName(addressbookDatadto.getFirstName());
		addressbookData.setLastName(addressbookDatadto.getLastName());
		addressbookData.setAddress(addressbookDatadto.getAddress());
		addressbookData.setCity(addressbookDatadto.getCity());
		addressbookData.setState(addressbookDatadto.getState());
		addressbookData.setZip(addressbookDatadto.getZip());
		addressbookData.setPhone(addressbookDatadto.getPhone());
		addressbookData.setEmail(addressbookDatadto.getEmail());
		addressbookData = addressbookRepository.save(addressbookData);
		return addressbookData;
	}

	@Override
	public AddressbookData getAddressbookDataById(int personId) {
		// TODO Auto-generated method stub
		Optional<AddressbookData> addressbookdata = addressbookRepository.findById(personId);
		if (addressbookdata.isPresent()) {
			return addressbookdata.get();
		} else
			throw new RuntimeException(" Record Not Found");
	}

	@Override
	public List<AddressbookData> getAddressbookData() {
		// TODO Auto-generated method stub
		List<AddressbookData> addressbookDataList = addressbookRepository.findAll();
		if (addressbookDataList.size() > 0) {
			return addressbookDataList;
		}
		return new ArrayList<AddressbookData>();
	}

	@Override
	public AddressbookData updateAddressbookData(int personId, AddressbookDatadto addressbookDatadto) {
		// TODO Auto-generated method stub
		AddressbookData addressbookData = this.getAddressbookDataById(personId);
		addressbookData.updateAddressbookData(addressbookDatadto);
		return addressbookRepository.save(addressbookData);
	}

	@Override
	public void daleteAddressbookData(int personId) {
		// TODO Auto-generated method stub
		AddressbookData addressbookData = this.getAddressbookDataById(personId);
		addressbookRepository.delete(addressbookData);

	}

	@Override
	public List<AddressbookData> getAddressbookDataByCity(String city) {
		// TODO Auto-generated method stub
		return addressbookRepository.findAllByCity(city);
	}

	@Override
	public List<AddressbookData> sortAddressbookByName() {
		// TODO Auto-generated method stub
		return addressbookRepository.sortByName();
	}

	@Override
	public List<AddressbookData> searchByState(String state) {
		// TODO Auto-generated method stub
		List<AddressbookData> addressbookDataList = addressbookRepository.searchState(state);
		return addressbookDataList;
	}

}
