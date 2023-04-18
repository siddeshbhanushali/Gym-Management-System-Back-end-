package com.gymmanagement.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gymmanagement.service.PackageService;

@RestController
@RequestMapping("api/package/")
@CrossOrigin(origins = "http://localhost:3000")
public class PackageController {
	
	@Autowired
	private PackageService packageService;
	
	@PostMapping("add")
	public ResponseEntity<?> addPackage(com.gymmanagement.entity.Package packge) {
		System.out.println("recieved request for Add package");
	
		System.out.println(packge);
		
		packageService.addPackage(packge);
		
		System.out.println("response sent!!!");
		return ResponseEntity.ok(packge);
		
	}
	
	@GetMapping("all")
	public ResponseEntity<?> getAllCustomer() throws Exception {
		
		System.out.println("request came for getting all package");
		
		List<com.gymmanagement.entity.Package> packages = new ArrayList<com.gymmanagement.entity.Package>();
		
		packages = packageService.getAllPackage();
		
		System.out.println("response sent!!!");
		
		return ResponseEntity.ok(packages);
		
	}
	
	

}
