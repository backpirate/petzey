package com.pratian.AppointmentService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pratian.AppointmentService.Entities.Clinic;

@Repository
public interface ClinicRespository extends JpaRepository<Clinic, Long> {

		@Query(value = "select c from Clinic c")//HQL or //JPQL
		public List<Clinic> getClinics();
		
		//@Query(value = "select * from appointment where appointmentId = id")//SQL
		@Query(value="select c from Clinic c where c.clinicId = :id")//HQL
		public Clinic getClinicById(@Param(value = "id" )long id);

		
		//TEST
		//@Query(value = "select c from clinic c where c, Clinic = : address")
		//public Clinic findByName(@Param(value ="address") String address);

		
}