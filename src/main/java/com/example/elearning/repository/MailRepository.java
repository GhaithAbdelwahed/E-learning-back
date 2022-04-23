package com.example.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.elearning.model.Mail;


public interface MailRepository extends JpaRepository<Mail,Long>{

}
