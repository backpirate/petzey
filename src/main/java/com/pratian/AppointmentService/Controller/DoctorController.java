package com.pratian.AppointmentService.Controller;

import java.util.Optional;

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


import com.pratian.AppointmentService.Entities.Doctor;
import com.pratian.AppointmentService.Exceptions.DoctorAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.DoctorNotFoundException;
import com.pratian.AppointmentService.Repository.DoctorRepository;
import com.pratian.AppointmentService.Service.DoctorService;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired 
	 private DoctorService service;
	
//	@Autowired 
//	 private DoctorRepository doctorRepo;
	 
	 @GetMapping("/getdoctor")
	 public ResponseEntity<?> get(){ 
		 ResponseEntity<?>response = null; 
	 try {
		 response = new ResponseEntity<>(service.getAllDoctors(), HttpStatus.OK); 
	 }
	 catch(DoctorNotFoundException d) 
	 {
		 response = new ResponseEntity<>(d.getMessage(),HttpStatus.OK);
		 }
	 return response; 
	 }
	 
	 @PostMapping("/postdoctors") 
	 public ResponseEntity<?> post(@RequestBody Doctor doctor1)
	 { 
		 ResponseEntity<?> response = null;
		 try
		 { 
			 response = new ResponseEntity<>(service.saveDoctor(doctor1), HttpStatus.OK); 
			 }
		 catch(DoctorAlreadyExistException d)
		 {
			 response = new ResponseEntity<>(d.getMessage(), HttpStatus.OK);
			 } 
		 return response;
		 }

	@GetMapping("/{id}") 
	public ResponseEntity<?>getById(@PathVariable(value="id")long id) throws DoctorNotFoundException
	{ 
		ResponseEntity<?> response = null;

		response = new ResponseEntity<>(service.getDoctorById(id),HttpStatus.OK);
		
		return response;
		}
	
//	@PutMapping("/doctoredit/{id}")
//    public ResponseEntity<Doctor> updateDoctor(@PathVariable("id") long id, @RequestBody Doctor doctor) {
//    Optional <Doctor> doctorData= service.findById(id);
//
//      if (doctorData.isPresent()) {
//          Doctor _doctor = doctorData.get();
//          _doctor.setDoctorName(doctor.getDoctorName());
//          _doctor.setSpeciality (doctor.getSpeciality());
////          _doctor.setDoctorEmail (doctor.getDoctorEmail());
//
//          return new ResponseEntity<>(service.save( _doctor), HttpStatus.OK);
//           } else {
//          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//          }
//          }
	
	
	@PutMapping("/doctorRemove")
	public ResponseEntity<?> put1(@RequestBody Doctor doctor){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.removeRecommendedDoctor(doctor), HttpStatus.OK);
		} catch (DoctorNotFoundException e) {
			  response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
 
 @PutMapping("/ClinicRemove")
	public ResponseEntity<?> put2(@RequestBody Doctor doctor){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.removeRecommendedClinic(doctor), HttpStatus.OK);
		} catch (DoctorNotFoundException e) {
			  response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	
}
