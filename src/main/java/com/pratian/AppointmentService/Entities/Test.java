package com.pratian.AppointmentService.Entities;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Test_generator")
	@SequenceGenerator(name="Test_generator",sequenceName = "Test_seq", allocationSize=50)
	private long testId; 
	
	private Date date; 
	private String testdesc; //testname
	
}
