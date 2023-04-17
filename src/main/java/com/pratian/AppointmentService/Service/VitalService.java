package com.pratian.AppointmentService.Service;

import java.util.List;

import com.pratian.AppointmentService.Entities.Vital;
import com.pratian.AppointmentService.Exceptions.VitalAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.VitalNotFoundException;



public interface VitalService {

	public List<Vital> getAllVitals() throws VitalNotFoundException;//GET
	
	public Vital saveVital(Vital vital) throws VitalAlreadyExistException;//POST
	
	public Vital editVital(Vital vital) throws VitalNotFoundException;//PUT
	
	public String deleteVital(long id);//DELETE
	
	public Vital getVitalById(long id);//GET
	
	public Vital getVitalByName(String name);//GET

	
}
