package com.pratian.AppointmentService.Entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long commentid;
	private String description;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="appointmentId")//appointmentId_comment
	private Appointment appointment;
}
