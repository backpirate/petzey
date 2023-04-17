package com.pratian.AppointmentService.Repository;



import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import com.pratian.AppointmentService.Dto.AppointmentWithDoctorDto;
import com.pratian.AppointmentService.Entities.Appointment;
import com.pratian.AppointmentService.Entities.PetParent;

@Repository
public interface IAppointmentRepo extends JpaRepository<Appointment, Long>{

	//In-built methods

	//@Query(value = "select * from appointment",nativeQuery = true)//SQL
	@Query(value = "select a from Appointment a")//HQL or //JPQL
	public List<Appointment> getAppointments();
	
	//@Query(value = "select * from appointment where appointmentId = id")//SQL
	@Query(value="select a from Appointment a where a.appointmentId = :id")//HQL
	public Appointment getAppointmentById(@Param(value = "id" )long id);
	
	//view Total number of confirmed appointments
	@Query(value="select count(a.status) from Appointment a where a.status= 1")
	public int ViewTotalNumberofConfirmedAppointments();
	
	@Query(value="select count(a.date) from Appointment a where a.date= 1")
	public int ViewTotalNumberofAppointmentsOnThatDate();
	
	//view Total number of closed appointments
	@Query(value="select count(a.status) from Appointment a where a.status= 1")
	public int ViewTotalNumberofClosedAppointments();
			
	//view Total number of Cancelled appointments
	@Query(value="select count(a.status) from Appointment a where a.status= 0")
	public int ViewTotalNumberofCancelledAppointments();
	
	@Query(value="select a from Appointment a where a.status= :status")
	public List<Appointment> getAppointmentsByStatus(@Param(value="status")String status);
	
	

	@Query(value="select a from Appointment a where a.date = :date")
	public List<Appointment> getAppointmentsByDate(@Param(value="date")Date date);
	
	@Query(value="select a from Appointment a where a.date BETWEEN :startDate AND :endDate")
    public List<Appointment> getAppointmentsByDateRange(@Param(value= "startDate") Date startDate, @Param(value= "endDate")  Date endDate);

	
	@Query(value="select count(a.status) from Appointment a ")
	public int ViewTotalNumberofRequestedAppointments();
	
//	view Total number of Cancelled appointments
		@Query(value="select count(a.status) from Appointment a where a.status= 'cancel'")
		public int getTotalNumberofCancelledAppointments();	
		
//	view Total number of Closed appointments
			@Query(value="select count(a.status) from Appointment a where a.status= 'close'")
			public int getTotalNumberofClosedAppointments();	
			
//	view Total number of Confirmed appointments
			@Query(value="select count(a.status) from Appointment a where a.status= 'confirm'")
			public int getTotalNumberofConfirmeddAppointments();
			
			
			
			@Query(value="SELECT a FROM Appointment a INNER JOIN a.doctor d WHERE d.doctorName= :doctorName")
			public List<Appointment> doctorfilteration(@Param(value="doctorName") String doctorName);

			///AppointmentReport/////
			@Query(value="SELECT pp FROM PetParent pp JOIN pp.pets p  JOIN p.appointments a  JOIN a.prescriptions pr   WHERE p.petId= :petId ")
			public List<PetParent> demo(@Param(value="petId")long petId);
	
//	@Query("SELECT new com.pratian.AppointmentService.Dto.AppointmentWithDoctorDto( a.appointmentId , a.status , a.details , a.reasonForVisit, d.doctorName ,d.doctorMobileNo,d.doctorEmail) FROM Doctor d JOIN d.appointments a WHERE a.appointmentId= :appointmentId")
//	public List<AppointmentWithDoctorDto> a_d(@Param(value="appointmentId")long appointmentId);


	
	//@Query("SELECT new com.pratian.AppointmentService.Dto.AppointmentWithDoctorDto(  a.appointmentId ,a.status , a.details , a.reasonForVisit, d.name ,d.mobileNo,d.email) FROM Doctor d JOIN d.appointments a WHERE d.doctorId= :doctorId")
	//public List<AppointmentWithDoctorDto> getDoctorByName(@Param(value="name")String name); 
}

