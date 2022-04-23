package com.example.elearning.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.elearning.model.apprenant;
import com.example.elearning.model.formation;
import com.example.elearning.repository.ApprenantRegistrationRepository;
import com.example.elearning.repository.apprenantRepository;


@Service
public class ApprenantRegistrationService {
	
	@Autowired
	private ApprenantRegistrationRepository repo;
	public apprenant saveApprenant(apprenant apprenant) {
		
		return repo.save(apprenant);
	
	}
	
	public apprenant fetchUserByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	public apprenant findbyId (int id) {
		return repo.findById(id).orElse(null);
	}
	
	public apprenant save(apprenant Apprenant) {
		return repo.save(Apprenant);
	}
	
	/*public apprenant fetchUserByEmailAndPassword(String email, String mdp) {
		return repo.findByEmailetpassword(email, mdp);
	
	}*/

}
