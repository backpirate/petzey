package com.pratian.AppointmentService.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratian.AppointmentService.Entities.Prescription;
import com.pratian.AppointmentService.Exceptions.PrescriptionAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.PrescriptionNotFoundException;
import com.pratian.AppointmentService.Repository.PrescriptionRepository;
import com.pratian.AppointmentService.Service.PrescriptionService;


@Service
public class PrescriptionServiceImpl implements PrescriptionService {
	@Autowired
	private PrescriptionRepository prescriptionRepo;

	@Override
	public List<Prescription> getAllPrescriptions() throws PrescriptionNotFoundException {
		List<Prescription> prescriptions = prescriptionRepo.getPrescriptions();
		if(prescriptions.isEmpty()) {
			throw new PrescriptionNotFoundException("Prescription list is empty.");
		}
		
		return prescriptions;
	}

	@Override
	public Prescription savePrescription(Prescription prescription0) throws PrescriptionAlreadyExistException{
		Prescription prescription2 = null;
		if(prescriptionRepo.existsById(prescription0.getPreid()))
		{
			throw new PrescriptionAlreadyExistException ("Prescription already exist.");
		}
		else {
			prescription2 = prescriptionRepo.save(prescription0);
		}
		return prescription2;
	}

	@Override
	public Prescription getPrescriptionById(long id) throws PrescriptionNotFoundException {
		Prescription prescription = prescriptionRepo.findById(id).get();//orElseThrow(()->new ClinicNotFoundException("Clinic does not Exist with this id"));//inbuilt
		return prescription;
	}
	@Override
	public Prescription getPrescriptionByName(String name) //throws ClinicNotFoundException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prescription editPrescription(Prescription prescriptionedit) throws PrescriptionNotFoundException{
		Prescription pre=null;
		if(prescriptionRepo.existsById(prescriptionedit.getPreid())) {
			pre=prescriptionRepo.findById(prescriptionedit.getPreid()).get();
			pre.setMedicineName(prescriptionedit.getMedicineName());
			pre.setComments(prescriptionedit.getComments());
			pre.setDays(prescriptionedit.getDays());
			prescriptionRepo.save(pre);
		}
       
        else{
           throw new PrescriptionNotFoundException();
        }

		return pre;
	}


	@Override
	public String deletePrescription(long id) {
		prescriptionRepo.deleteById(id);
		return "deleted" ;
	}

	}

