package com.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sms.model.Student;
@Repository
public interface StudentRepository  extends JpaRepository<Student, Integer>{
	
	@Query("SELECT u FROM Student u WHERE u.status=:n")
	public List<Student> StudentListAsPerStatusCode(@Param("n") int status);

}
