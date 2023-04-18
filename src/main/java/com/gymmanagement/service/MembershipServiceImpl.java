package com.gymmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymmanagement.dao.MembershipDao;
import com.gymmanagement.entity.Membership;

@Service
public class MembershipServiceImpl implements MembershipService {

	@Autowired
	private MembershipDao membershipDao;
	
	@Override
	public Membership addCustomerMembership(Membership membership) {
		return this.membershipDao.save(membership);
	}

	@Override
	public List<Membership> getAllMembership() {
		return this.membershipDao.findAllByOrderByIdDesc();
	}

	@Override
	public List<Membership> getAllCustomerMembershipById(int customerId) {
		return this.membershipDao.findByCustomerIdOrderByIdDesc(customerId);
	}

}
