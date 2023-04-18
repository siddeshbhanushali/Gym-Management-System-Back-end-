package com.gymmanagement.service;

import com.gymmanagement.entity.Admin;

public interface AdminService {
	
	Admin registerAdmin(Admin admin);
	Admin loginAdmin(String username, String password);

}
