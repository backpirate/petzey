package com.pratian.AppointmentService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pratian.AppointmentService.Entities.Prescription;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long>{
	
	@Query(value = "select pre from Prescription pre")//HQL or //JPQL
	public List<Prescription> getPrescriptions();
	
	//@Query(value = "select * from appointment where appointmentId = id")//SQL
	@Query(value="select pre from Prescription pre where pre.preid = :id")//HQL
	public Prescription getPrescriptionById(@Param(value = "id" )long id);
}
