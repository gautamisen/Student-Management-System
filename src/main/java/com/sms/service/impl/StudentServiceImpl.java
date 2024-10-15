package com.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.model.Student;
import com.sms.repository.StudentRepository;
import com.sms.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepo;

	@Override
	public List<Student> studentList(int statusCode) {
		// TODO Auto-generated method stub
		return studentRepo.StudentListAsPerStatusCode(statusCode);
	}

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		student.setStatus(1);
		return studentRepo.save(student);
	}

	@Override
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		List<Student> studentList = studentList(1);
		Student student=null;
		for(Student s: studentList)
		{
			if(s.getId() == id) {
				student=s;
			}
		}
		
		return student;
	}

	@Override
	public Student updateStudent(int id, Student student) {
		// TODO Auto-generated method stub
		Student oldStudent = findStudentById(id);
		oldStudent.setName(student.getName());
		oldStudent.setAddress(student.getAddress());
		oldStudent.setEnglish(student.getEnglish());
		oldStudent.setGeography(student.getGeography());
		oldStudent.setGrade(student.getGrade());
		oldStudent.setHindi(student.getHindi());
		oldStudent.setMarathi(student.getMarathi());
		oldStudent.setPercentage(student.getPercentage());
		oldStudent.setResult(student.getResult());
		oldStudent.setScience(student.getScience());
		oldStudent.setSection(student.getSection());
		oldStudent.setStandard(student.getStandard());
		oldStudent.setTotal(student.getTotal());
		Student save = studentRepo.save(oldStudent);
		
			return save;
	}

	@Override
	public Student deleteStudent(int id) {
		// TODO Auto-generated method stub
		Student findStudentById = findStudentById(id);
		findStudentById.setStatus(0);
		Student save = studentRepo.save(findStudentById);
		
		return save;
	}

	@Override
	public List<Student> totalStudent() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

}
