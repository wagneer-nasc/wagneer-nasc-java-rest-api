package com.challengeinc.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challengeinc.challenge.models.Filme;

public interface FilmeRepository extends JpaRepository<Filme, String> {
}
