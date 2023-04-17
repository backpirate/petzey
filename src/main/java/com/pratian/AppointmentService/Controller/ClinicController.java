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
 
import com.pratian.AppointmentService.Entities.Clinic;
import com.pratian.AppointmentService.Exceptions.ClinicAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.ClinicNotFoundException;
import com.pratian.AppointmentService.Service.ClinicService;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
@RequestMapping("/clinic")
public class ClinicController {
 
 @Autowired 
 private ClinicService service;
 
 @GetMapping("/clinics")
 public ResponseEntity<?> get(){ 
	 ResponseEntity<?>response = null; 
 try {
	 response = new ResponseEntity<>(service.getAllClinics(), HttpStatus.OK); 
 }
 catch(ClinicNotFoundException a) 
 {
	 response = new ResponseEntity<>(a.getMessage(),HttpStatus.OK);
	 }
 return response; 
 }
 
 @PostMapping("/postclinics") 
 public ResponseEntity<?> post(@RequestBody Clinic clinic1)
 { 
	 ResponseEntity<?> response = null;
	 try 
	 { 
		 response = new ResponseEntity<>(service.saveClinic(clinic1), HttpStatus.OK); 
		 }
	 catch(ClinicAlreadyExistException a) 
	 {
		 response = new ResponseEntity<>(a.getMessage(), HttpStatus.OK);
		 } 
	 return response;
	 }

@GetMapping("/{id}") 
public ResponseEntity<?>getById(@PathVariable(value="id")long id) throws ClinicNotFoundException
{ 
	ResponseEntity<?> response = null;

	response = new ResponseEntity<>(service.getClinicById(id),HttpStatus.OK);
	
	return response;
	}
}
