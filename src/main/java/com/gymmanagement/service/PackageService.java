package com.gymmanagement.service;

import java.util.List;

public interface PackageService {
	
	com.gymmanagement.entity.Package addPackage(com.gymmanagement.entity.Package packge);
    List<com.gymmanagement.entity.Package> getAllPackage();
    com.gymmanagement.entity.Package getPackageById(int packageId);
	
}
