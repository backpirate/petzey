package com.pratian.AppointmentService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import com.pratian.AppointmentService.Dto.AppointmentWithDoctorDto;
import com.pratian.AppointmentService.Entities.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{

	@Query(value = "select d from Doctor d")//HQL or //JPQL
	public List<Doctor> getDoctors();
	
	//@Query(value = "select * from appointment where appointmentId = id")//SQL
	@Query(value="select d from Doctor d where d.doctorId = :id")//HQL
	public Doctor getDoctorById(@Param(value = "id" )long id);
	
	//view Total number of  appointment requests
	@Query(value="select count(a.status) from Appointment a ")
	public int ViewTotalNumberofRequestedAppointments();
	
	
	@Query(value="select d from Doctor d where d.name = :name")//HQL
	public static List<Doctor> getDoctorByName(@Param(value = "name" )String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//TEST
	//@Query(value = "select c from clinic c where c, Clinic = : address")
	//public Clinic findByName(@Param(value ="address") String address);
	
}
