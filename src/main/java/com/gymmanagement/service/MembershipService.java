package com.gymmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gymmanagement.entity.Membership;

@Service
public interface MembershipService {
	
	Membership addCustomerMembership(Membership membership);
	List<Membership> getAllMembership();
	List<Membership> getAllCustomerMembershipById(int customerId);

}
