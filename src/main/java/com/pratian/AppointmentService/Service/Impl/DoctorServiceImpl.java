package com.pratian.AppointmentService.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratian.AppointmentService.Entities.Doctor;
import com.pratian.AppointmentService.Exceptions.DoctorAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.DoctorNotFoundException;
import com.pratian.AppointmentService.Repository.DoctorRepository;
import com.pratian.AppointmentService.Service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private DoctorRepository doctorRepo;

	@Override
	public List<Doctor> getAllDoctors() throws DoctorNotFoundException {
		List<Doctor> doctors = doctorRepo.getDoctors();
		if(doctors.isEmpty()) {
			throw new DoctorNotFoundException("Doctor list is empty.");
		}
		
		return doctors;
	}

	@Override
	public Doctor saveDoctor(Doctor doctor0) throws DoctorAlreadyExistException{
		Doctor doctor2 = null;
		if(doctorRepo.existsById(doctor0.getDoctorId()))
		{
			throw new DoctorAlreadyExistException ("Doctor already exist.");
		}
		else {
			doctor2 = doctorRepo.save(doctor0);
		}
		return doctor2;
	}

	

	@Override
	public Doctor getDoctorById(long id) throws DoctorNotFoundException {
		Doctor doctor = doctorRepo.findById(id).get();
		return doctor;
	}


	
	@Override
	public Doctor removeRecommendedDoctor(Doctor doctor) throws DoctorNotFoundException {
		Doctor d=null;
			if(doctorRepo.existsById(doctor.getDoctorId())) {
				d=doctorRepo.findById(doctor.getDoctorId()).get();
				d.setRecommendedDoctor(doctor.getRecommendedDoctor());
				doctorRepo.save(d);
			}
	       
	        else{
	           throw new DoctorNotFoundException();
	        }

			return d;
	}

	@Override
	public Doctor removeRecommendedClinic(Doctor doctor) throws DoctorNotFoundException {
		Doctor d=null;
		if(doctorRepo.existsById(doctor.getDoctorId())) {
			d=doctorRepo.findById(doctor.getDoctorId()).get();
			d.setRecommendedClinic(doctor.getRecommendedClinic());
			doctorRepo.save(d);
		}
       
        else{
           throw new DoctorNotFoundException();
        }

		return d;
	}

	@Override
	public Doctor editDoctorDetails(Doctor doctoredit) throws DoctorNotFoundException {
		Doctor d=null;
		if(doctorRepo.existsById(doctoredit.getDoctorId())) {
			d=doctorRepo.findById(doctoredit.getDoctorId()).get();
			d.setDoctorName(doctoredit.getDoctorName());
//			d.setStatus(doctoredit.getStatus());
//			d.setDetails(doctoredit.getDetails());
			doctorRepo.save(d);
		}
       
        else{
           throw new DoctorNotFoundException();
        }

		return d;
	}

	
	

}