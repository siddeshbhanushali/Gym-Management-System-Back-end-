package com.gymmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gymmanagement.entity.Trainer;

@Repository
public interface TrainerDao extends JpaRepository<Trainer, Integer> {

}
