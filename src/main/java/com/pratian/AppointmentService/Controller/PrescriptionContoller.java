package com.pratian.AppointmentService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratian.AppointmentService.Entities.Prescription;
import com.pratian.AppointmentService.Exceptions.PrescriptionAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.PrescriptionNotFoundException;
import com.pratian.AppointmentService.Service.PrescriptionService;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
@RequestMapping("/prescription")
public class PrescriptionContoller {

	@Autowired 
	 private PrescriptionService service;
	 
	 @GetMapping("/getPrescription")

	 public ResponseEntity<?> get() throws PrescriptionNotFoundException{ 
		 ResponseEntity<?>response = null; 
	 try {
		 response = new ResponseEntity<>(service.getAllPrescriptions(), HttpStatus.OK); 
	 }
	 catch(PrescriptionNotFoundException pre) 
	 {
		 response = new ResponseEntity<>(pre.getMessage(),HttpStatus.OK);
		 }
	 return response; 
	 }
	 
	 @PostMapping("/postPrescription") 
	 public ResponseEntity<?> post(@RequestBody Prescription prescription1)
	 { 
		 ResponseEntity<?> response = null;
		 try 
		 { 
			 response = new ResponseEntity<>(service.savePrescription(prescription1), HttpStatus.OK); 
			 }
		 catch(PrescriptionAlreadyExistException pre) 
		 {
			 response = new ResponseEntity<>(pre.getMessage(), HttpStatus.OK);
			 } 
		 return response;
		 }

	@GetMapping("/{id}") 
	public ResponseEntity<?>getById(@PathVariable(value="id")long id) throws PrescriptionNotFoundException
	{ 
		ResponseEntity<?> response = null;

		response = new ResponseEntity<>(service.getPrescriptionById(id),HttpStatus.OK);
		
		return response;
		}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable (value = "id") long id){
		ResponseEntity<?> response = null;
		response = new ResponseEntity<>(service.deletePrescription(id), HttpStatus.OK);	
			return response;
			}

	@PutMapping("/edit")
	public ResponseEntity<?> put(@RequestBody Prescription Perscriptionedit){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.editPrescription(Perscriptionedit), HttpStatus.OK);
		} catch (PrescriptionNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

}
