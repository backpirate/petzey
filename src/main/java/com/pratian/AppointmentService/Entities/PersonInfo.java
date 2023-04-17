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

public class PersonInfo {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PersonInfo_generator")
	@SequenceGenerator(name="PersonInfo_generator",sequenceName = "PersonInfo_seq", allocationSize=50)

	 private long npid;
}
