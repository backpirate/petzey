package com.pratian.AppointmentService.Service;

import java.util.List;

import com.pratian.AppointmentService.Entities.PetParent;
import com.pratian.AppointmentService.Exceptions.PetParentAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.PetParentNotFoundException;

public interface PetParentService {
	
public List<PetParent> getAllPetParents() throws PetParentNotFoundException ;//GET
	
	public PetParent savePetParent(PetParent pet) throws PetParentAlreadyExistException ;//POST
	
	public PetParent editPetParent(PetParent pet) throws PetParentNotFoundException;//PUT
	
	public String deletePetParent(long id) throws PetParentNotFoundException;//DELETE
	
	public PetParent getPetParentById(long id) throws PetParentNotFoundException;//GET
	
	public PetParent getPetParentByName(String name) throws PetParentNotFoundException;//GET


}
