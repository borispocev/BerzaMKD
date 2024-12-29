package com.example.demo.service;

import com.example.demo.model.Analiza;
import com.example.demo.repository.AnalizaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalizaServiceImpl implements AnalizaService{
    private final AnalizaRepository analizaRepository;

    public AnalizaServiceImpl(AnalizaRepository analizaRepository) {
        this.analizaRepository = analizaRepository;
    }

    @Override
    public List<Analiza> findAllCompanyByName(String comapnyName) {
        return this.analizaRepository.findAll().stream().filter(el -> el.getCompany_name().equals(comapnyName)).limit(20).toList();
    }
}
