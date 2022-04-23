package com.example.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.example.elearning.model.formateur;
import com.example.elearning.repository.formateurRepository;
import com.example.elearning.repository.formationRepository;
import com.example.elearning.services.formateurService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class formateurController {
	
	@Autowired
	private formateurService formateurservice;
	
	@Autowired
	private formateurRepository formateurrepository;
	
	@Autowired
	private formationRepository formationrepository;
	/*
	@PostMapping("/inputList")
	public formateur inputFormation(@RequestBody InputRequest request) {
		return formateurrepository.save(request.getFormateur());
	}*/
	
	@GetMapping("/findAllFormations")
	public List<formateur> findAllFormations(){
		return formateurrepository.findAll();
	}
	
	@GetMapping("/formateur")
	public ResponseEntity<List<formateur>> getAllformateur(){
		List<formateur> formateurs = formateurservice.findALL();
		return new ResponseEntity<>(formateurs,HttpStatus.OK);
	}
	
	@GetMapping("/formateur/{id}")
	public ResponseEntity<formateur> getformateurByID(@PathVariable("id") int id){
		formateur formateur = formateurservice.getformateur(id);
		return new ResponseEntity<>(formateur,HttpStatus.OK);
	}
	
	@PostMapping("/formateur")
	public ResponseEntity<formateur> addformateur(@RequestBody formateur formateur){
		formateur newformateur =formateurservice.addformateur (formateur );
		return new ResponseEntity<>(newformateur,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/formateur/{id}")
	public ResponseEntity<formateur> updateFormateur(@PathVariable int id, @RequestBody formateur formateurDetails){
		formateur formateur = formateurrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trainers not exist with:" + id));
		formateur.setPrenom(formateurDetails.getPrenom());
		formateur.setNom(formateurDetails.getNom());
		formateur.setemail(formateurDetails.getemail());
		formateur.setMdp(formateurDetails.getMdp());
		
		formateur updatedformateur = formateurrepository.save(formateur);
		return ResponseEntity.ok(updatedformateur);
	}
	
	
	@DeleteMapping("/formateur/{id}")
	public ResponseEntity<?> deleteformateur(@PathVariable("id") int id){
		formateurservice.deleteformateur (id );
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	




}
