package com.example.demo.service;


import com.example.demo.model.Analiza;
import com.example.demo.model.Kompanija;

import java.util.List;

public interface AnalizaService {
    List<Analiza> findAllCompanyByName(String comapnyName);
}
