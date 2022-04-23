package com.example.elearning.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="formateur")
public class formateur extends utilisateur {
/*	@OneToMany(mappedBy="formateur",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<formation> formations=new ArrayList<>();*/
	
/*	@OneToMany(targetEntity = formation.class ,cascade=CascadeType.ALL)
	@JoinColumn(name = "fc_fk", referencedColumnName = "id")
	private List<formation> formations;
	public formateur(int id, String nom, String prenom, String email, String mdp) {
		super(id, nom, prenom, email, mdp);
		// TODO Auto-generated constructor stub
	}
	
	public formateur() {}
	
	public List<formation> getFormations() {
		return formations;
	}
	public void setFormations(List<formation> formations) {
		this.formations = formations;
	}*/ 
	@OneToMany(mappedBy = "Formateur")
	@JsonIgnore
	private List<formation> formations = new ArrayList<>();
	
	public formateur() {} 
	
	
	
	

}
