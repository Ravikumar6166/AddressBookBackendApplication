package com.example.addressbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.addressbook.model.AddressbookData;

@Repository
public interface AddressbookRepository extends JpaRepository<AddressbookData, Integer> {

	@Query("SELECT  addbkdata From AddressbookData addbkdata  where addbkdata .city=:city")
	List<AddressbookData> findAllByCity(String city);

	@Query("SELECT addbkdata  From AddressbookData addbkdata ORDER BY addbkdata.firstName ")
	List<AddressbookData> sortByName();

	@Query("SELECT  addbkdata From AddressbookData addbkdata  where addbkdata .state=:state")
	List<AddressbookData> searchState(@Param("state")String state);

}
