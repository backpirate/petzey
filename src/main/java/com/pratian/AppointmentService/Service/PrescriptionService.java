package com.pratian.AppointmentService.Service;

import java.util.List;

import com.pratian.AppointmentService.Entities.Prescription;
import com.pratian.AppointmentService.Exceptions.PrescriptionAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.PrescriptionNotFoundException;


public interface PrescriptionService {

	
public List<Prescription> getAllPrescriptions() throws PrescriptionNotFoundException ;//GET
	
	public Prescription savePrescription(Prescription prescription) throws PrescriptionAlreadyExistException ;//POST
	
	public Prescription editPrescription(Prescription prescription) throws PrescriptionNotFoundException;//PUT
	
	public String deletePrescription(long id);//DELETE
	
	public Prescription getPrescriptionById(long id) throws PrescriptionNotFoundException;//GET
	
	public Prescription getPrescriptionByName(String name);//GET

}
