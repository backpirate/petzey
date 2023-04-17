package com.pratian.AppointmentService.Service.Impl;

import java.sql.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.pratian.AppointmentService.Dto.AppointmentWithDoctorDto;
import com.pratian.AppointmentService.Entities.PetParent;

import com.pratian.AppointmentService.Entities.Appointment;
import com.pratian.AppointmentService.Exceptions.AppointmentAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.AppointmentDatesNotFoundExceptions;
import com.pratian.AppointmentService.Exceptions.AppointmentNotFoundException;
import com.pratian.AppointmentService.Exceptions.DoctorNotFoundException;
import com.pratian.AppointmentService.Repository.IAppointmentRepo;
import com.pratian.AppointmentService.Service.IAppointmentService;

@Service
public class AppointmentServiceImpl implements IAppointmentService {
	
	@Autowired
	private IAppointmentRepo appoRepo;//Appointment	
	
	
	@Override
	public List<Appointment> getAllAppointments() throws AppointmentNotFoundException {
		//List<Appointment> appointments = appoRepo.findAll();//inbuilt methods
		List<Appointment> appointments = appoRepo.getAppointments();//Custom query
		if(appointments.isEmpty()) {
				throw new AppointmentNotFoundException("Appointment list empty");
		}
		return appointments;
	}

	@Override
	public Appointment saveAppointment(Appointment appointment) throws AppointmentAlreadyExistException {
		Appointment appointment2 = null;
		if(appoRepo.existsById(appointment.getAppointmentId())) {
			throw new AppointmentAlreadyExistException("Appointment already exist");
		}
		else {
			 appointment2 = appoRepo.save(appointment);
		}
		return appointment2;
	}

	//orginal code
	@Override
	public String deleteAppointment(long id) {
		appoRepo.deleteById(id);
		return "deleted";
	}	
	
	
	//working code
	@Override
	public Appointment getAppointmentById(long id) throws AppointmentNotFoundException{
		Appointment appointment = appoRepo.findById(id).get();
		return appointment;
		
	}
	//doctorname
	/*@Override
	public List<AppointmentWithDoctorDto> getDoctorByName(String name) {
		// TODO Auto-generated method stub
		List<AppointmentWithDoctorDto> sta12 = appoRepo.getDoctorByName(name);
		return sta12;
	}
	*/
	

	@Override
	public Appointment editAppointmentDetails(Appointment appointmentedit) throws AppointmentNotFoundException {
		Appointment ap=null;
		if(appoRepo.existsById(appointmentedit.getAppointmentId())) {
			ap=appoRepo.findById(appointmentedit.getAppointmentId()).get();
			ap.setDate(appointmentedit.getDate());
			ap.setStatus(appointmentedit.getStatus());
			ap.setDetails(appointmentedit.getDetails());
			appoRepo.save(ap);
		}
       
        else{
           throw new AppointmentNotFoundException();
        }

		return ap;
	}
	
	
	
	

	@Override
	public List<Appointment> viewAppointmentsByStatus(String status) {
		// TODO Auto-generated method stub
		List<Appointment> sta=appoRepo.getAppointmentsByStatus(status);
		return sta;
	}
	
	
	
	
	
	@Override
	public Appointment closeAppointmentDetails(Appointment appointment) throws AppointmentNotFoundException {
		Appointment ac1=null;
		if(appoRepo.existsById(appointment.getAppointmentId())) {
			ac1.setStatus("0");
			appoRepo.save(ac1);
		}
       
        else{
           throw new AppointmentNotFoundException();
        }	
		return ac1;
	}
	
	@Override
	public int ViewTotalNumberofConfirmedAppointments() throws AppointmentNotFoundException {
			int vtnca=appoRepo.ViewTotalNumberofConfirmedAppointments();
			return vtnca;
	}
	
	@Override
	public int ViewTotalNumberofClosedAppointments() throws AppointmentNotFoundException {
		int vtnclsa=appoRepo.ViewTotalNumberofClosedAppointments();
		return vtnclsa;
		
	}
	
	@Override
	public int ViewTotalNumberofCancelledAppointments() throws AppointmentNotFoundException {
		int vtncana=appoRepo.ViewTotalNumberofCancelledAppointments();
		return vtncana;
	}

	@Override
	public List<Appointment> viewAppointmentsByDate(Date date) throws AppointmentDatesNotFoundExceptions {
		// TODO Auto-generated method stub
		List<Appointment> date1=appoRepo.getAppointmentsByDate(date);
		return date1;
		
	}
	//Date Range
	@Override
    public List<Appointment> appointmentsInTheDateRange(Date startDate, Date endDate) {
         List<Appointment> appointments=appoRepo.getAppointmentsByDateRange(startDate,endDate);
         return appointments;

	}

	
	
	//DTO
//		@Override
//		public List<AppointmentWithDoctorDto> a_d(Long appointmentId) {
//			// TODO Auto-generated method stub
//			List<AppointmentWithDoctorDto> date1=appoRepo.a_d(appointmentId);
//			return date1;
//		}
		
	
	@Override
	public int ViewTotalNumberofRequestedAppointments() {
//			throws AppointmentNotFoundException {
		int vtnra=appoRepo.ViewTotalNumberofRequestedAppointments();
		return vtnra;
		
	}
	
	@Override
	public int totalNumberOfCancelledAppointments() {
		int num=appoRepo.getTotalNumberofCancelledAppointments();
		return num;
	}
	
	
	@Override
	public int totalNumberOfClosedAppointments() {
		int num=appoRepo.getTotalNumberofClosedAppointments();
		return num;
	}

	
	@Override
	public int totalNumberOfConfirmedAppointments() {
		int num=appoRepo.getTotalNumberofConfirmeddAppointments();
		return num;
	}
	
	
	
	//DTO
		@Override
		public List<Appointment> doctorfilteration(String doctorName) throws DoctorNotFoundException{
			// TODO Auto-generated method stub
			List<Appointment> date1=appoRepo.doctorfilteration(doctorName);
			return date1;
		}

		@Override
		public List<PetParent> demo(long petId) throws AppointmentNotFoundException {
			// TODO Auto-generated method stub
			List<PetParent> pp1=appoRepo.demo(petId);
			return pp1;
		}
	
	

}