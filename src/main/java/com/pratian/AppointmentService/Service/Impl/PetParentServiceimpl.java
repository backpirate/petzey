package com.pratian.AppointmentService.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pratian.AppointmentService.Entities.PetParent;
import com.pratian.AppointmentService.Exceptions.PetParentAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.PetParentNotFoundException;
import com.pratian.AppointmentService.Repository.PetParentRepository;
import com.pratian.AppointmentService.Service.PetParentService;

@Service
public class PetParentServiceimpl implements PetParentService{

	@Autowired
	private PetParentRepository petParentRepo;

	@Override
	public List<PetParent> getAllPetParents() throws PetParentNotFoundException{
		List<PetParent> petParents = petParentRepo.getPetParents();
		if(petParents.isEmpty()) {
			throw new PetParentNotFoundException("PetParent list is empty.");
		}
		
		return petParents;
	}

	@Override
	public PetParent savePetParent(PetParent petParent0) throws PetParentAlreadyExistException{
		PetParent petParent2 = null;
		if(petParentRepo.existsById(petParent0.getPetparentid()))
		{
			throw new PetParentAlreadyExistException ("PetParent already exist.");
		}
		else {
			petParent2 = petParentRepo.save(petParent0);
		}
		return petParent2;
	}

	@Override
	public PetParent editPetParent(PetParent pet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletePetParent(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PetParent getPetParentById(long id) throws PetParentNotFoundException{
		PetParent petparent = petParentRepo.findById(id).get();
		// TODO Auto-generated method stub
		return petparent;
	}

	@Override
	public PetParent getPetParentByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
