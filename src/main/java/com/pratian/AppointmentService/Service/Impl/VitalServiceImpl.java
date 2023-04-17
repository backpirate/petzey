package com.pratian.AppointmentService.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratian.AppointmentService.Entities.Feedback;
import com.pratian.AppointmentService.Entities.Vital;
import com.pratian.AppointmentService.Exceptions.VitalAlreadyExistException;
import com.pratian.AppointmentService.Exceptions.VitalNotFoundException;
import com.pratian.AppointmentService.Repository.VitalRepository;
import com.pratian.AppointmentService.Service.VitalService;

@Service
public class VitalServiceImpl implements VitalService{

	@Autowired
	private VitalRepository vitalRepo;
	
	@Override
	public List<Vital> getAllVitals() throws VitalNotFoundException {
		List<Vital> vitals = vitalRepo.getVitals();
		if(vitals.isEmpty()) {
			throw new VitalNotFoundException("Vital list is empty.");
		}
		
		return vitals;
	}

	@Override
	public Vital saveVital(Vital vital0) throws VitalAlreadyExistException {
		Vital vital2 = null;
		if(vitalRepo.existsById(vital0.getVitalsId()))
		{
			throw new VitalAlreadyExistException ("Vital already exist.");
		}
		else {
			vital2 = vitalRepo.save(vital0);
		}
		return vital2;
	}

	@Override
	public Vital editVital(Vital vital) throws VitalNotFoundException {
		Vital v=null;
		if(vitalRepo.existsById(vital.getVitalsId())) {
			v=vitalRepo.findById(vital.getVitalsId()).get();
			v.setHeartBeat(vital.getHeartBeat());
			v.setTemp(vital.getTemp());
			v.setBp(vital.getBp());
			v.setLungsbpm(vital.getLungsbpm());
			vitalRepo.save(v);
		}
       
        else{
           throw new VitalNotFoundException();
        }

		return v;
	}

	@Override
	public String deleteVital(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vital getVitalById(long id){
		Vital vital = vitalRepo.findById(id).get();

		return vital;
	}

	@Override
	public Vital getVitalByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
