package com.pratian.AppointmentService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.pratian.AppointmentService.Entities.Vital;

@Repository
public interface VitalRepository extends JpaRepository<Vital, Long>{

	@Query(value = "select v from Vital v")//HQL or //JPQL
	public List<Vital> getVitals();
	
	@Query(value="select v from Vital v where v.vitalsId = :id")//HQL
	public Vital getVitalById(@Param(value = "id" )long id);

	//public Vital save(Vital vital0);

	//public boolean existsById(long vitalid);
	
	//public Vital save(Vital vital0);

	//public boolean existsById(long vitalid);
}
