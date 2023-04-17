package com.pratian.AppointmentService.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feedback_generator")
	@SequenceGenerator(name="feedback_generator",sequenceName = "feedback_seq", allocationSize=50)

	private long feedbackId;
	private String details;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="appointmentId")
	private Appointment appointment;
}
