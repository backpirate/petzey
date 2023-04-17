package com.pratian.AppointmentService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pratian.AppointmentService.Entities.Feedback;


@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long>{

	
	@Query(value = "select f from Feedback f")//HQL or //JPQL
	public List<Feedback> getFeedbacks();
	
	@Query(value="select f from Feedback f where f.feedbackId = :id")//HQL
	public Feedback getClinincById(@Param(value = "id" )long id);

}
