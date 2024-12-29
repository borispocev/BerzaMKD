package com.example.demo.service;

import com.example.demo.model.Kompanija;
import com.example.demo.repository.KompanijaRepository;
import org.springframework.stereotype.Service;
import com.example.demo.model.Kompanija;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KompanijaServiceImpl implements KompanijaService{
    private final KompanijaRepository kompanijaRepository;

    public KompanijaServiceImpl(KompanijaRepository kompanijaRepository) {
        this.kompanijaRepository = kompanijaRepository;
    }

    @Override
    public List<Kompanija> findAllCompanyByName(String companyName) {
        List<Kompanija> kompanijaList = this.kompanijaRepository.findAll().stream().filter(el -> el.getCompanyName().equals(companyName)).limit(30).toList();
//        System.out.println(kompanijaList);
        return kompanijaList;
    }

    @Override
    public List<String> findCompanyByName() {
        return this.kompanijaRepository.findAll().stream().map(Kompanija::getCompanyName).distinct().toList();
    }
}
