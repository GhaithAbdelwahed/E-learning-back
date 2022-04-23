package com.example.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.elearning.model.admin;

@Repository
public interface adminRepository  extends JpaRepository<admin, Integer > {

}
