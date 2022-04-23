package com.example.elearning.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.elearning.model.formation;
import com.example.elearning.repository.formationRepository;
@Service

public class formationService {
/*@Autowired
private formationRepository formationrepository;

public formation addformation (formation f) {
	return formationrepository.save(f);
}
public formation updateformation (formation f) {
	return formationrepository.save(f);
}
public void deleteformation (int id) {
	 formationrepository.deleteById(id);
}

public formation getformation (int id) {
	return formationrepository.findById(id).get();
}

public List<formation>  getallformation () {
	return formationrepository.findAll();
}*/
	@Autowired
	private formationRepository formationrepository;
	
	public formation save(formation Formation) {
		return formationrepository.save(Formation);
	}
	
	public formation findbyId (int id) {
		return formationrepository.findById(id).orElse(null);
	}

	public List<formation>  findALL () {
		return formationrepository.findAll();
	}
	
	public void delete (int id) {
		 formationrepository.deleteById(id);
	}
}
