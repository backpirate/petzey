package com.pratian.AppointmentService.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratian.AppointmentService.Entities.Clinic;
import com.pratian.AppointmentService.Exceptions.ClinicAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.ClinicNotFoundException;
import com.pratian.AppointmentService.Repository.ClinicRespository;
import com.pratian.AppointmentService.Service.ClinicService;

@Service
public class ClinicServiceImpl implements ClinicService {
	
	@Autowired
	private ClinicRespository clinicRepo;

	@Override
	public List<Clinic> getAllClinics() throws ClinicNotFoundException {
		List<Clinic> clinics = clinicRepo.getClinics();
		if(clinics.isEmpty()) {
			throw new ClinicNotFoundException("Clinic list is empty.");
		}
		
		return clinics;
	}

	@Override
	public Clinic saveClinic(Clinic clinic0) throws ClinicAlreadyExistException{
		Clinic clinic2 = null;
		if(clinicRepo.existsById(clinic0.getClinicId())) {
			throw new ClinicAlreadyExistException("Clinic already exist.");
		}
		else {
			clinic2 = clinicRepo.save(clinic0);
		}
		return clinic2;
	}



	@Override
	public Clinic getClinicById(long id) throws ClinicNotFoundException {
		Clinic clinic = clinicRepo.findById(id).get();//orElseThrow(()->new ClinicNotFoundException("Clinic does not Exist with this id"));//inbuilt
		return clinic;
	}

	
	
}
