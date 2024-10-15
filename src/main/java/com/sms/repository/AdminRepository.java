package com.sms.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sms.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	@Query(
			value = "SELECT * FROM Admin u WHERE u.status = 1 ", 
			nativeQuery = true)
	List<Admin> filteredAdminList();
	
	//jpql
	@Query("SELECT u FROM Admin u Where u.status=:n")
	public List<Admin> adminList(@Param("n") int status);

	public Admin findByEmailAndPassword(String email, String password);
}
