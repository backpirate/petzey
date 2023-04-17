package com.pratian.AppointmentService;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.mapstruct.Builder;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import com.pratian.PatientService.Entities.Patient;
//import com.pratian.PatientService.Entities.Symptom;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.pratian.PatientService.Controller.PatientController;
import com.pratian.AppointmentService.Controller.AppointmentController;
import com.pratian.AppointmentService.Repository.IAppointmentRepo;
import com.pratian.AppointmentService.Service.IAppointmentService;
import com.pratian.AppointmentService.Entities.Appointment;
//import com.pratian.PatientService.Entities.Patient;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
//import com.pratian.PatientService.Controller.PatientController;
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = AppointmentController.class)

public class AppointmentTest {
	@Autowired(required = false)
	private MockMvc mockMvc;
	//@Builder(access = AccessLevel.PACKAGE)
	@MockBean
	private IAppointmentService appointmentService;
	List<Appointment>appointments=new ArrayList();
	Appointment appointment = new Appointment();

	Appointment mockAppointment = new Appointment();
	//String examplePatientJson = "{\"name\":\"string\",\"species\":\"string\",\"gender\":\"string\",\"reproductivity\":\"string\",\"booldGroup\":\"string\",\"allergies\":\"string\"}";
	
	@Test
	public void getPatientTest() throws Exception {

		Mockito.when(
				appointmentService.getAllAppointments()).thenReturn(appointments);
				
//				patientService.getPatientProfile());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"//appointmentAl/appointments").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		//String now = "{\"name\":\"string\",\"species\":\"string\",\"gender\":\"string\",\"reproductivity\":\"string\",\"booldGroup\":\"string\",,\"allergies\":\"string\"}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		//JSONAssert.assertEquals(now, result.getResponse()
		//		.getContentAsString());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
