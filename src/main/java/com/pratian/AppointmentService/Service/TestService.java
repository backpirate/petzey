package com.pratian.AppointmentService.Service;

import java.util.List;

import com.pratian.AppointmentService.Entities.Test;
import com.pratian.AppointmentService.Exceptions.TestAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.TestNotFoundException;



public interface TestService {
	public List<Test> getAllTests() throws TestNotFoundException ;//GET
	
	public Test saveTest(Test test) throws TestAlreadyExistException ;//POST
	
	public Test editTest(Test test);//PUT
	
	public String deleteTest(long id);//DELETE
	
	public Test getTestById(long id);//GET
	
	public Test getPetByName(String name);//GET

}
