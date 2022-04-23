package com.example.elearning.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.example.elearning.model.apprenant;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
//@Table(name="formation")
public class formation {
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="formateur_id")
	private formateur formateur;
	public formation(int id, com.example.elearning.model.formateur formateur) {
		super();
		this.id = id;
		this.formateur = formateur;
	}
	
	public formation() {}*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fid;
	private String formationName;
	private Date date_debut;
	private Date date_fin;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "id_formateur")
	private formateur Formateur;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="inscription",
	joinColumns=
	@JoinColumn(name="formation_id"),
	inverseJoinColumns=@JoinColumn(name="apprenant_id"))
	@JsonIgnore
	private List<apprenant> apprenants = new ArrayList<>();
	
	public formation(int fid, String formationName, Date date_debut, Date date_fin, formateur formateur,
			List<apprenant> apprenants) {
		super();
		this.fid = fid;
		this.formationName = formationName;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		Formateur = formateur;
		this.apprenants = apprenants;
	}

	public List<apprenant> getApprenants() {
		return apprenants;
	}

	public void setApprenants(List<apprenant> apprenants) {
		this.apprenants = apprenants;
	}
	
	public formateur getFormateur() {
		return Formateur;
	}
	public void setFormateur(formateur formateur) {
		Formateur = formateur;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFormationName() {
		return formationName;
	}
	public void setFormationName(String formationName) {
		this.formationName = formationName;
	}
	@Override
	public String toString() {
		return "formation [fid=" + fid + ", formationName=" + formationName + ", date_debut=" + date_debut
				+ ", date_fin=" + date_fin + ", Formateur=" + Formateur + "]";
	}
	public formation(int fid, String formationName) {
		super();
		this.fid = fid;
		this.formationName = formationName;
	}
	public formation() {}
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	
	
} 
