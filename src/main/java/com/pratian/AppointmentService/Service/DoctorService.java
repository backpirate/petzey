package com.pratian.AppointmentService.Service;

import java.util.List;
import java.util.Optional;

import com.pratian.AppointmentService.Entities.Appointment;
import com.pratian.AppointmentService.Entities.Doctor;
import com.pratian.AppointmentService.Exceptions.AppointmentNotFoundException;
import com.pratian.AppointmentService.Exceptions.DoctorAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.DoctorNotFoundException;

public interface DoctorService {

	
	public List<Doctor> getAllDoctors() throws DoctorNotFoundException ;//GET
	
	public Doctor saveDoctor(Doctor doctor) throws DoctorAlreadyExistException ;//POST
	
	
	public Doctor getDoctorById(long id) throws DoctorNotFoundException;//GET
	


	public  Doctor editDoctorDetails(Doctor doctoredit) throws DoctorNotFoundException ; //PUT

	
    public Doctor removeRecommendedDoctor(Doctor doctor) throws DoctorNotFoundException;
	
	public Doctor removeRecommendedClinic(Doctor doctor) throws DoctorNotFoundException;
}
