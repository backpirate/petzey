package com.pratian.AppointmentService.Controller;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pratian.AppointmentService.Entities.Appointment;
import com.pratian.AppointmentService.Exceptions.AppointmentAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.AppointmentDatesNotFoundExceptions;
import com.pratian.AppointmentService.Exceptions.AppointmentNotFoundException;
import com.pratian.AppointmentService.Exceptions.AppointmentStatusNotFoundExceptions;
import com.pratian.AppointmentService.Exceptions.DoctorNotFoundException;
import com.pratian.AppointmentService.Exceptions.PetNotFoundException;
import com.pratian.AppointmentService.Repository.IAppointmentRepo;
import com.pratian.AppointmentService.Service.IAppointmentService;

import io.swagger.v3.oas.annotations.Operation;


@CrossOrigin(origins= "http://localhost:3000")
@RestController
@RequestMapping("/appointmentAl")
public class AppointmentController {
		
	//testing
	@Autowired
	private IAppointmentService service;
	
	@Autowired
	private IAppointmentRepo appointmentRepo;
	
				
	@GetMapping("/appointments")
	public ResponseEntity<?> get() {
	    try {
	        return new ResponseEntity<>(service.getAllAppointments(), HttpStatus.OK);
	    } catch (AppointmentNotFoundException e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
	    }
	}
	
	@PostMapping("/post")
	public ResponseEntity<?> post(@RequestBody Appointment appointment) {
	    try {
	        return new ResponseEntity<>(service.saveAppointment(appointment), HttpStatus.OK);
	    } catch (AppointmentAlreadyExistException e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
	    }
	}

	@GetMapping("/display/{id}")
	public ResponseEntity<?> getById(@PathVariable long id) throws AppointmentNotFoundException {
	    return new ResponseEntity<>(service.getAppointmentById(id), HttpStatus.OK);
	}

	@PutMapping("/appointmentedit")
	public ResponseEntity<?> put(@RequestBody Appointment appointmentedit) {
	    try {
	        return new ResponseEntity<>(service.editAppointmentDetails(appointmentedit), HttpStatus.OK);
	    } catch (AppointmentNotFoundException e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
	    }
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) throws AppointmentNotFoundException {
	    return new ResponseEntity<>(service.deleteAppointment(id), HttpStatus.OK);
	}

	
	//ViewAppointmentByStatus
	@GetMapping("getstatus/{status}")
	public ResponseEntity<?>getByStatus(@PathVariable(value="status")String status){
		ResponseEntity<?> response = null;
		try {
			response=new ResponseEntity<>(service.viewAppointmentsByStatus(status),HttpStatus.OK);
		} catch (AppointmentStatusNotFoundExceptions e) {
			// TODO Auto-generated catch block
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	
	//view by doctorname
	/*@GetMapping("getstatus/{doctorname}")
	public ResponseEntity<?>getDoctorByName(@PathVariable(value="name")String name) throws DoctorNotFoundException{
		ResponseEntity<?> response = null;
		response=new ResponseEntity<>(service.getDoctorByName(name),HttpStatus.OK);
		return response;
	}*/
	
	@GetMapping("getdate/{date}")
	public ResponseEntity<?>getByDate(@PathVariable(value="date")Date date){
		ResponseEntity<?> response = null;
		try {
			response=new ResponseEntity<>(service.viewAppointmentsByDate(date),HttpStatus.OK);
		} catch (AppointmentDatesNotFoundExceptions e) {
			// TODO Auto-generated catch block
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	
	@GetMapping("Appointments/{startDate}/{endDate}")
	public ResponseEntity<?> getAppointmentsByDateRange(@PathVariable(value= "startDate") Date startDate, @PathVariable(value= "endDate")  Date endDate) throws AppointmentDatesNotFoundExceptions {
		ResponseEntity<?> response=null;
		response=new ResponseEntity<>(service.appointmentsInTheDateRange( startDate,  endDate), HttpStatus.OK);
		return response;
				
	}
	
		
		@PutMapping("/appointmentedit/{id}")
		  public ResponseEntity<Appointment> updateAppointment(@PathVariable("id") long id, @RequestBody Appointment appointment) {
		  Optional <Appointment> appointmentData= appointmentRepo.findById(id);
		  
			if (appointmentData.isPresent()) {
				Appointment _appointment = appointmentData.get();
				_appointment.setDate(appointment.getDate());
				_appointment.setStatus (appointment.getStatus());
				_appointment.setDetails (appointment.getDetails());
				_appointment.setReasonForVisit (appointment.getReasonForVisit()); 
				return new ResponseEntity<>(appointmentRepo.save( _appointment), HttpStatus.OK);
				 } else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
				}
		
		@GetMapping("/totalAppointmnets")
		@Operation(summary ="To get the total number of Appointment Requests")
		public ResponseEntity<?> getAppointments() throws AppointmentNotFoundException{
			ResponseEntity<?> response=null;
			response = new ResponseEntity<>(service.ViewTotalNumberofRequestedAppointments(),HttpStatus.OK);
			return response;
		}
		
		
		
		
		
		@GetMapping("totalCancelAppointmnets/cancelAppointment")
		@Operation(summary = "To get total no of cancel appointments")
		public ResponseEntity<?> getCancelAppointments() throws AppointmentNotFoundException{
				ResponseEntity<?> response=null;
				response = new ResponseEntity<>(service.totalNumberOfCancelledAppointments(),HttpStatus.OK);
			return response;
		}
		
		
		@GetMapping("totalClosedAppointmnets/closedAppointment")
		@Operation(summary = "To get total no of cancel appointments")
		public ResponseEntity<?> getClosedAppointments() throws AppointmentNotFoundException{
				ResponseEntity<?> response=null;
				response = new ResponseEntity<>(service.totalNumberOfClosedAppointments(),HttpStatus.OK);
			return response;
		}
		
		@GetMapping("totalConfirmedAppointmnets/confirmAppointment")
		@Operation(summary = "To get total no of cancel appointments")
		public ResponseEntity<?> getConfirmedAppointments() throws AppointmentNotFoundException{
				ResponseEntity<?> response=null;
				response = new ResponseEntity<>(service.totalNumberOfConfirmedAppointments(),HttpStatus.OK);
			return response;
		}
		
		
		
		@GetMapping("/getawithd/{doctorName}")
		public ResponseEntity<?>getByid(@PathVariable(value="doctorName")String doctorName) throws  DoctorNotFoundException{
			ResponseEntity<?> response = null;
			response=new ResponseEntity<>(service.doctorfilteration(doctorName),HttpStatus.OK);
			return response;
		}	
		
		@GetMapping("/getpetparentAppo/{petId}")
		public ResponseEntity<?>get7(@PathVariable(value="petId")long petId) throws AppointmentNotFoundException {
			ResponseEntity<?> response = null;
			response=new ResponseEntity<>(service.demo(petId),HttpStatus.OK);
			return response;
		}	
		
		
}





