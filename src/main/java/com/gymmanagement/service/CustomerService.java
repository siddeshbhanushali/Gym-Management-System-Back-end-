package com.gymmanagement.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.gymmanagement.entity.Customer;
public interface CustomerService {
	
	void registerCustomer(Customer customer, MultipartFile customerPic);
	List<Customer> getAllCustomer();
	Customer loginCustomer(String emailId, String password);
	List<Customer> getCustomerByClientId(String clientId);
	List<Customer> getCustomerByName(String name);
	Customer getCustomerByContact(String contact);

}
