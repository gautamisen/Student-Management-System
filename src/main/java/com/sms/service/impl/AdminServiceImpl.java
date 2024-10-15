package com.sms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.model.Admin;
import com.sms.repository.AdminRepository;
import com.sms.service.AdminService;
@Service
public class AdminServiceImpl  implements AdminService{
	@Autowired
	AdminRepository adminrepo;

	@Override
	public List<Admin> AdminList() {
		// TODO Auto-generated method stub
		return adminrepo.adminList(1);
	}

	@Override
	public Admin addAdmin(Admin ad) {
		// TODO Auto-generated method stub
		ad.setCreated(new Date());
		ad.setModified(new Date());
		ad.setStatus(1);
		return adminrepo.save(ad);
	}

	@Override
	public Admin updateAdmin(int id, Admin ad) {
		// TODO Auto-generated method stub
		
		Admin oldAdmin = findAdminById(id);
		oldAdmin.setName(ad.getName());
		oldAdmin.setPassword(ad.getPassword());
		oldAdmin.setEmail(ad.getEmail());
		oldAdmin.setCity(ad.getCity());
		oldAdmin.setAge(ad.getAge());
		oldAdmin.setPhoneno(ad.getPhoneno());
		oldAdmin.setRole(ad.getRole());
		oldAdmin.setState(ad.getState());
		oldAdmin.setModified(new Date());
		
		
		Admin save = adminrepo.save(oldAdmin);
		
		
		return save;
	}

	@Override
	public Admin deleteAdmin(int id) {
		// TODO Auto-generated method stub
		Admin findAdminById = findAdminById(id);
		findAdminById.setStatus(0);
		
		Admin save = adminrepo.save(findAdminById);
		
		return save;
	}

	@Override
	public Admin findAdminById(int id) {
		// TODO Auto-generated method stub
		
		List<Admin> adminList = AdminList();
		Admin ad=null;
		for(Admin a : adminList)
		{
			if(a.getId()==id)
				ad=a;
		}
		
		return ad;
	}

	@Override
	public Admin findAdminByEmailAndPasword(String email, String password) {
		// TODO Auto-generated method stub
		
		Admin findByEmailAndPassword = adminrepo.findByEmailAndPassword(email, password);
		return findByEmailAndPassword;
	}

}
