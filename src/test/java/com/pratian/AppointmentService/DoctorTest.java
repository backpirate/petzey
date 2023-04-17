//package com.pratian.AppointmentService;
//
////public class DoctorTest {
////
////}
//
package com.pratian.AppointmentService;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.pratian.AppointmentService.Controller.DoctorController;
//import com.pratian.AppointmentService.Service.DoctorService;
import com.pratian.AppointmentService.Entities.Doctor;
import com.pratian.AppointmentService.Service.DoctorService;


	@ExtendWith(SpringExtension.class)
	@WebMvcTest(value = DoctorController.class)

	public class DoctorTest {
		@Autowired(required = false)
		private MockMvc mockMvc;
		//@Builder(access = AccessLevel.PACKAGE)
		@MockBean
		private DoctorService doctorService;
		List<Doctor>doctors=new ArrayList();
		Doctor doctor = new Doctor();

		Doctor mockDoctor = new Doctor();
		//String examplePatientJson = "{\"name\":\"string\",\"species\":\"string\",\"gender\":\"string\",\"reproductivity\":\"string\",\"booldGroup\":\"string\",\"allergies\":\"string\"}";
		
		@Test
		public void getDoctorTest() throws Exception {

			Mockito.when(
					doctorService.getAllDoctors()).thenReturn(doctors);
					
//					patientService.getPatientProfile());
			RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
					"/doctors/getdoctor").accept(
					MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();

			System.out.println(result.getResponse());
			//String now = "{\"name\":\"string\",\"species\":\"string\",\"gender\":\"string\",\"reproductivity\":\"string\",\"booldGroup\":\"string\",,\"allergies\":\"string\"}";

			// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

			//JSONAssert.assertEquals(now, result.getResponse()
			//		.getContentAsString());
		}
		
	}
