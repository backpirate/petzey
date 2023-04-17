package com.pratian.AppointmentService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratian.AppointmentService.Entities.Test;
import com.pratian.AppointmentService.Exceptions.TestAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.TestNotFoundException;
import com.pratian.AppointmentService.Service.TestService;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
@RequestMapping("/test")
public class TestController {

	
	@Autowired 
	 private TestService service;
	 
	 @GetMapping("/gettest")
	 public ResponseEntity<?> get(){ 
		 ResponseEntity<?>response = null; 
	 try {
		 response = new ResponseEntity<>(service.getAllTests(), HttpStatus.OK); 
	 }
	 catch(TestNotFoundException t) 
	 {
		 response = new ResponseEntity<>(t.getMessage(),HttpStatus.OK);
		 }
	 return response; 
	 }
	 
	 @PostMapping("/posttest") 
	 public ResponseEntity<?> post(@RequestBody Test test1)
	 { 
		 ResponseEntity<?> response = null;
		 try 
		 { 
			 response = new ResponseEntity<>(service.saveTest(test1), HttpStatus.OK); 
			 }
		 catch(TestAlreadyExistException t) 
		 {
			 response = new ResponseEntity<>(t.getMessage(), HttpStatus.OK);
			 } 
		 return response;
		 }

	@GetMapping("/{id}") 
	public ResponseEntity<?>getById(@PathVariable(value="id")long id) throws TestNotFoundException
	{ 
		ResponseEntity<?> response = null;

		response = new ResponseEntity<>(service.getTestById(id),HttpStatus.OK);
		
		return response;
		}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable (value = "id") long id){
		ResponseEntity<?> response = null;
		response = new ResponseEntity<>(service.deleteTest(id), HttpStatus.OK);	
			return response;
			}

}
