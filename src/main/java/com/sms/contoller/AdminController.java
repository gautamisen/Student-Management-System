package com.sms.contoller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sms.context.Context;
import com.sms.model.Admin;
import com.sms.service.StudentService;
import com.sms.service.impl.AdminServiceImpl;

@Controller

public class AdminController extends Context{
	
	@Autowired
	AdminServiceImpl adminService;
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/")
	public String landingPage(Model m)
	{
		
		return "home";  
	}
	
	@GetMapping("/signin")
	public String signin(Model m) {
		Admin admin = new Admin();
		m.addAttribute("admin", admin);		
		return "signin";
	}
	
	@PostMapping("/signin")
	public String signin(@ModelAttribute Admin admin, Model m) {
		String email = admin.getEmail();
		String password = admin.getPassword();
		
		if(email.isEmpty()) {
			m.addAttribute("error", "Email is required.");
			return "signin";
		}
		if(password.isEmpty()) {
			m.addAttribute("error", "Password is required.");
			return "signin";
		}
		
		Admin adminFound = adminService.findAdminByEmailAndPasword(email, password);
		
		if(adminFound == null) {
			m.addAttribute("error", "Invalid Email or password");
			return "signin";
		}
		
		ADMIN_NAME = adminFound;
		
		return "redirect:/dashboard";
		
	}
	
	@GetMapping("/logout")
	public String logout() {
		ADMIN_NAME =null;
		return "redirect:/signin";
	}
	
	// Dashboard
	@GetMapping("/dashboard")
	public String dashboard(Model m) {
		m.addAttribute("logInAdmin", ADMIN_NAME);
		m.addAttribute("TotalStudent", studentService.totalStudent().toArray().length);
		System.out.println(studentService.totalStudent().toArray().length);
		m.addAttribute("currentStudent",studentService.studentList(1).toArray().length);
		m.addAttribute("passoutStudent", studentService.studentList(0).toArray().length);
		return "dashboard";
	}
	
	@GetMapping("/adminList")
	public String adminList(Model m) {
		m.addAttribute("AdminActiveSubMenu", "active submenu");
		m.addAttribute("AdminShow", "show");
		m.addAttribute("AdminListActive", "active");
		m.addAttribute("adminList", adminService.AdminList());
		System.out.println(adminService.AdminList());
		
		return "AdminList";
	}
	
	@GetMapping("/addAdmin")
	public String addAdmin(Model m) {
		m.addAttribute("AdminActiveSubMenu", "active submenu");
		m.addAttribute("AdminShow", "show");
		m.addAttribute("AddAdminActive", "active");
		m.addAttribute("admin", new Admin());
		return "AddAdmin";
	}
	
	@PostMapping("/addAdmin")
	public String addAdmin(@ModelAttribute Admin admin, Model m) {
		try {
			String name = admin.getName();
			String email = admin.getEmail();
			 int age = admin.getAge();
			 String phoneno = admin.getPhoneno();
			 String city = admin.getCity();
			 String state = admin.getState();
			 String password = admin.getPassword();
			 
			 if(name.isEmpty()) {
				 m.addAttribute("error", "Name is required");
				 return "AddAdmin";
			 }
			 if(email.isEmpty()) {
				 m.addAttribute("name", name);
				 m.addAttribute("error", "Email is required");
				 return "AddAdmin";
			 }
			 if(password.isEmpty()) {
				 m.addAttribute("name", name);
				 m.addAttribute("email", email);
				 m.addAttribute("error", "Password is required");
				 return "AddAdmin";
			 }
			 if(phoneno.isEmpty()) {
				 m.addAttribute("name", name);
				 m.addAttribute("email", email);
				 m.addAttribute("password", password);
				 m.addAttribute("error", "PhoneNo is required");
				 return "AddAdmin";
			 }
			 if(age < 0) {
				 m.addAttribute("name", name);
				 m.addAttribute("email", email);
				 m.addAttribute("password", password);
				 m.addAttribute("phoneno", phoneno);
				 m.addAttribute("error", "Invalid Age");
				 return "AddAdmin";
			 }
			 if(state.isEmpty()) {
				 m.addAttribute("name", name);
				 m.addAttribute("email", email);
				 m.addAttribute("password", password);
				 m.addAttribute("phoneno", phoneno);
				 m.addAttribute("age", age);
				 m.addAttribute("error", "State is required");
				 return "AddAdmin";
			 }
			 if(city.isEmpty()) {
				 m.addAttribute("name", name);
				 m.addAttribute("email", email);
				 m.addAttribute("password", password);
				 m.addAttribute("phoneno", phoneno);
				 m.addAttribute("age", age);
				 m.addAttribute("state", state);
				 m.addAttribute("error", "city is required");
				 return "AddAdmin";
			 }
			 
			 Admin addAdmin = adminService.addAdmin(admin);
			 
			 if(addAdmin == null) {
				 m.addAttribute("name", name);
				 m.addAttribute("email", email);
				 m.addAttribute("password", password);
				 m.addAttribute("phoneno", phoneno);
				 m.addAttribute("age", age);
				 m.addAttribute("state", state);
				 m.addAttribute("city", city);
				 m.addAttribute("error", "Something Went Wrong");
				 return "AddAdmin";
			 }
			
			
			return "redirect:/adminList";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			m.addAttribute("error", e);
			return "AddAdmin";
		}
		
	}
	
	@GetMapping("/update-admin/{id}")
	public String updateAdmin(@PathVariable("id") int id, Model m) {
		Admin findAdminById = adminService.findAdminById(id);
		m.addAttribute("admin", findAdminById);
		return "UpdateAdmin";
	}
	@GetMapping("/delete-admin/{id}")
	public String deleteAdmin(@PathVariable("id") int id, Model m)
	{
		Admin deleteAdmin = adminService.deleteAdmin(id);
		
		if(deleteAdmin == null) {
			m.addAttribute("error", "Admin Not found");
			return "redirect:/adminList";
		}
		ADMIN_delete = deleteAdmin;
		
		return "redirect:/adminListsprin";
	}
	
	
	@PostMapping("/updateAdmin/{id}")
	public String updateAdmin(@PathVariable("id") int id, @ModelAttribute Admin admin, Model m) {
		
		try {
			String name = admin.getName();
			String email = admin.getEmail();
			 int age = admin.getAge();
			 String phoneno = admin.getPhoneno();
			 String city = admin.getCity();
			 String state = admin.getState();
			 String password = admin.getPassword();
			 
			 if(name.isEmpty()) {
				 m.addAttribute("error", "Name is required");
				 return "UpdateAdmin";
			 }
			 if(email.isEmpty()) {
				 m.addAttribute("name", name);
				 m.addAttribute("error", "Email is required");
				 return "UpdateAdmin";
			 }
			 if(password.isEmpty()) {
				 m.addAttribute("name", name);
				 m.addAttribute("email", email);
				 m.addAttribute("error", "Password is required");
				 return "UpdateAdmin";
			 }
			 if(phoneno.isEmpty()) {
				 m.addAttribute("name", name);
				 m.addAttribute("email", email);
				 m.addAttribute("password", password);
				 m.addAttribute("error", "PhoneNo is required");
				 return "UpdateAdmin";
			 }
			 if(age < 0) {
				 m.addAttribute("name", name);
				 m.addAttribute("email", email);
				 m.addAttribute("password", password);
				 m.addAttribute("phoneno", phoneno);
				 m.addAttribute("error", "Invalid Age");
				 return "UpdateAdmin";
			 }
			 if(state.isEmpty()) {
				 m.addAttribute("name", name);
				 m.addAttribute("email", email);
				 m.addAttribute("password", password);
				 m.addAttribute("phoneno", phoneno);
				 m.addAttribute("age", age);
				 m.addAttribute("error", "State is required");
				 return "UpdateAdmin";
			 }
			 if(city.isEmpty()) {
				 m.addAttribute("name", name);
				 m.addAttribute("email", email);
				 m.addAttribute("password", password);
				 m.addAttribute("phoneno", phoneno);
				 m.addAttribute("age", age);
				 m.addAttribute("state", state);
				 m.addAttribute("error", "city is required");
				 return "UpdateAdmin";
			 }
			 
			 Admin addAdmin = adminService.updateAdmin(id, admin);
			 
			 if(addAdmin == null) {
				 m.addAttribute("name", name);
				 m.addAttribute("email", email);
				 m.addAttribute("password", password);
				 m.addAttribute("phoneno", phoneno);
				 m.addAttribute("age", age);
				 m.addAttribute("state", state);
				 m.addAttribute("city", city);
				 m.addAttribute("error", "Something Went Wrong");
				 return "UpdateAdmin";
			 }
			
			
			return "redirect:/adminList";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			m.addAttribute("error", e);
			return "UpdateAdmin";
		}
		
	}
	
}
