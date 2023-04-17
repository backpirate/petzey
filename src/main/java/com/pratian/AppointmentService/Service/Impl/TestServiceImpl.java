package com.pratian.AppointmentService.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratian.AppointmentService.Entities.Test;
import com.pratian.AppointmentService.Exceptions.TestAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.TestNotFoundException;
import com.pratian.AppointmentService.Repository.TestRepository;
import com.pratian.AppointmentService.Service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestRepository testRepo;
	
	@Override
	public List<Test> getAllTests() throws TestNotFoundException {
		List<Test> tests = testRepo.getTests();
		if(tests.isEmpty()) {
			throw new TestNotFoundException("Test list is empty.");
		}
		
		return tests;
	}

	@Override
	public Test saveTest(Test test0) throws TestAlreadyExistException {
		Test test2 = null;
		if(testRepo.existsById(test0.getTestId())) {
			throw new TestAlreadyExistException("Test already exist.");
		}
		else {
			test2 = testRepo.save(test0);
		}
		return test2;
	}

	@Override
	public Test editTest(Test test) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteTest(long id) {
		testRepo.deleteById(id);
		return "deleted";

	}

	@Override
	public Test getTestById(long id) {
		Test test = testRepo.findById(id).get();
		return test;
	}

	@Override
	public Test getPetByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
