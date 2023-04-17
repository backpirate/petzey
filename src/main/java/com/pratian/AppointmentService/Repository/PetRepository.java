package com.pratian.AppointmentService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import com.pratian.AppointmentService.Dto.PatientAppointmentDoctorDto;
//import com.pratian.AppointmentService.Dto.RecommendedClinicDto;

import com.pratian.AppointmentService.Entities.Patient;

@Repository
public interface PetRepository extends JpaRepository<Patient ,Long> {


	@Query(value = "select p from Patient p")//HQL or //JPQL
	public List<Patient> getPets();

	@Query(value="select p from Patient p where p.petId = :id")//HQL
	public Patient getPetById(@Param(value = "id" )long id);
	
	//get doctor recomendation and clinic
	@Query("SELECT p  FROM Patient p INNER JOIN p.appointments a INNER JOIN a.doctor d WHERE p.petId=:petId")
	public List<Patient> getDoctorRecommendation(@Param(value="petId")Long petId);

}
