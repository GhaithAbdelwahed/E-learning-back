package com.example.elearning.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="email")
public class Mail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String destinataire;
	private String objet;
	private String message;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDestinataire() {
		return destinataire;
	}
	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Mail(long id, String destinataire, String objet, String message) {
		super();
		this.id = id;
		this.destinataire = destinataire;
		this.objet = objet;
		this.message = message;
	}
	@Override
	public String toString() {
		return "Mail [id=" + id + ", destinataire=" + destinataire + ", objet=" + objet + ", message=" + message + "]";
	}
	public Mail() {
		super();
		// TODO Auto-generated constructor stub
	}

}
