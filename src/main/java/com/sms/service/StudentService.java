package com.sms.service;

import java.util.List;

import com.sms.model.Student;

public interface StudentService {

	public List<Student> studentList(int studentCode);
	
	public List<Student> totalStudent();
	
	public Student addStudent(Student student);
	
	public Student findStudentById(int id);
	
	public Student updateStudent(int id, Student student);
	
	public Student deleteStudent(int id);
}
