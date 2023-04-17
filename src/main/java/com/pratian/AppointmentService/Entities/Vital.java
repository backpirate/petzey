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

public class Vital {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Vital_generator")
	@SequenceGenerator(name="Vital_generator",sequenceName = "Vital_seq", allocationSize=50)
	private long vitalsId;
	
	private long heartBeat; 
	private int temp; 
	private int lungsbpm;
	private int bp;
}
