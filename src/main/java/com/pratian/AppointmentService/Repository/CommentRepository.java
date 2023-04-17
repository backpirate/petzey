package com.pratian.AppointmentService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pratian.AppointmentService.Entities.Comment;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

	@Query(value = "select com from Comment com")//HQL or //JPQL
	public List<Comment> getComments();
	
	//@Query(value = "select * from appointment where appointmentId = id")//SQL
	@Query(value="select com from Comment com where com.commentid = :id")//HQL
	public Comment getCommentById(@Param(value = "id" )long id);
	
}
