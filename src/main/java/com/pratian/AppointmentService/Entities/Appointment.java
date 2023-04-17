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

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
//import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "appoid_generator")
	@SequenceGenerator(name="appoid_generator", sequenceName = "Random_seq",allocationSize=50)
	public long appointmentId;
	
    private Date date;
	private String status;
	private String details;
	private String reasonForVisit; 
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "doctorId")
	private Doctor doctor;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "appointmentId")//Appointment_Prescription
	private List<Prescription> prescriptions = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "appointmentId")//Appointment_Test
	private List<Test> tests = new ArrayList<>();

	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name ="appointmentId")
	private Vital vital;
}  