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

import com.pratian.AppointmentService.Entities.PetParent;
import com.pratian.AppointmentService.Exceptions.PetAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.PetNotFoundException;
import com.pratian.AppointmentService.Exceptions.PetParentAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.PetParentNotFoundException;
import com.pratian.AppointmentService.Service.PetParentService;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
@RequestMapping("/petparent")
public class PetParentController {

	@Autowired 
	 private PetParentService service;
	 
	 @GetMapping("/getPetParent")
	 public ResponseEntity<?> get() throws PetNotFoundException{ 
		 ResponseEntity<?>response = null; 
	 try {
		 response = new ResponseEntity<>(service.getAllPetParents(), HttpStatus.OK); 
	 }
	 catch(PetParentNotFoundException pp) 
	 {
		 response = new ResponseEntity<>(pp.getMessage(),HttpStatus.OK);
		 }
	 return response; 
	 }
	 
	 @PostMapping("/postPetParent") 
	 public ResponseEntity<?> post(@RequestBody PetParent petParent1) throws PetAlreadyExistException
	 { 
		 ResponseEntity<?> response = null;
		 try
		 { 
			 response = new ResponseEntity<>(service.savePetParent(petParent1), HttpStatus.OK); 
			 }
		 catch(PetParentAlreadyExistException pp)
		 {
			 response = new ResponseEntity<>(pp.getMessage(), HttpStatus.OK);
			 } 
		 return response;
		 }

	@GetMapping("/{id}") 
	public ResponseEntity<?>getById(@PathVariable(value="id")long id) throws PetParentNotFoundException
	{ 
		ResponseEntity<?> response = null;

		response = new ResponseEntity<>(service.getPetParentById(id),HttpStatus.OK);
		
		return response;
		}
}
