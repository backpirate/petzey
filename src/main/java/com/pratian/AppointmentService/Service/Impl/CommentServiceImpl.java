package com.pratian.AppointmentService.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratian.AppointmentService.Entities.Comment;
import com.pratian.AppointmentService.Entities.Feedback;
import com.pratian.AppointmentService.Exceptions.CommentAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.CommentNotFoundException;
import com.pratian.AppointmentService.Exceptions.FeedbackNotFoundException;
import com.pratian.AppointmentService.Repository.CommentRepository;
import com.pratian.AppointmentService.Service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepo;
	
	@Override
	public List<Comment> getAllComments() throws CommentNotFoundException {
		List<Comment> comments = commentRepo.getComments();
		if(comments.isEmpty()) {
			throw new CommentNotFoundException("Comment list is empty.");
		}
		
		return comments;
	}

	@Override
	public Comment saveComment(Comment comment0) throws CommentAlreadyExistException {
		Comment comment2 = null;
		if(commentRepo.existsById(comment0.getCommentid())) {
			throw new CommentAlreadyExistException("Comment already exist.");
		}
		else {
			comment2 = commentRepo.save(comment0);
		}
		return comment2;
	}

	

	

	

//	@Override
//	public Comment getCommentById(long id) throws CommentNotFoundException {
//		Comment comment = commentRepo.findById(id).get();//orElseThrow(()->new ClinicNotFoundException("Clinic does not Exist with this id"));//inbuilt
//		return comment;
//	}

	

//	@Override
//	public Comment editCommentDetails(Comment commentedit) throws CommentNotFoundException {
//		Comment c=null;
//		if(commentRepo.existsById(commentedit.getCommentid())) {
//			c=commentRepo.findById(commentedit.getCommentid()).get();
//			c.setDescription(commentedit.getDescription());
//			
//			commentRepo.save(c);
//		}
//       
//        else{
//           throw new CommentNotFoundException();
//        }
//
//		return c;
//	}


}
