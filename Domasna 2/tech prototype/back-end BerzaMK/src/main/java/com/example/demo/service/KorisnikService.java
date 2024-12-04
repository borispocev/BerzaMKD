package com.example.demo.service;

import com.example.demo.exceptions.ClientNotFoundException;
import com.example.demo.model.Korisnik;

import java.util.List;
import java.util.Optional;

public interface KorisnikService {
    List<Korisnik> findAll();
    Korisnik findById(Long id) throws ClientNotFoundException;

    Korisnik update(Long id, Korisnik korisnikDetails);

    void delete(Long id);

    Korisnik save(Korisnik korisnik);
}
