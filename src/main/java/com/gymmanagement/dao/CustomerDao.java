package com.gymmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymmanagement.entity.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{
	
	Customer findByEmailIdAndPassword(String emailId, String password);
	List<Customer> findByClientId(String clientId);
	List<Customer> findByName(String name);
	List<Customer> findByNameContainingIgnoreCase(String name);
	Customer findByContact(String contact);

}
