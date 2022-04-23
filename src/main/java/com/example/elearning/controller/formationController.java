package com.example.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
import com.example.elearning.model.formation;
import com.example.elearning.repository.formationRepository;
import com.example.elearning.services.formateurService;
import com.example.elearning.services.formationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class formationController {
	
@Autowired
private formationService formationservice;
@Autowired
private formationRepository formationrepository;

@Autowired
private formateurService formateurservice;
	
	/*
	@GetMapping("/formation")
	public ResponseEntity<List<formation>> getAllformation(){
		List<formation> formations = formationservice.getallformation ();
		return new ResponseEntity<>(formations,HttpStatus.OK);
	}
	
	@GetMapping("/formation/{id}")
	public ResponseEntity<formation> getformationByID(@PathVariable("id") int id){
		formation formation = formationservice.getformation(id);
		return new ResponseEntity<>(formation,HttpStatus.OK);
	}
	
	@PostMapping("/formation")
	public ResponseEntity<formation> addformation(@RequestBody formation formation){
		formation newformation =formationservice.addformation (formation );
		return new ResponseEntity<>(newformation,HttpStatus.CREATED);
	}
	
	
	@PostMapping("/formation/{id}")
	public ResponseEntity<formation> updateformation(@RequestBody formation formation){
		formation updateformation =formationservice.updateformation (formation );
		return new ResponseEntity<>(updateformation,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/formation/{id}")
	public ResponseEntity<?> deleteformation(@PathVariable("id") int id){
		formationservice.deleteformation (id );
		return new ResponseEntity<>(HttpStatus.OK);
	}*/

	@GetMapping("/formation")
	public ResponseEntity<List<formation>> listeFormation(){
	
		return new ResponseEntity<>(formationservice.findALL(),HttpStatus.OK);
	}
	
	@GetMapping("/formation/{id}")
	public ResponseEntity<formation> getformationByID(@PathVariable("id") int id){
		formation formation = formationservice.findbyId(id);
		return new ResponseEntity<>(formation,HttpStatus.OK);
	}
	
	@GetMapping("/formateurs")
	public ResponseEntity<List<formateur>> listeFormateurs(){
	
		return new ResponseEntity<>(formateurservice.findALL(),HttpStatus.OK);
	}

	@PostMapping("/formation")
	public ResponseEntity<formation> createFormation(@RequestBody formation formation){
		return new ResponseEntity<>(formationservice.save(formation),HttpStatus.CREATED);
	}
	
	
	@PutMapping("/formation/{id}")
	public ResponseEntity<formation> updateFormation(@PathVariable int id , @RequestBody formation formationDetails)
	{	
		formation formation = formationrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Session not exist with:" + id));
		formation.setFormationName(formationDetails.getFormationName());
		formation.setDate_debut(formationDetails.getDate_debut());
		formation.setDate_fin(formationDetails.getDate_fin());
		
		formation updatedformation = formationrepository.save(formation);
		return ResponseEntity.ok(updatedformation);
	}
	
	@DeleteMapping("/formation/{id}")
	public ResponseEntity<?> deleteformation(@PathVariable int id){
		formationservice.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
}

