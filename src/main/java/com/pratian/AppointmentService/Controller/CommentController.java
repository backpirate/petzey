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

import com.pratian.AppointmentService.Entities.Comment;
import com.pratian.AppointmentService.Entities.Feedback;
import com.pratian.AppointmentService.Exceptions.CommentAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.CommentNotFoundException;
import com.pratian.AppointmentService.Repository.CommentRepository;
import com.pratian.AppointmentService.Service.CommentService;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired 
	 private CommentService service;
	
	@Autowired 
	 private CommentRepository commentRepo;
	 
	 @GetMapping("/getComment")
	 public ResponseEntity<?> get(){ 
		 ResponseEntity<?>response = null; 
	 try {
		 response = new ResponseEntity<>(service.getAllComments(), HttpStatus.OK); 
	 }
	 catch(CommentNotFoundException com) 
	 {
		 response = new ResponseEntity<>(com.getMessage(),HttpStatus.OK);
		 }
	 return response; 
	 }
	 
	 @PostMapping("/postComment") 
	 public ResponseEntity<?> post(@RequestBody Comment comment1)
	 { 
		 ResponseEntity<?> response = null;
		 try 
		 { 
			 response = new ResponseEntity<>(service.saveComment(comment1), HttpStatus.OK); 
			 }
		 catch(CommentAlreadyExistException a) 
		 {
			 response = new ResponseEntity<>(a.getMessage(), HttpStatus.OK);
			 } 
		 return response;
		 }

//	@GetMapping("/{id}") 
//	public ResponseEntity<?>getById(@PathVariable(value="id")long id) throws CommentNotFoundException
//	{ 
//		ResponseEntity<?> response = null;
//
//		response = new ResponseEntity<>(service.getCommentById(id),HttpStatus.OK);
//		
//		return response;
//		}
	
	@PutMapping("/commentedit/{id}")
	  public ResponseEntity<Comment> updateComment(@PathVariable("id") long id, @RequestBody Comment comment) {
	  Optional <Comment> commentData= commentRepo.findById(id);
	  
		if (commentData.isPresent()) {
			Comment c = commentData.get();
			c.setDescription(comment.getDescription());
			
			return new ResponseEntity<>(commentRepo.save( c), HttpStatus.OK);
			 } else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			}
	
	
}
