package com.pratian.AppointmentService.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class PetParent {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PetParent_generator")
	@SequenceGenerator(name="PetParent_generator", allocationSize=50)
	private long petparentid ; //parentId pet code
	private String location; //address petcode
	private String parentName;
	private int parentMobileNo;
	private String parentEmail; //petcode
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "petparentid")//Pet_Parent_id
	private List<Patient> pets = new ArrayList<>();

}
