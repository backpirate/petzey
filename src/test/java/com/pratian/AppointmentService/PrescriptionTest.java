/*
 * package com.pratian.AppointmentService;
 * 
 * public class PrescriptionTest {
 * 
 * }
 */
//package com.pratian.AppointmentService;
//
////public class PrescriptionTest {
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

import com.pratian.AppointmentService.Controller.PrescriptionContoller;
//import com.pratian.AppointmentService.Controller.PrescriptionController;
//import com.pratian.AppointmentService.Service.PrescriptionService;
import com.pratian.AppointmentService.Entities.Prescription;
import com.pratian.AppointmentService.Service.PrescriptionService;


	@ExtendWith(SpringExtension.class)
	@WebMvcTest(value = PrescriptionContoller.class)

	public class PrescriptionTest {
		@Autowired(required = false)
		private MockMvc mockMvc;
		//@Builder(access = AccessLevel.PACKAGE)
		@MockBean
		private PrescriptionService prescriptionService;
		List<Prescription>prescriptions=new ArrayList();
		Prescription prescription = new Prescription();

		Prescription mockPrescription = new Prescription();
		//String examplePatientJson = "{\"name\":\"string\",\"species\":\"string\",\"gender\":\"string\",\"reproductivity\":\"string\",\"booldGroup\":\"string\",\"allergies\":\"string\"}";
		
		@Test
		public void getPrescriptionTest() throws Exception {

			Mockito.when(
					prescriptionService.getAllPrescriptions()).thenReturn(prescriptions);
					
//					patientService.getPatientProfile());
			RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
					"/prescriptions/getprescription").accept(
					MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();

			System.out.println(result.getResponse());
			//String now = "{\"name\":\"string\",\"species\":\"string\",\"gender\":\"string\",\"reproductivity\":\"string\",\"booldGroup\":\"string\",,\"allergies\":\"string\"}";

			// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

			//JSONAssert.assertEquals(now, result.getResponse()
			//		.getContentAsString());
		}
		
	}
