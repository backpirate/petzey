package com.pratian.AppointmentService.Service.Impl;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.pratian.AppointmentService.Entities.Symptom;
import com.pratian.AppointmentService.Exceptions.SymptomAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.SymptomNotFoundException;
import com.pratian.AppointmentService.Repository.SymptomRepository;
import com.pratian.AppointmentService.Service.SymptomService;
 
 
 @Service 
 public class SymptomServiceImpl implements SymptomService {
 
	 @Autowired
	 private SymptomRepository symptomRepo;
 
	 @Override
	 public List<Symptom> getAllSymptoms() throws SymptomNotFoundException 
	 { 
		 List<Symptom> symptoms =symptomRepo.getSymptoms(); 
		 if(symptoms.isEmpty())
		 { 
			 throw new SymptomNotFoundException("Symptom list is empty.");
		 } 
		 return symptoms;
	 }
 
	 @Override public Symptom saveSymptom(Symptom symptom0) throws SymptomAlreadyExistException 
	 { 
		 Symptom symptom2 = null;
		 if(symptomRepo.existsById(symptom0.getSymptomid()))
		 { 
			 throw new SymptomAlreadyExistException ("Symptom already exist.");
		 } 
		 else 
		 { 
			 symptom2 = symptomRepo.save(symptom0); 
		 } 
		 return symptom2; 
	 }
 
 
	 @Override 
	 public Symptom editSymptom(Symptom editSymptom) throws SymptomNotFoundException { 
		 Symptom s=null;
			if(symptomRepo.existsById(editSymptom.getSymptomid())) {
				s=symptomRepo.findById(editSymptom.getSymptomid()).get();
				s.setDate(editSymptom.getDate());
				s.setSymptomdesc(editSymptom.getSymptomdesc());
				s.setDate(editSymptom.getDate());
				symptomRepo.save(s);
			}
	       
	        else{
	           throw new SymptomNotFoundException();
	        }

			return s;
		 }
 
	 @Override
	 public String deleteSymptom(long id) 
	 {
		 symptomRepo.deleteById(id);
  			return "deleted"; 
 	}

	@Override
	public Symptom getSymptomById(long id) throws SymptomNotFoundException {
		Symptom symptom = symptomRepo.findById(id).get();
		return symptom;
	}

	@Override
	public Symptom getSymptomByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	}