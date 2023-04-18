package com.gymmanagement.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.gymmanagement.entity.Trainer;

public interface TrainerService {
	
	void registerTrainer(Trainer trainer, MultipartFile trainerPic);
	List<Trainer> getAllTrainers();
	

}