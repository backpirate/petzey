package com.pratian.AppointmentService.Entities;

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

public class Clinic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clinicid_generator")
	@SequenceGenerator(name="clinicid_generator", sequenceName = "clinic_seq", allocationSize=50)
	private long clinicId;
	//private String address;
	private String clinicaddr; 
	private long npid; //not present in petcode
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "clinicId")
	private List<Doctor> Doctors = new ArrayList<>();

}
	 
