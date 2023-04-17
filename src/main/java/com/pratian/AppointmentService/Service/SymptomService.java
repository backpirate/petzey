
package com.pratian.AppointmentService.Service;
 import java.util.List; 
 import com.pratian.AppointmentService.Entities.Symptom; 
 import com.pratian.AppointmentService.Exceptions.SymptomAlreadyExistException;
 import com.pratian.AppointmentService.Exceptions.SymptomNotFoundException;
 
 public interface SymptomService {

	 public List<Symptom> getAllSymptoms() throws SymptomNotFoundException ;//GET

	 public Symptom saveSymptom(Symptom symptom) throws SymptomAlreadyExistException ;//POST
 
	 public Symptom editSymptom(Symptom symptom) throws SymptomNotFoundException;//PUT
 
	 public String deleteSymptom(long id);//DELETE 
 
	 public Symptom getSymptomById(long id) throws SymptomNotFoundException;//GET 

	 public Symptom getSymptomByName(String name);//GET
}
/*package com.pratian.AppointmentService.Service;

import java.util.List;

import com.pratian.AppointmentService.Entities.Symptom;
import com.pratian.AppointmentService.Exceptions.SymptomAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.SymptomNotFoundException;


public interface SymptomService {

    
public List<Symptom> getAllSymptoms() throws SymptomNotFoundException ;//GET

    public Symptom saveSymptom(Symptom Symptom) throws SymptomAlreadyExistException ;//POST

    public Symptom editSymptom(Symptom Symptom) throws SymptomNotFoundException;//PUT

    public String deleteSymptom(long id);//DELETE

    public Symptom getSymptomById(long id) throws SymptomNotFoundException;//GET

    public Symptom getSymptomByName(String name);//GET

    Symptom deleteSymptom(Symptom Symptom) throws SymptomNotFoundException;
}*/