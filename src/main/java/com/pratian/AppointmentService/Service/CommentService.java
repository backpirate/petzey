package com.pratian.AppointmentService.Service;

import java.util.List;

import com.pratian.AppointmentService.Entities.Comment;
import com.pratian.AppointmentService.Exceptions.CommentAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.CommentNotFoundException;

public interface CommentService {

	public List<Comment> getAllComments() throws CommentNotFoundException;//GET
	
	public Comment saveComment(Comment comment) throws CommentAlreadyExistException;//POST
	
//	public Comment editComment(Comment comment) throws CommentNotFoundException;//PUT
	
//	public String deleteComment(long id);//DELETE
	
//	public Comment getCommentById(long id) throws CommentNotFoundException;//GET
//	
//	public  Comment editCommentDetails(Comment commentedit) throws CommentNotFoundException ; //PUT
//
//	
//	public Comment getCommentByName(String name);//GET
}
