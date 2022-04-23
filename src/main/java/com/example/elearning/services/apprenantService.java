package com.example.elearning.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.elearning.model.apprenant;
import com.example.elearning.model.formateur;
import com.example.elearning.repository.apprenantRepository;
import com.example.elearning.repository.formateurRepository;
import com.example.elearning.repository.formationRepository;

@Service
public class apprenantService {
	@Autowired 
	private apprenantRepository apprenantrepository ;
	
	@Autowired 
	formationRepository formationrepository ;
	
	
	public apprenant addapprenant(apprenant a) {
		return apprenantrepository.save(a);
	}
	public apprenant updateApprenant (apprenant a) {
		return apprenantrepository.save(a);
	}
	/**
	public void deleteformateur (int id) {
		 formateurrepository.deleteById(id);
	}
	public formateur getformateur (int id) {
		return formateurrepository.findById(id).get();
	}*/

}
