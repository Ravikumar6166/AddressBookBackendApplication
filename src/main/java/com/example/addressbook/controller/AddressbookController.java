package com.example.addressbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.addressbook.dto.AddressbookDatadto;
import com.example.addressbook.model.AddressbookData;
import com.example.addressbook.service.AddressbookService;

@RestController
@RequestMapping("/addressbook")
public class AddressbookController {

	@Autowired
	private AddressbookService addressbookService;

	@PostMapping("/create")
	public ResponseEntity<AddressbookData> addAddressbookData(@RequestBody AddressbookDatadto addressbookDatadto) {
		AddressbookData addressbookData = new AddressbookData(addressbookDatadto);
		addressbookData = addressbookService.createAddressbookData(addressbookDatadto);
		return new ResponseEntity<AddressbookData>(addressbookData, HttpStatus.OK);

	}

	@GetMapping("/get/{personId}")
	public ResponseEntity<AddressbookData> getAddressbookData(@PathVariable(value = "personId") int personId) {
		AddressbookData addressbookData = null;
		addressbookData = addressbookService.getAddressbookDataById(personId);
		return new ResponseEntity<AddressbookData>(addressbookData, HttpStatus.OK);

	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<List<AddressbookData>> getAddressbookData() {
		List<AddressbookData> addressbookDataList = addressbookService.getAddressbookData();
		return new ResponseEntity<List<AddressbookData>>(addressbookDataList, HttpStatus.OK);

	}

	@PutMapping("/update/{personId}")
	public ResponseEntity<AddressbookData> updateAddressbookData(@PathVariable int personId,
			@RequestBody AddressbookDatadto addressbookDatadto) {
		AddressbookData addressbookData = null;
		addressbookData = addressbookService.updateAddressbookData(personId, addressbookDatadto);
		return new ResponseEntity<AddressbookData>(addressbookData, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{personId}")
	public ResponseEntity<AddressbookData> deleteAddressbookData(@PathVariable(value = "personId") int personId) {
		addressbookService.daleteAddressbookData(personId);
		return new ResponseEntity<AddressbookData>(HttpStatus.OK);

	}

	@GetMapping("/getByCity/{city}")
	public ResponseEntity<List<AddressbookData>> getAddressbookDataByCity(@PathVariable String city) {
		List<AddressbookData> addressbookDataList = null;
		addressbookDataList = addressbookService.getAddressbookDataByCity(city);
		return new ResponseEntity<List<AddressbookData>>(addressbookDataList, HttpStatus.OK);

	}
	@GetMapping("/sortByName")
	public ResponseEntity<List<AddressbookData>> sortAddressbookByName(){
		List<AddressbookData> addressbookDataList = null;
		addressbookDataList = addressbookService.sortAddressbookByName();
		return new ResponseEntity<List<AddressbookData>>(addressbookDataList, HttpStatus.OK);

	}
	@GetMapping("/search")
	public ResponseEntity<List<AddressbookData>>searchByState(@RequestParam(value="state") String state){
		List<AddressbookData> addressbookDataList = null;
		addressbookDataList = addressbookService.searchByState(state);
		return new ResponseEntity<List<AddressbookData>>(addressbookDataList, HttpStatus.OK);
}
}


