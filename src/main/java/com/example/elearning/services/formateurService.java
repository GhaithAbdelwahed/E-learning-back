package com.example.elearning.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.elearning.model.formateur;
import com.example.elearning.repository.formateurRepository;
import com.example.elearning.repository.formationRepository;

@Service
public class formateurService {
	@Autowired 
	private formateurRepository formateurrepository ;
	
	@Autowired 
	formationRepository formationrepository ;
	
	
	public formateur addformateur (formateur f) {
		return formateurrepository.save(f);
	}
	public formateur updateformateur (formateur f) {
		return formateurrepository.save(f);
	}
	public void deleteformateur (int id) {
		 formateurrepository.deleteById(id);
	}
	public formateur getformateur (int id) {
		return formateurrepository.findById(id).get();
	}
	/*
	public List<formateur>  findallformateur () {
		return formateurrepository.findAll();
}*/
	public List<formateur>  findALL  () {
		return formateurrepository.findAll();
		}
}
