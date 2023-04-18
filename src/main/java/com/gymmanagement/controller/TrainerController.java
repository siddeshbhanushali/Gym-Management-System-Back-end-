package com.gymmanagement.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gymmanagement.dto.AddTrainerRequestDto;
import com.gymmanagement.entity.Trainer;
import com.gymmanagement.service.TrainerService;
import com.gymmanagement.utility.Helper;
import com.gymmanagement.utility.StorageService;

@RestController
@RequestMapping("api/trainer/")
@CrossOrigin(origins = "http://localhost:3000")
public class TrainerController {
	
	@Autowired
	private TrainerService trainerService;
	
	@Autowired
	private StorageService storageService;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@PostMapping("register")
	public ResponseEntity<?> addProduct(AddTrainerRequestDto addTrainerRequestDto) {
		System.out.println("recieved request for Register Trainer");
		System.out.println(addTrainerRequestDto);
		
		String trainerId = Helper.getAlphaNumericId();
		
		Trainer trainer= AddTrainerRequestDto.toEntity(addTrainerRequestDto);
		trainer.setTrainerId(trainerId);
		
		trainerService.registerTrainer(trainer, addTrainerRequestDto.getPic());
		
		System.out.println("response sent!!!");
		return ResponseEntity.ok(trainer);
		
	}

	@GetMapping(value="/{trainePic}", produces = "image/*")
	public void fetchProductImage(@PathVariable("trainePic") String trainePic, HttpServletResponse resp) {
		System.out.println("request came for fetching trainer pic");
		System.out.println("Loading file: " + trainePic);
		Resource resource = storageService.load(trainePic);
		if(resource != null) {
			try(InputStream in = resource.getInputStream()) {
				ServletOutputStream out = resp.getOutputStream();
				FileCopyUtils.copy(in, out);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("response sent!");
	}
	
	@GetMapping("all")
	public ResponseEntity<?> getAllTrainers() throws Exception {
		
		System.out.println("request came for getting all trainers");
		
		List<Trainer> trainers = new ArrayList<Trainer>();
		
		trainers = trainerService.getAllTrainers();
		
		String json = objectMapper.writeValueAsString(trainers);
		
		System.out.println(json);
		
		System.out.println("response sent!!!");
		
		return ResponseEntity.ok(trainers);
		
	}
	
}
