   package com.pratian.AppointmentService.Controller;
   
   import org.springframework.beans.factory.annotation.Autowired; 
   import org.springframework.http.HttpStatus; 
   import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping; 
   import org.springframework.web.bind.annotation.GetMapping; 
   import org.springframework.web.bind.annotation.PathVariable; 
   import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody; 
   import org.springframework.web.bind.annotation.RequestMapping; 
   import org.springframework.web.bind.annotation.RestController;
   
   import com.pratian.AppointmentService.Entities.Symptom;
import com.pratian.AppointmentService.Entities.Vital;
import com.pratian.AppointmentService.Exceptions.SymptomAlreadyExistException;
   import com.pratian.AppointmentService.Exceptions.SymptomNotFoundException;
import com.pratian.AppointmentService.Exceptions.VitalNotFoundException;
import com.pratian.AppointmentService.Service.SymptomService;
   
@CrossOrigin(origins= "http://localhost:3000")
   @RestController
   @RequestMapping("/symptoms") 
   public class SymptomController {
   
	   @Autowired 
	   private SymptomService service;
   
	   @GetMapping("/getsymptom") 
	   public ResponseEntity<?> get(){ 
		   ResponseEntity<?> response = null;
		   try { response = new ResponseEntity<>(service.getAllSymptoms(), HttpStatus.OK); 
		   }
		   catch(SymptomNotFoundException s) 
		   {
			   response = new ResponseEntity<>(s.getMessage(), HttpStatus.OK);
		   }
		   return response; 
		   
	   }
   
   @PostMapping("/postsymptom")
   public ResponseEntity<?> post(@RequestBody Symptom symptom1)
   {
	   ResponseEntity<?> response = null; 
	   try {
		   response = new ResponseEntity<>(service.saveSymptom(symptom1), HttpStatus.OK); 
		   }
	   catch(SymptomAlreadyExistException s) 
	   { 
		   response = new ResponseEntity<>(s.getMessage(), HttpStatus.OK);
	   }
	   return response;
	   }
   
   //@RequestMapping(value="/appointments",method = RequestMethod.GET)//OR
   
   @GetMapping("/{id}") 
   public ResponseEntity<?> getById(@PathVariable (value ="id") long id){
	   ResponseEntity<?> response = null; 
	   try {
		response = new ResponseEntity<>(service.getSymptomById(id), HttpStatus.OK);
	} catch (SymptomNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return response;
   }
   
   @PutMapping("/edit")
	public ResponseEntity<?> put(@RequestBody Symptom editSymptom){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.editSymptom(editSymptom), HttpStatus.OK);
		} catch (SymptomNotFoundException e) {
			  response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
   
   
   @DeleteMapping("/delete/{id}") 
   public ResponseEntity<?> delete(@PathVariable(value = "id") long id)
   {
	   ResponseEntity<?> response = null; 
	   response = new ResponseEntity<>(service.deleteSymptom(id), HttpStatus.OK);
	   return response;
   } 
   
}