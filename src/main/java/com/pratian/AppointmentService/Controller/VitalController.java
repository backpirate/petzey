package com.pratian.AppointmentService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratian.AppointmentService.Entities.Vital;
import com.pratian.AppointmentService.Exceptions.VitalAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.VitalNotFoundException;
import com.pratian.AppointmentService.Service.VitalService;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
@RequestMapping("/vital")
public class VitalController {

	@Autowired 
	 private VitalService service;
	 
	 @GetMapping("/getvital")
	 public ResponseEntity<?> get(){ 
		 ResponseEntity<?>response = null; 
	 try {
		 response = new ResponseEntity<>(service.getAllVitals(), HttpStatus.OK); 
	 }
	 catch(VitalNotFoundException v) 
	 {
		 response = new ResponseEntity<>(v.getMessage(),HttpStatus.OK);
		 }
	 return response; 
	 }
	 
	 @PostMapping("/postvitals") 
	 public ResponseEntity<?> post(@RequestBody Vital vital1)
	 { 
		 ResponseEntity<?> response = null;
		 try
		 { 
			 response = new ResponseEntity<>(service.saveVital(vital1), HttpStatus.OK); 
			 }
		 catch(VitalAlreadyExistException v)
		 {
			 response = new ResponseEntity<>(v.getMessage(), HttpStatus.OK);
			 } 
		 return response;
		 }

	@GetMapping("/{id}") 
	public ResponseEntity<?>getById(@PathVariable(value="id")long id) throws VitalNotFoundException
	{ 
		ResponseEntity<?> response = null;

		response = new ResponseEntity<>(service.getVitalById(id),HttpStatus.OK);
		
		return response;
		}

	@PutMapping("/edit")
	public ResponseEntity<?> put(@RequestBody Vital vitaledit){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.editVital(vitaledit), HttpStatus.OK);
		} catch (VitalNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
}
