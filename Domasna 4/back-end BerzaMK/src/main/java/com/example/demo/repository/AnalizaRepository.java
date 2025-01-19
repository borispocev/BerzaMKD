package com.example.demo.repository;

import com.example.demo.model.Analiza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalizaRepository extends JpaRepository<Analiza, Integer> {
}
