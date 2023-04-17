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

import com.pratian.AppointmentService.Entities.Appointment;
import com.pratian.AppointmentService.Entities.Feedback;
import com.pratian.AppointmentService.Exceptions.FeedbackAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.FeedbackNotFoundException;
import com.pratian.AppointmentService.Repository.FeedbackRepository;
import com.pratian.AppointmentService.Service.FeedbackService;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired 
	 private FeedbackService service;
	
	@Autowired 
	 private FeedbackRepository feedbackRepo;
	
	 
	 @GetMapping("/getFeedbacks")
	 public ResponseEntity<?> get(){ 
		 ResponseEntity<?>response = null; 
	 try {
		 response = new ResponseEntity<>(service.getAllFeedbacks(), HttpStatus.OK); 
	 }
	 catch(FeedbackNotFoundException f) 
	 {
		 response = new ResponseEntity<>(f.getMessage(),HttpStatus.OK);
		 }
	 return response; 
	 }
	 
	 @PostMapping("/postFeedbacks") 
	 public ResponseEntity<?> post(@RequestBody Feedback feedback1)
	 { 
		 ResponseEntity<?> response = null;
		 try 
		 { 
			 response = new ResponseEntity<>(service.saveFeedback(feedback1), HttpStatus.OK); 
			 }
		 catch(FeedbackAlreadyExistException f) 
		 {
			 response = new ResponseEntity<>(f.getMessage(), HttpStatus.OK);
			 } 
		 return response;
		 }

//	@GetMapping("/{id}") 
//	public ResponseEntity<?>getById(@PathVariable(value="id")long id) throws FeedbackNotFoundException
//	{ 
//		ResponseEntity<?> response = null;
//
//		response = new ResponseEntity<>(service.getFeedbackById(id),HttpStatus.OK);
//		
//		return response;
//		}
	
	@PutMapping("/feedbackedit/{id}")
	  public ResponseEntity<Feedback> updateFeedback(@PathVariable("id") long id, @RequestBody Feedback feedback) {
	  Optional <Feedback> feedbackData= feedbackRepo.findById(id);
	  
		if (feedbackData.isPresent()) {
			Feedback fb = feedbackData.get();
			fb.setDetails(feedback.getDetails());
			
			return new ResponseEntity<>(feedbackRepo.save( fb), HttpStatus.OK);
			 } else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			}
	
	
}
