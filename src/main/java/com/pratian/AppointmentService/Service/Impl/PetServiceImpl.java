package com.pratian.AppointmentService.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.pratian.AppointmentService.Dto.PatientAppointmentDoctorDto;
//import com.pratian.AppointmentService.Dto.RecommendedClinicDto;
//import com.pratian.AppointmentService.Dto.PatientAppointmentDoctorDto;
//import com.pratian.AppointmentService.Dto.RecommendedClinicDto;
import com.pratian.AppointmentService.Entities.Patient;
import com.pratian.AppointmentService.Exceptions.PetAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.PetNotFoundException;
import com.pratian.AppointmentService.Repository.PetRepository;

import com.pratian.AppointmentService.Service.PetService;

@Service
public class PetServiceImpl implements PetService {

	@Autowired
	private PetRepository petRepo;

	@Override
	public List<Patient> getAllPets() throws PetNotFoundException {
		List<Patient> pets = petRepo.getPets();
		if(pets.isEmpty()) {
			throw new PetNotFoundException("Pet list is empty.");
		}
		
		return pets;
	}

	@Override
	public Patient savePet(Patient pet) throws PetAlreadyExistException {
		Patient pet2 =null;
		if(petRepo.existsById(pet.getPetId()))
		{
			throw new PetAlreadyExistException ("Pet already exist.");
		}
		else {
			pet2 = petRepo.save(pet);
		}
		return pet2;
	}

	@Override
	public Patient editPet(Patient pet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletePet(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient getPetById(long id) throws PetNotFoundException{
		Patient pet = petRepo.findById(id).get();
		return pet;
	}

	@Override
	public Patient getPetByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<Patient> getDoctorRecommendation(long petId) throws PetNotFoundException {
		List<Patient> pets = petRepo.getDoctorRecommendation(petId);
		if(pets.isEmpty()) {
			throw new PetNotFoundException("Pet list is empty.");
		}
		
		return pets;
		
	}


}
