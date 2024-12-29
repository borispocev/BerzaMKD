package com.example.demo.controller;

import com.example.demo.model.Analiza;
import com.example.demo.model.Kompanija;
import com.example.demo.service.AnalizaService;
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
@RequestMapping(value = "/api3")
public class AnalizaController {
    private final AnalizaService analizaService;

    public AnalizaController(AnalizaService analizaService) {
        this.analizaService = analizaService;
    }
    @GetMapping(value = "/allComapny")
    public ResponseEntity<List<Analiza>> getAllClients(){
        List<Analiza> companys = this.analizaService.findAllCompanyByName("data_frame_ALK");
        return new ResponseEntity<>(companys, HttpStatus.OK);
    }
}
