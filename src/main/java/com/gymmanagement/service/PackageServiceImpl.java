package com.gymmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymmanagement.dao.PackageDao;
import com.gymmanagement.entity.Package;

@Service
public class PackageServiceImpl implements PackageService {
	
	@Autowired
	private PackageDao packageDao;

	@Override
	public com.gymmanagement.entity.Package addPackage(com.gymmanagement.entity.Package packge) {
		return packageDao.save(packge);
	}

	@Override
	public List<com.gymmanagement.entity.Package> getAllPackage() {
		return packageDao.findAll();
	}

	@Override
	public Package getPackageById(int packageId) {
		return packageDao.findById(packageId).get();
	}

}