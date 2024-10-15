package com.sms.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sms.model.Student;
import com.sms.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;

	@GetMapping("/addstudent")
	public String addStudent(Model m) {
		m.addAttribute("StudentActiveSubMenu", "active submenu");
		m.addAttribute("StudentShow", "show");
		m.addAttribute("AddStudentActive", "active");
		m.addAttribute("student", new Student());

		return "addStudent";
	}

	@PostMapping("/addstudent")
	public String addStudent(@ModelAttribute Student student, Model m) {
		try {

			String name = student.getName();
			String address = student.getAddress();
			String section = student.getSection();
			String standard = student.getStandard();
			int marathi = student.getMarathi();
			int english = student.getEnglish();
			int science = student.getScience();
			int hindi = student.getHindi();
			int geography = student.getGeography();
			int total = student.getTotal();
			float percentage = student.getPercentage();
			String grade = student.getGrade();
			String result = student.getResult();

			if (name.isEmpty()) {
				m.addAttribute("error", "Name is required");
				return "addStudent";

			}
			if (address.isEmpty()) {
				m.addAttribute("name", name);
				m.addAttribute("error", "Address is required");

				return "addStudent";
			}
			if (section.isEmpty()) {
				m.addAttribute("name", name);
				m.addAttribute("address", address);
				m.addAttribute("error", "Section is required");
				return "addStudent";
			}
			if (standard.isEmpty()) {
				m.addAttribute("name", name);
				m.addAttribute("address", address);
				m.addAttribute("section", section);
				m.addAttribute("error", "Standard is required");
				return "addStudent";
			}
			if (marathi <= 0 || marathi > 100) {
				m.addAttribute("name", name);
				m.addAttribute("address", address);
				m.addAttribute("section", section);
				m.addAttribute("standard", standard);
				m.addAttribute("error", "Inavlid marks for Marathi Subject");
				return "addStudent";

			}
			if (english <= 0 || english > 100) {
				m.addAttribute("name", name);
				m.addAttribute("address", address);
				m.addAttribute("section", section);
				m.addAttribute("standard", standard);
				m.addAttribute("marathi", marathi);
				m.addAttribute("error", "Inavlid marks for English Subject");
				return "addStudent";

			}
			if (science <= 0 || science > 100) {
				m.addAttribute("name", name);
				m.addAttribute("address", address);
				m.addAttribute("section", section);
				m.addAttribute("standard", standard);
				m.addAttribute("marathi", marathi);
				m.addAttribute("english", english);
				m.addAttribute("error", "Inavlid marks for Science Subject");
				return "addStudent";

			}
			if (hindi <= 0 || hindi > 100) {
				m.addAttribute("name", name);
				m.addAttribute("address", address);
				m.addAttribute("section", section);
				m.addAttribute("standard", standard);
				m.addAttribute("marathi", marathi);
				m.addAttribute("english", english);
				m.addAttribute("science", science);
				m.addAttribute("error", "Inavlid marks for Hindi Subject");
				return "addStudent";

			}
			if (geography <= 0 || geography > 100) {
				m.addAttribute("name", name);
				m.addAttribute("address", address);
				m.addAttribute("section", section);
				m.addAttribute("standard", standard);
				m.addAttribute("marathi", marathi);
				m.addAttribute("english", english);
				m.addAttribute("science", science);
				m.addAttribute("hindi", hindi);
				m.addAttribute("error", "Inavlid marks for Geography Subject");
				return "addStudent";

			}
			if (total <= 0 || total > 500) {
				m.addAttribute("name", name);
				m.addAttribute("address", address);
				m.addAttribute("section", section);
				m.addAttribute("standard", standard);
				m.addAttribute("marathi", marathi);
				m.addAttribute("english", english);
				m.addAttribute("science", science);
				m.addAttribute("hindi", hindi);
				m.addAttribute("geography", geography);
				m.addAttribute("error", "Invalid Total");
				return "addStudent";

			}
			if (percentage <= 0 || percentage > 100) {
				m.addAttribute("name", name);
				m.addAttribute("address", address);
				m.addAttribute("section", section);
				m.addAttribute("standard", standard);
				m.addAttribute("marathi", marathi);
				m.addAttribute("english", english);
				m.addAttribute("science", science);
				m.addAttribute("hindi", hindi);
				m.addAttribute("geography", geography);
				m.addAttribute("total", total);
				m.addAttribute("error", "Invalid Percentage");
				return "addStudent";

			}
			if (grade.isEmpty()) {
				m.addAttribute("name", name);
				m.addAttribute("address", address);
				m.addAttribute("section", section);
				m.addAttribute("standard", standard);
				m.addAttribute("marathi", marathi);
				m.addAttribute("english", english);
				m.addAttribute("science", science);
				m.addAttribute("hindi", hindi);
				m.addAttribute("geography", geography);
				m.addAttribute("total", total);
				m.addAttribute("percentage", percentage);
				m.addAttribute("error", "Grade is Required");
				return "addStudent";

			}
			if (result.isEmpty()) {
				m.addAttribute("name", name);
				m.addAttribute("address", address);
				m.addAttribute("section", section);
				m.addAttribute("standard", standard);
				m.addAttribute("marathi", marathi);
				m.addAttribute("english", english);
				m.addAttribute("science", science);
				m.addAttribute("hindi", hindi);
				m.addAttribute("geography", geography);
				m.addAttribute("total", total);
				m.addAttribute("percentage", percentage);
				m.addAttribute("grade", grade);
				m.addAttribute("error", "Invalid Result");
				return "addStudent";

			}

			Student addStudent = studentService.addStudent(student);
			if (addStudent == null) {
				m.addAttribute("name", name);
				m.addAttribute("address", address);
				m.addAttribute("section", section);
				m.addAttribute("standard", standard);
				m.addAttribute("marathi", marathi);
				m.addAttribute("english", english);
				m.addAttribute("science", science);
				m.addAttribute("hindi", hindi);
				m.addAttribute("geography", geography);
				m.addAttribute("total", total);
				m.addAttribute("percentage", percentage);
				m.addAttribute("grade", grade);
				m.addAttribute("result", result);
				m.addAttribute("error", "Something Went Terriably Wrong..");
				return "addStudent";
			}

			m.addAttribute("success", "Student Added Succesfully...");
			return "addStudent";

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "addStudent";

		}

	}

	@GetMapping("/studentList")
	public String StudentList(Model m) {
		m.addAttribute("StudentActiveSubMenu", "active submenu");
		m.addAttribute("StudentShow", "show");
		m.addAttribute("StudentListActive", "active");

		return "StudentList";
	}

	@GetMapping("/updateStudent/{id}")
	public String updateStudent(@PathVariable("id") int id, Model m) {
		Student findStudentById = studentService.findStudentById(id);
		m.addAttribute("student", findStudentById);
		return "UpdateStudent";
	}

	@PostMapping("/update-student/{id}")
	public String updateStudent(@PathVariable("id") int id, @ModelAttribute Student student, Model m)
	{
		try {

			String name = student.getName();
			String address = student.getAddress();
			String section = student.getSection();
			String standard = student.getStandard();
			int marathi = student.getMarathi();
			int english = student.getEnglish();
			int science = student.getScience();
			int hindi = student.getHindi();
			int geography = student.getGeography();
			int total = student.getTotal();
			float percentage = student.getPercentage();
			String grade = student.getGrade();
			String result = student.getResult();

			if (name.isEmpty()) {
				m.addAttribute("error", "Name is required");
				return "UpdateStudent";

			}
			if (address.isEmpty()) {
				m.addAttribute("name", name);
				m.addAttribute("error", "Address is required");

				return "UpdateStudent";
			}
			if (section.isEmpty()) {
				m.addAttribute("name", name);
				m.addAttribute("address", address);
				m.addAttribute("error", "Section is required");
				return "UpdateStudent";
			}
			if (standard.isEmpty()) {
				m.addAttribute("name", name);
				m.addAttribute("address", address);
				m.addAttribute("section", section);
				m.addAttribute("error", "Standard is required");
				return "UpdateStudent";
			}
			if (marathi <= 0 || marathi > 100) {
				m.addAttribute("name", name);
				m.addAttribute("address", address);
				m.addAttribute("section", section);
				m.addAttribute("standard", standard);
				m.addAttribute("error", "Inavlid marks for Marathi Subject");
				return "UpdateStudent";

			}
			if (english <= 0 || english > 100) {
				m.addAttribute("name", name);
				m.addAttribute("address", address);
				m.addAttribute("section", section);
				m.addAttribute("standard", standard);
				m.addAttribute("marathi", marathi);
				m.addAttribute("error", "Inavlid marks for English Subject");
				return "UpdateStudent";

			}
			if (science <= 0 || science > 100) {
				m.addAttribute("name", name);
				m.addAttribute("address", address);
				m.addAttribute("section", section);
				m.addAttribute("standard", standard);
				m.addAttribute("marathi", marathi);
				m.addAttribute("english", english);
				m.addAttribute("error", "Inavlid marks for Science Subject");
				return "UpdateStudent";

			}
			if (hindi <= 0 || hindi > 100) {
				m.addAttribute("name", name);
				m.addAttribute("address", address);
				m.addAttribute("section", section);
				m.addAttribute("standard", standard);
				m.addAttribute("marathi", marathi);
				m.addAttribute("english", english);
				m.addAttribute("science", science);
				m.addAttribute("error", "Inavlid marks for Hindi Subject");
				return "UpdateStudent";

			}
			if (geography <= 0 || geography > 100) {
				m.addAttribute("name", name);
				m.addAttribute("address", address);
				m.addAttribute("section", section);
				m.addAttribute("standard", standard);
				m.addAttribute("marathi", marathi);
				m.addAttribute("english", english);
				m.addAttribute("science", science);
				m.addAttribute("hindi", hindi);
				m.addAttribute("error", "Inavlid marks for Geography Subject");
				return "UpdateStudent";

			}
			if (total <= 0 || total > 500) {
				m.addAttribute("name", name);
				m.addAttribute("address", address);
				m.addAttribute("section", section);
				m.addAttribute("standard", standard);
				m.addAttribute("marathi", marathi);
				m.addAttribute("english", english);
				m.addAttribute("science", science);
				m.addAttribute("hindi", hindi);
				m.addAttribute("geography", geography);
				m.addAttribute("error", "Invalid Total");
				return "UpdateStudent";

			}
			if (percentage <= 0 || percentage > 100) {
				m.addAttribute("name", name);
				m.addAttribute("address", address);
				m.addAttribute("section", section);
				m.addAttribute("standard", standard);
				m.addAttribute("marathi", marathi);
				m.addAttribute("english", english);
				m.addAttribute("science", science);
				m.addAttribute("hindi", hindi);
				m.addAttribute("geography", geography);
				m.addAttribute("total", total);
				m.addAttribute("error", "Invalid Percentage");
				return "UpdateStudent";

			}
			if (grade.isEmpty()) {
				m.addAttribute("name", name);
				m.addAttribute("address", address);
				m.addAttribute("section", section);
				m.addAttribute("standard", standard);
				m.addAttribute("marathi", marathi);
				m.addAttribute("english", english);
				m.addAttribute("science", science);
				m.addAttribute("hindi", hindi);
				m.addAttribute("geography", geography);
				m.addAttribute("total", total);
				m.addAttribute("percentage", percentage);
				m.addAttribute("error", "Grade is Required");
				return "UpdateStudent";

			}
			if (result.isEmpty()) {
				m.addAttribute("name", name);
				m.addAttribute("address", address);
				m.addAttribute("section", section);
				m.addAttribute("standard", standard);
				m.addAttribute("marathi", marathi);
				m.addAttribute("english", english);
				m.addAttribute("science", science);
				m.addAttribute("hindi", hindi);
				m.addAttribute("geography", geography);
				m.addAttribute("total", total);
				m.addAttribute("percentage", percentage);
				m.addAttribute("grade", grade);
				m.addAttribute("error", "Invalid Result");
				return "UpdateStudent";

			}

			Student addStudent = studentService.addStudent(student);
			if (addStudent == null) {
				m.addAttribute("name", name);
				m.addAttribute("address", address);
				m.addAttribute("section", section);
				m.addAttribute("standard", standard);
				m.addAttribute("marathi", marathi);
				m.addAttribute("english", english);
				m.addAttribute("science", science);
				m.addAttribute("hindi", hindi);
				m.addAttribute("geography", geography);
				m.addAttribute("total", total);
				m.addAttribute("percentage", percentage);
				m.addAttribute("grade", grade);
				m.addAttribute("result", result);
				m.addAttribute("error", "Something Went Terriably Wrong..");
				return "UpdateStudent";
			}

			m.addAttribute("success", "Student Updated Succesfully...");
			return "UpdateStudent";

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "UpdateStudent";

		}
		
		
	}
	@GetMapping("/deletestudent/{id}")
	public String deletestudent(@PathVariable ("id") int id, Model m)
	{
		Student deleteStudent = studentService.deleteStudent(id);
		
		if(deleteStudent==null)
		{
			m.addAttribute("error", "Student not found");
			return "redirect:/studentList";
			
		}
		return "redirect:/studentList";
		
		
	}
}
