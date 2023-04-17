package com.pratian.AppointmentService.Service;

import java.util.List;

import com.pratian.AppointmentService.Entities.Appointment;
import com.pratian.AppointmentService.Entities.Feedback;
import com.pratian.AppointmentService.Exceptions.AppointmentNotFoundException;
import com.pratian.AppointmentService.Exceptions.FeedbackAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.FeedbackNotFoundException;


public interface FeedbackService {

	public List<Feedback> getAllFeedbacks() throws FeedbackNotFoundException;//GET
	
	public Feedback saveFeedback(Feedback feedback) throws FeedbackAlreadyExistException;//POST
	
	public Feedback editFeedback(Feedback feedback) throws FeedbackNotFoundException;//PUT
	
//	public String deleteFeedback(long id);//DELETE
//	
//	public Feedback getFeedbackById(long id) throws FeedbackNotFoundException;//GET
//	
//	public Feedback getFeedbackByName(String name);//GET
//	
//	public  Feedback editFeedbackDetails(Feedback feedbackedit) throws FeedbackNotFoundException ; //PUT

	
}
