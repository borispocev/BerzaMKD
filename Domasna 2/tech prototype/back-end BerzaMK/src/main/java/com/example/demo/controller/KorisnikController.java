package com.example.demo.controller;

import com.example.demo.exceptions.ClientNotFoundException;
import com.example.demo.model.Korisnik;
import com.example.demo.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin("http://localhost:3000")
@RestController
@Validated
@RequestMapping(value = "/api")
public class KorisnikController  {
    public final KorisnikService korisnikService;

    public KorisnikController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }
    @GetMapping(value = "/all")
    public ResponseEntity<List<Korisnik>> getAllClients(){
        List<Korisnik> clients = korisnikService.findAll();
        return new ResponseEntity<>(clients, HttpStatus.FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Korisnik> getClientById(@PathVariable(value = "id") Long id) throws ClientNotFoundException {
        Korisnik client = korisnikService.findById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Korisnik> addClient(@RequestBody Korisnik korisnik) {
        Korisnik savedKorisnik = korisnikService.save(korisnik);
        return new ResponseEntity<>(savedKorisnik, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Korisnik> updateClient(@PathVariable Long id, @RequestBody Korisnik korisnikDetails) {
        Korisnik updatedKorisnik = korisnikService.update(id, korisnikDetails);
        return new ResponseEntity<>(updatedKorisnik, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        korisnikService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
