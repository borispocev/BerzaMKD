package com.example.demo.controller;

import com.example.demo.model.Analiza;
import com.example.demo.model.Kompanija;
import com.example.demo.service.AnalizaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
        List<Analiza> companys = this.analizaService.getAllComapnies();
        return new ResponseEntity<>(companys, HttpStatus.OK);
    }

    @GetMapping(value = "/getComapnyNames")
    public ResponseEntity<List<String>> getCompanyNames(){
        List<String> companys = this.analizaService.getComapnyNames();
        return new ResponseEntity<>(companys, HttpStatus.OK);
    }

    @GetMapping(value = "/getData")
    public ResponseEntity<List<Analiza>> getData(@RequestParam String companyName,
                                                 @RequestParam String startDate,
                                                 @RequestParam String endDate) {
        List<Analiza> companyData = this.analizaService.getDataByCompanyAndDateRange(companyName, startDate, endDate);
        return new ResponseEntity<>(companyData, HttpStatus.OK);
    }

}
