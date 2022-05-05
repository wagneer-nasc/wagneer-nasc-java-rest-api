package com.challengeinc.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challengeinc.challenge.models.Desejo;

@Repository
public interface DesejoRepository extends JpaRepository<Desejo, Long> {
 
}
