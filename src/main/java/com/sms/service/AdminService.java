package com.sms.service;

import java.util.List;

import com.sms.model.Admin;

public interface AdminService {
	
	// 1: create method for List of Admin
	// 2: create method for Add Admin data
	// 3: create method for update Admin data
	// 4: create method for delete Admin data
	// 5: create method for findAdminById 
	// 6: create method for findAdminByEmailAndPassword


	public List<Admin> AdminList();
	public Admin addAdmin(Admin ad);
	
	public Admin updateAdmin (int id, Admin ad);
	public Admin deleteAdmin(int id);
	
	public Admin findAdminById(int id);
	
	public Admin findAdminByEmailAndPasword(String email,String password);
	


}
