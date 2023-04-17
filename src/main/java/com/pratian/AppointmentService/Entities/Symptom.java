/*
//SYMPTOM ENTITY
package com.pratian.AppointmentService.Entities;
//import java.util.Date;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Symptom {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="Symptom_generator")
//@SequenceGenerator(name="Symptom_generator",sequenceName = "Symptom_seq",allocationSize=50)
private long symptomid;
private String symptomName;
private Date date;
}*/

package com.pratian.AppointmentService.Entities;

import java.util.Date;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType; 
import javax.persistence.Id; 
import javax.persistence.SequenceGenerator; 
import lombok.AllArgsConstructor; 
import lombok.Data; 
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Symptom {
 @Id
 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="Symptom_generator")
 @SequenceGenerator(name="Symptom_generator",sequenceName = "Symptom_seq",allocationSize=50)

 private long symptomid; 
 private String symptomdesc; //Symptom name
 private Date date;
}