package com.example.elearning.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="apprenant")
public class apprenant extends utilisateur {
@ManyToMany( cascade = CascadeType.ALL,mappedBy = "apprenants",fetch = FetchType.EAGER)
	
	private List<formation> formations=new ArrayList<>() ;
	
	public void addformation(formation formation) {
		formations.add(formation);
	}

public List<formation> getFormations() {
	return formations;
}

public void setFormations(List<formation> formations) {
	this.formations = formations;
}

public apprenant(List<formation> formations) {
	super();
	this.formations = formations;
}
public apprenant() {}
}
