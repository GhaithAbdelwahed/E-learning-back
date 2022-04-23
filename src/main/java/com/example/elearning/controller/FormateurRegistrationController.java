package com.example.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.elearning.model.formateur;
import com.example.elearning.services.FormateurRegistrationService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FormateurRegistrationController {
	
	@Autowired
	private FormateurRegistrationService service;
	
	@PostMapping("/registerFormateur")
	@CrossOrigin(origins = "http://localhost:4200")
	public formateur registerApprenant(@RequestBody formateur formateur) throws Exception {
		String tempEmail = formateur.getemail();
		if (tempEmail != null && !"".equals(tempEmail) ) {
			formateur userobj = service.fetchUserByEmail(tempEmail);
			if (userobj != null) {
				throw new Exception("user with "+tempEmail+" is already exist");
			}
		}
		
		formateur userObj = null;
		userObj = service.saveFormateur(formateur);
		return userObj;
	}
	
	@PostMapping("/loginFormateur")
	@CrossOrigin(origins = "http://localhost:4200")
	public formateur loginUser(@RequestBody formateur formateur) throws Exception {
		String tempEmail = formateur.getemail();
		String tempmdp = formateur.getMdp();
		formateur userObj = null;
		if(tempEmail != null && tempmdp != null)
		{
			userObj = service.fetchUserByEmail(tempEmail);
			if(userObj == null) {
				throw new Exception("Bad credential");
			}
		}
		
		
		return userObj;
		
	}

}
