package com.example.demo.controller;

import com.example.demo.model.Kompanija;
import com.example.demo.model.Korisnik;
import com.example.demo.service.KompanijaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@CrossOrigin("http://localhost:3000")
@RestController
@Validated
@RequestMapping(value = "/api2")
public class KompanijaController {
    private final KompanijaService kompanijaService;

    public KompanijaController(KompanijaService kompanijaService) {
        this.kompanijaService = kompanijaService;
    }

    @GetMapping(value = "/allComapny")
    public ResponseEntity<List<Kompanija>> getAllClients(){
        List<Kompanija> companys = this.kompanijaService.findAllCompanyByName("ALK");
        return new ResponseEntity<>(companys, HttpStatus.OK);
    }

    @GetMapping(value = "/companyName")
    public ResponseEntity<List<String>> getCompnayName(){
        List<String> companys = this.kompanijaService.findCompanyByName();
        return new ResponseEntity<>(companys, HttpStatus.OK);
    }
}
