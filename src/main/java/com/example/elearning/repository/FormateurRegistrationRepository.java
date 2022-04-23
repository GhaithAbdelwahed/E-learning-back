package com.example.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.elearning.model.formateur;

public interface FormateurRegistrationRepository extends JpaRepository<formateur, Integer>{

	public formateur findByEmail(String email);
}
