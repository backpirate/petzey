//package com.pratian.AppointmentService;
//
//public class VitalTest {
//
//}
/*
 * package com.pratian.AppointmentService;
 * 
 * public class VitalTest {
 * 
 * }
 */
//package com.pratian.AppointmentService;
//
////public class VitalTest {
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

//import com.pratian.AppointmentService.Controller.VitalContoller;
import com.pratian.AppointmentService.Controller.VitalController;
//import com.pratian.AppointmentService.Controller.VitalController;
//import com.pratian.AppointmentService.Service.VitalService;
import com.pratian.AppointmentService.Entities.Vital;
import com.pratian.AppointmentService.Service.VitalService;


	@ExtendWith(SpringExtension.class)
	@WebMvcTest(value = VitalController.class)

	public class VitalTest {
		@Autowired(required = false)
		private MockMvc mockMvc;
		//@Builder(access = AccessLevel.PACKAGE)
		@MockBean
		private VitalService vitalService;
		List<Vital>vitals=new ArrayList();
		Vital vital = new Vital();

		Vital mockVital = new Vital();
		//String examplePatientJson = "{\"name\":\"string\",\"species\":\"string\",\"gender\":\"string\",\"reproductivity\":\"string\",\"booldGroup\":\"string\",\"allergies\":\"string\"}";
		
		@Test
		public void getVitalTest() throws Exception {

			Mockito.when(
					vitalService.getAllVitals()).thenReturn(vitals);
					
//					patientService.getPatientProfile());
			RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
					"/vitals/getvital").accept(
					MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();

			System.out.println(result.getResponse());
			//String now = "{\"name\":\"string\",\"species\":\"string\",\"gender\":\"string\",\"reproductivity\":\"string\",\"booldGroup\":\"string\",,\"allergies\":\"string\"}";

			// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

			//JSONAssert.assertEquals(now, result.getResponse()
			//		.getContentAsString());
		}
		
	}
