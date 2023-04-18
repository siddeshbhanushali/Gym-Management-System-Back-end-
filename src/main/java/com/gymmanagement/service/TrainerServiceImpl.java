package com.gymmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.gymmanagement.dao.TrainerDao;
import com.gymmanagement.entity.Trainer;
import com.gymmanagement.utility.StorageService;

@Repository
public class TrainerServiceImpl implements TrainerService {

	@Autowired
	private TrainerDao trainerDao;
	
	@Autowired
	private StorageService storageService;

	@Override
	public void registerTrainer(Trainer trainer, MultipartFile trainerPic) {
        
		String productImageName = storageService.store(trainerPic);
		
		trainer.setPic(productImageName);
		
		this.trainerDao.save(trainer);
		
	}

	@Override
	public List<Trainer> getAllTrainers() {
		
		return this.trainerDao.findAll();
	}
	
	

}
