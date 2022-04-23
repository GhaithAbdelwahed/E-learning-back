package com.example.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.elearning.model.apprenant;
@Repository
public interface ApprenantRegistrationRepository extends JpaRepository<apprenant, Integer> {

	//public apprenant findByEmailAndPassword(String email, String mdp);
	public apprenant findByEmail(String email);
	//public apprenant findByEmailetpassword(String email,String mdp);
	
	


	
	
	

	

//	public utilisateur findByEmailAndPassword(String email, String mdp);
	

}
