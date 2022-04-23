package com.example.elearning.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.elearning.exception.ResourceNotFoundException;
import com.example.elearning.model.apprenant;
import com.example.elearning.model.formateur;
import com.example.elearning.model.formation;
import com.example.elearning.repository.apprenantRepository;
import com.example.elearning.services.ApprenantRegistrationService;
import com.example.elearning.services.apprenantService;
import com.example.elearning.services.formationService;
import com.example.elearning.services.ApprenantRegistrationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class apprenantController {
	@Autowired
	private apprenantRepository apprenantRepository;
	@Autowired
	private formationService formationservice;
	
	@Autowired
	private apprenantService apprenantservice;
	 @GetMapping("/apprenant")
	 public List<apprenant> getAllApprenants(){
		 return apprenantRepository.findAll();
	 }

	 // create apprenant rest api
		@PostMapping("/apprenant")
		public apprenant createApprenant(@RequestBody apprenant apprenant) {
			return apprenantRepository.save(apprenant);
		}
	
		// get apprenant by id rest api
		@GetMapping("/apprenant/{id}")
		public ResponseEntity<apprenant> getApprenantById(@PathVariable int id) {
			apprenant apprenant = apprenantRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Apprenant not exist with id:"+id));
			return ResponseEntity.ok(apprenant);
			
		}
		//uupdate
		@PutMapping("/apprenant/{id}")
		public ResponseEntity<apprenant> updateApprenant(@PathVariable int id, @RequestBody apprenant apprenantDetails){
			apprenant apprenant = apprenantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("apprenant not exist with:" + id));
			apprenant.setPrenom(apprenantDetails.getPrenom());
			apprenant.setNom(apprenantDetails.getNom());
			apprenant.setemail(apprenantDetails.getemail());
			apprenant.setMdp(apprenantDetails.getMdp());
			
			apprenant updatedApprenant = apprenantRepository.save(apprenant);
			return ResponseEntity.ok(updatedApprenant);
		}
		
		// delete employee rest api
				@DeleteMapping("/apprenant/{id}")
				public ResponseEntity<Map<String, Boolean>> deleteApprenant(@PathVariable int id){
					apprenant apprenant = apprenantRepository.findById(id)
							.orElseThrow(() -> new ResourceNotFoundException("Apprenant not exist with id :" + id));
					
					apprenantRepository.delete(apprenant);
					Map<String, Boolean> response = new HashMap<>();
					response.put("deleted", Boolean.TRUE);
					return ResponseEntity.ok(response);
				}
				
				@PutMapping("/apprenant/{id}/{Id}")
				
				public apprenant addapprenant(@RequestBody apprenant apprenant ,@PathVariable int id , @PathVariable int Id) {
					List<formation> formations=new ArrayList();
					formations=apprenant.getFormations();
					
					formation formation=formationservice.findbyId(Id);
					formations.add(formation);
					apprenant.setFormations(formations);
					
					return this.apprenantservice.addapprenant(apprenant);
					}
}
