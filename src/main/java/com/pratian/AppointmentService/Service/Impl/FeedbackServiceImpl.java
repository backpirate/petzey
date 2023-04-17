package com.pratian.AppointmentService.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratian.AppointmentService.Entities.Feedback;
import com.pratian.AppointmentService.Exceptions.FeedbackAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.FeedbackNotFoundException;
import com.pratian.AppointmentService.Repository.FeedbackRepository;
import com.pratian.AppointmentService.Service.FeedbackService;



@Service
public class FeedbackServiceImpl implements FeedbackService{
	
	@Autowired
	private FeedbackRepository feedbackRepo;

	@Override
	public List<Feedback> getAllFeedbacks() throws FeedbackNotFoundException {
		List<Feedback> feedbacks = feedbackRepo.getFeedbacks();
		if(feedbacks.isEmpty()) {
			throw new FeedbackNotFoundException("Feedback list is empty.");
	}
		return feedbacks;
	}

	@Override
	public Feedback saveFeedback(Feedback feedback0) throws FeedbackAlreadyExistException {
		Feedback feedback2 = null;
		if(feedbackRepo.existsById(feedback0.getFeedbackId())) {
			throw new FeedbackAlreadyExistException("Feedback already exist.");
		}
		else {
			feedback2 = feedbackRepo.save(feedback0);
		}
		return feedback2;
	}

	@Override
	public Feedback editFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public String deleteFeedback(long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Feedback getFeedbackById(long id) throws FeedbackNotFoundException {
//		Feedback feedback = feedbackRepo.findById(id).get();//orElseThrow(()->new ClinicNotFoundException("Clinic does not Exist with this id"));//inbuilt
//		return feedback;
//	}
//
//	@Override
//	public Feedback getFeedbackByName(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Feedback editFeedbackDetails(Feedback feedbackedit) throws FeedbackNotFoundException {
//		Feedback f=null;
//		if(feedbackRepo.existsById(feedbackedit.getFeedbackId())) {
//			f=feedbackRepo.findById(feedbackedit.getFeedbackId()).get();
//			f.setDetails(feedbackedit.getDetails());
//			
//			feedbackRepo.save(f);
//		}
//       
//        else{
//           throw new FeedbackNotFoundException();
//        }
//
//		return f;
//	}
	
	
}
