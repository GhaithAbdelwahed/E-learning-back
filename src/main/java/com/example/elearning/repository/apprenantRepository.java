package com.example.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.elearning.model.apprenant;

@Repository
public interface apprenantRepository  extends JpaRepository<apprenant, Integer > {

}
