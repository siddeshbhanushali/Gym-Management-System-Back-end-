package com.gymmanagement.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.gymmanagement.dto.AddMembershipDto;
import com.gymmanagement.dto.CustomerMembershipDetailResponse;
import com.gymmanagement.entity.Customer;
import com.gymmanagement.entity.Membership;
import com.gymmanagement.service.CustomerService;
import com.gymmanagement.service.MembershipService;
import com.gymmanagement.service.PackageService;

@RestController
@RequestMapping("api/membership/")
@CrossOrigin(origins = "http://localhost:3000")
public class MembershipController {
	
	@Autowired
	private MembershipService membershipService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired 
	private PackageService packageService;
	
	@PostMapping("add")
	public ResponseEntity<?> addMembership( AddMembershipDto addMembershipDto) {
		System.out.println("recieved request for Add Customer membership");
		System.out.println(addMembershipDto);
		
		// dd-mm-yyyy
		String startDate = null;
	    String endDate= null;  
	    
	    LocalDate today = LocalDate.now();
	    startDate = today.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		
		Customer customer = this.customerService.getCustomerByClientId(addMembershipDto.getClientId()).get(0);
		
		com.gymmanagement.entity.Package packageDetail = packageService.getPackageById(addMembershipDto.getPackageId());
		
		if(packageDetail.getName().equals("Month")) {   
			LocalDate monthDate = today.plusMonths(1);
			endDate = monthDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		}
		
		else if(packageDetail.getName().equals("Quater")) {  
			LocalDate monthDate = today.plusMonths(3);
			endDate = monthDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		}
		
        else if(packageDetail.getName().equals("Semi-Annual")) { 
        	LocalDate monthDate = today.plusMonths(6);
			endDate = monthDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		}
		
        else if(packageDetail.getName().equals("Annual")) {
        	LocalDate monthDate = today.plusMonths(12);
			endDate = monthDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
		}
		
		Membership membership = new Membership();
		membership.setCustomerId(customer.getId());
		membership.setPackageId(addMembershipDto.getPackageId());
		membership.setPaymentStatus(addMembershipDto.getPaymentStatus());
		membership.setStartDate(startDate);
		membership.setEndDate(endDate);
		
		membershipService.addCustomerMembership(membership);
		
		System.out.println("response sent!!!");
		return ResponseEntity.ok(membership);
		
	}
	
	@GetMapping("all")
	public ResponseEntity<?> getAllMembership() throws Exception {
		
		System.out.println("request came for getting all membership");
		
		List<Membership> memberships = new ArrayList<>();
		
		memberships = membershipService.getAllMembership();
		
		System.out.println("response sent!!!");
		
		return ResponseEntity.ok(memberships);
		
	}
	
	@GetMapping("customer/clientId")
	public ResponseEntity<?> getCustomerMembership(@RequestParam("clientId") String clientId) throws Exception {
		
		System.out.println("request came for getting customer membership in descending order");
		
		Customer customer = this.customerService.getCustomerByClientId(clientId).get(0);
		
		List<Membership> memberships = new ArrayList<>();
		
		memberships = membershipService.getAllCustomerMembershipById(customer.getId());
		
		List<CustomerMembershipDetailResponse> customerMembershipDetails = new ArrayList<>(); 
		
		for(Membership membership : memberships) {
			CustomerMembershipDetailResponse customerMembership = new CustomerMembershipDetailResponse();
			
			com.gymmanagement.entity.Package packageDetail = packageService.getPackageById(membership.getPackageId());
			
			customerMembership.setClientId(clientId);
			customerMembership.setCustomerName(customer.getName());
			customerMembership.setCustomerPic(customer.getPic());
			customerMembership.setEndDate(membership.getEndDate());
			customerMembership.setStartDate(membership.getStartDate());
			customerMembership.setPaymentStatus(membership.getPaymentStatus());
			customerMembership.setPrice(packageDetail.getFee());
			customerMembership.setPackageName(packageDetail.getName());
			
			customerMembershipDetails.add(customerMembership);
		}
		
		
		System.out.println(customerMembershipDetails.toString());
		System.out.println("response sent!!!");
		
		return ResponseEntity.ok(customerMembershipDetails);
		
	}

}
