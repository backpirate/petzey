package com.pratian.AppointmentService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratian.AppointmentService.Entities.Patient;
import com.pratian.AppointmentService.Exceptions.PetAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.PetNotFoundException;
import com.pratian.AppointmentService.Service.PetService;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
@RequestMapping("/pet")
public class PetController {

	@Autowired 
	 private PetService service;
	 
	 @GetMapping("/getpet")
	 public ResponseEntity<?> get() throws PetNotFoundException{ 
		 ResponseEntity<?>response = null; 
	try {
		response = new ResponseEntity<>(service.getAllPets(), HttpStatus.OK);
	}
	catch(PetNotFoundException p)
	{
		response = new ResponseEntity<>(p.getMessage(),HttpStatus.OK);
	 }
	return response;
	 }
	 
	 @PostMapping("/postpet") 
	 public ResponseEntity<?> post(@RequestBody Patient pet1) throws PetAlreadyExistException
	 { 
		 ResponseEntity<?> response = null;
		 try {
			 response = new ResponseEntity<>(service.savePet(pet1), HttpStatus.OK); 
		 }
		 catch(PetAlreadyExistException p)
		 {
			 response = new ResponseEntity<>(p.getMessage(), HttpStatus.OK);
		 }
		 return response;
	 }

	@GetMapping("/pet/{id}") 
	public ResponseEntity<?>getById(@PathVariable(value="id")long id) throws PetNotFoundException
	{ 
		ResponseEntity<?> response = null;
		response = new ResponseEntity<>(service.getPetById(id),HttpStatus.OK);
		return response;
		}

	
	 @GetMapping("/getDoctorRecommendation/{petId}")
	 public ResponseEntity<?> getDoctorRecommendation(@PathVariable(value="petId")long petId) throws PetNotFoundException{ 
		 ResponseEntity<?>response = null; 
	try {
		response = new ResponseEntity<>(service.getDoctorRecommendation(petId), HttpStatus.OK);
	}
	catch(PetNotFoundException p)
	{
		response = new ResponseEntity<>(p.getMessage(),HttpStatus.OK);
	 }
	return response;
	 }
	
	
}
