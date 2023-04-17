package com.pratian.AppointmentService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pratian.AppointmentService.Entities.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long>{

	@Query(value = "select t from Test t")//HQL or //JPQL
	public List<Test> getTests();
	
	//@Query(value = "select * from appointment where appointmentId = id")//SQL
	@Query(value="select t from Test t where t.testId = :id")//HQL
	public Test getTestById(@Param(value = "id" )long id);


}
