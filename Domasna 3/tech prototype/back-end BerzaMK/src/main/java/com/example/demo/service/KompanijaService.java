package com.example.demo.service;

import com.example.demo.model.Kompanija;

import java.util.List;

public interface KompanijaService {

    List<Kompanija> findAllCompanyByName(String comapnyName);

    List<String> findCompanyByName();
}
