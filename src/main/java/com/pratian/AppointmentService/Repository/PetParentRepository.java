package com.pratian.AppointmentService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pratian.AppointmentService.Entities.Doctor;
import com.pratian.AppointmentService.Entities.PetParent;

@Repository
public interface PetParentRepository extends JpaRepository<PetParent, Long> {

	
	@Query(value = "select pp from PetParent pp")//HQL or //JPQL
	public List<PetParent> getPetParents();
	
	//@Query(value = "select * from appointment where appointmentId = id")//SQL
	@Query(value="select pp from PetParent pp where pp.petparentid = :id")//HQL
	public Doctor getPetParentById(@Param(value = "id" )long id);
	
	

}
