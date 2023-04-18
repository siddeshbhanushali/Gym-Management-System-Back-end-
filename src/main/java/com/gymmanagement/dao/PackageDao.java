package com.gymmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageDao extends JpaRepository<com.gymmanagement.entity.Package, Integer>{

}
