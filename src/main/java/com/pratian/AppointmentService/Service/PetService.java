package com.pratian.AppointmentService.Service;

import java.util.List;

//import com.pratian.AppointmentService.Dto.PatientAppointmentDoctorDto;
//import com.pratian.AppointmentService.Dto.RecommendedClinicDto;
//import com.pratian.AppointmentService.Dto.PatientAppointmentDoctorDto;
//import com.pratian.AppointmentService.Dto.RecommendedClinicDto;
import com.pratian.AppointmentService.Entities.Patient;
import com.pratian.AppointmentService.Exceptions.PetAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.PetNotFoundException;

public interface PetService {

	public List<Patient> getAllPets() throws PetNotFoundException ;//GET
	
	public Patient savePet(Patient pet) throws PetAlreadyExistException ;//POST
	
	public Patient editPet(Patient pet);//PUT
	
	public String deletePet(long id);//DELETE
	
	public Patient getPetById(long id) throws PetNotFoundException;//GET
	
	public Patient getPetByName(String name);//GET
	
	public List<Patient> getDoctorRecommendation(long petId) throws PetNotFoundException;


}
