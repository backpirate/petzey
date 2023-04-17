package com.pratian.AppointmentService.Service;

import java.sql.Date;
import java.util.List;

//import com.pratian.AppointmentService.Dto.AppointmentWithDoctorDto;
import com.pratian.AppointmentService.Entities.Appointment;
import com.pratian.AppointmentService.Entities.PetParent;
import com.pratian.AppointmentService.Exceptions.AppointmentAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.AppointmentDatesNotFoundExceptions;
//import com.pratian.AppointmentService.Exceptions.AppointmentNotFoundException;
import com.pratian.AppointmentService.Exceptions.AppointmentNotFoundException;
import com.pratian.AppointmentService.Exceptions.AppointmentStatusNotFoundExceptions;
import com.pratian.AppointmentService.Exceptions.DoctorNotFoundException;

public interface IAppointmentService {
	
	//Get All
	public List<Appointment> getAllAppointments() throws AppointmentNotFoundException;//GET
	
	//post 
	public Appointment saveAppointment(Appointment appointment) throws AppointmentAlreadyExistException;//POST
	
	//Delete
	public String deleteAppointment(long id) throws AppointmentNotFoundException;//DELETE
	
	//Get bt Id
	public Appointment getAppointmentById(long id) throws AppointmentNotFoundException;//GET
		
	//PUT/edit
	public  Appointment editAppointmentDetails(Appointment appointmentedit) throws AppointmentNotFoundException ; //PUT

	
	//cancel
	public int ViewTotalNumberofCancelledAppointments() throws AppointmentNotFoundException;

	//closed
	public int ViewTotalNumberofClosedAppointments() throws AppointmentNotFoundException;

	//confirm
	public int ViewTotalNumberofConfirmedAppointments() throws AppointmentNotFoundException;
	
	
	public Appointment closeAppointmentDetails( Appointment appointment) throws AppointmentNotFoundException;
	
	//view by Status
    public List<Appointment> viewAppointmentsByStatus(String status) throws AppointmentStatusNotFoundExceptions;
    
    // filter by date
    public List<Appointment> viewAppointmentsByDate(Date date) throws AppointmentDatesNotFoundExceptions;

    
    //range date
    public List<Appointment> appointmentsInTheDateRange(Date startDate, Date endDate) throws AppointmentDatesNotFoundExceptions;
    
    //Total appointment
	public int ViewTotalNumberofRequestedAppointments() throws AppointmentNotFoundException;


    //Total Cancel
    public int totalNumberOfCancelledAppointments() throws AppointmentNotFoundException;

    //Total  Closed
	public int totalNumberOfClosedAppointments()  throws AppointmentNotFoundException;
	
	//Total confirm
	public int totalNumberOfConfirmedAppointments() throws AppointmentNotFoundException;
    
    //Filter appointment by doctor
     public List<Appointment> doctorfilteration(String doctorName) throws DoctorNotFoundException;
    
    //Report 
    public List<PetParent> demo(long petId) throws AppointmentNotFoundException; 
    
    
//	public List<AppointmentWithDoctorDto> a_d(Long appointmentId);
}

