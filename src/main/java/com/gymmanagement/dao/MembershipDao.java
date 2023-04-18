package com.gymmanagement.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gymmanagement.entity.Membership;

@Repository
public interface MembershipDao extends JpaRepository<Membership, Integer> {
	
    List<Membership> findByCustomerIdOrderByIdDesc(int customerId);

    List<Membership> findAllByOrderByIdDesc();
}
