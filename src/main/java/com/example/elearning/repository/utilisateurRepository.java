package com.example.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.elearning.model.utilisateur;

@Repository
public interface utilisateurRepository extends JpaRepository<utilisateur, Integer > {

}
