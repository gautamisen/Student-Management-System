package com.sms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String Name;
	private String Address;
	private String Section;
	private String Standard;
	private int Marathi;
	private int English;
	private int Science;
	private int Hindi;
	private int Geography;
	private int Total;
	private float Percentage;
	private String Grade;
	private String Result;
	private int status;
	
	
	

}
