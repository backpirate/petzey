package com.pratian.AppointmentService.Entities;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Patient {


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Pet_generator")
	@SequenceGenerator(name="Pet_generator",sequenceName = "Pet_seq", allocationSize=50)
	private long petId;
	
	private String petName;//name pet code
	private int age ;
	private String gender ;
	private String species ;
	private String bloodgroup;
	private Date dateofbirth;
	private String allergies;
	private String reproductivity; 
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "petId")
	private List<Appointment> appointments = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "petId")//Symptom_id
	private List<Symptom> symptoms = new ArrayList<>();
	
}
