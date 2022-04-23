package com.example.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.elearning.model.formateur;
@Repository
public interface formateurRepository extends JpaRepository<formateur,Integer> {

}
