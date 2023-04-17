/*package com.pratian.AppointmentService.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//import com.pratian.AppointmentService.Entities.Prescription;
import com.pratian.AppointmentService.Entities.Symptom;
@Repository
public interface SymptomRepository extends JpaRepository<Symptom, Long>{
	@Query(value = "select e from Symptom e")//HQL or //JPQL
	public List<Symptom> getSymptom();
	
	@Query(value="select e from Symptom e where e.symptomid = :id")//HQL
	public Symptom getPrescriptionById(@Param(value = "id" )long id);
	
	//public boolean existsById(String symptomName);
	//public Optional<Symptom> findById(String symptomName);
}
*/

 package com.pratian.AppointmentService.Repository;
  import java.util.List; 
  import org.springframework.data.jpa.repository.JpaRepository; 
  import org.springframework.data.jpa.repository.Query; 
  import org.springframework.data.repository.query.Param; 
 import org.springframework.stereotype.Repository; 
 import com.pratian.AppointmentService.Entities.Symptom;
 
 @Repository 
 public interface SymptomRepository extends JpaRepository<Symptom, Long>{
  
 @Query(value = "select s from Symptom s")//HQL or //JPQL 
 public List<Symptom> getSymptoms();
 
 @Query(value="select s from Symptom s where s.symptomid = :id")//HQL public
 Symptom getSymptomById(@Param(value = "id" )long id);
 
}
 