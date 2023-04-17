package com.pratian.AppointmentService.Service;

import java.util.List;

import com.pratian.AppointmentService.Entities.Clinic;
import com.pratian.AppointmentService.Exceptions.ClinicAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.ClinicNotFoundException;

public interface ClinicService {

	public List<Clinic> getAllClinics() throws ClinicNotFoundException;//GET
	
	public Clinic saveClinic(Clinic clinic) throws ClinicAlreadyExistException;//POST
	
//	public Clinic editClinic(Clinic clinic) throws ClinicNotFoundException;//PUT
//	
//	public String deleteClinic(long id) throws ClinicNotFoundException;//DELETE
	
	public Clinic getClinicById(long id) throws ClinicNotFoundException;//GET
	
//	public Clinic getClinicByName(String name) throws ClinicNotFoundException;//GET

}
