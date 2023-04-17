package com.pratian.AppointmentService.Entities;



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

public class Prescription {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Prescription_generator")
	@SequenceGenerator(name="Prescription_generator",sequenceName = "Prescription_seq", allocationSize=50)
	
	private long preid;
	private String medicineName;  
	private String comments; 
	private int days;
	private String consume;
	private String dosage;
	
	
}
