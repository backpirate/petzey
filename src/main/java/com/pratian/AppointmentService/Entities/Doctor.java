package com.pratian.AppointmentService.Entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Doctor{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appoid_generator")
	@SequenceGenerator(name="appoid_generator",sequenceName = "appointment_seq", allocationSize=50 )
	private long doctorId;
	
	private long npiNo;
	private String speciality;
	private String doctorName;
	private long doctorMobileNo;
	private String doctorEmail;
	private String addClinic;
	private String recommendedDoctor;
	private String recommendedClinic;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Doctor_Appointment")//Appointment_Test
	private List<Appointment> appointments = new ArrayList<>();
}
