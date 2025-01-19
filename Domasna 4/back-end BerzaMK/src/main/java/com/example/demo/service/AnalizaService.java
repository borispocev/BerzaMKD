package com.example.demo.service;


import com.example.demo.model.Analiza;
import com.example.demo.model.Kompanija;

import java.util.List;

public interface AnalizaService {
    List<Analiza> findAllCompanyByName(String comapnyName);
    List<Analiza> getAllComapnies();

    List<Analiza> getDataByCompanyAndDateRange(String companyName, String startDate, String endDate);

    List<String> getComapnyNames();
}
