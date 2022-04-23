package com.example.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.elearning.model.apprenant;
import com.example.elearning.services.ApprenantRegistrationService;

@RestController
public class ApprenantRegistrationController {
	@Autowired
	private ApprenantRegistrationService service;
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins = "http://localhost:4200")
	public apprenant registerApprenant(@RequestBody apprenant apprenant) throws Exception {
		String tempEmail = apprenant.getemail();
		if (tempEmail != null && !"".equals(tempEmail) ) {
			apprenant userobj = service.fetchUserByEmail(tempEmail);
			if (userobj != null) {
				throw new Exception("user with "+tempEmail+" is already exist");
			}
		}
		
		apprenant userObj = null;
		userObj = service.saveApprenant(apprenant);
		return userObj;
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public apprenant loginUser(@RequestBody apprenant apprenant) throws Exception {
		String tempEmail = apprenant.getemail();
		String tempmdp = apprenant.getMdp();
		apprenant userObj = null;
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
