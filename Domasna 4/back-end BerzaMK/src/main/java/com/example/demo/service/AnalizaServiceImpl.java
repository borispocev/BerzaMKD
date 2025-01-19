package com.example.demo.service;

import com.example.demo.model.Analiza;
import com.example.demo.model.Kompanija;
import com.example.demo.repository.AnalizaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    @Override
    public List<Analiza> getAllComapnies() {
        return this.analizaRepository.findAll();
    }

    @Override
    public List<Analiza> getDataByCompanyAndDateRange(String companyName, String startDate, String endDate) {
        String correctName = "data_frame_" + companyName;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);
        return this.analizaRepository.findAll().stream().filter(el -> el.getCompany_name().equals(correctName) && el.getDateAsLocalDate().isAfter(start) && el.getDateAsLocalDate().isBefore(end)).toList();
    }

    @Override
    public List<String> getComapnyNames() {
        return this.analizaRepository.findAll().stream().map(Analiza::getCompany_name).distinct().toList();

    }
}
