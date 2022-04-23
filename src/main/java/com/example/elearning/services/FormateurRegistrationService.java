package com.example.elearning.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.elearning.model.formateur;
import com.example.elearning.repository.FormateurRegistrationRepository;

@Service
public class FormateurRegistrationService {
	
	@Autowired
	private FormateurRegistrationRepository repo;
	public formateur saveFormateur(formateur formateur) {
		
		return repo.save(formateur);
	}
	
	public formateur fetchUserByEmail(String email) {
		return repo.findByEmail(email);
	}

}
