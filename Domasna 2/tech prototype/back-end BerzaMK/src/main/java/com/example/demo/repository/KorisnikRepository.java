package com.example.demo.repository;

import com.example.demo.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
}
