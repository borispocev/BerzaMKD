package com.example.demo.service;

import com.example.demo.exceptions.ClientNotFoundException;
import com.example.demo.model.Korisnik;
import com.example.demo.repository.KorisnikRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KorisnikServiceImpl implements KorisnikService{
    private final KorisnikRepository korisnikRepository;

    public KorisnikServiceImpl(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

    @Override
    public List<Korisnik> findAll() {
        System.out.println(korisnikRepository.findAll());
        return korisnikRepository.findAll();
    }

    @Override
    public Korisnik findById(Long id) throws ClientNotFoundException {
        Optional<Korisnik> korisnik = korisnikRepository.findById(id);
        if (korisnik.isEmpty()){
            throw new ClientNotFoundException();
        }
        else{
            return korisnik.get();
        }
    }

    @Override
    public Korisnik update(Long id, Korisnik korisnikDetails) {
        Korisnik korisnik = korisnikRepository.findById(id).orElseThrow(ClientNotFoundException::new);

        korisnik.setEmail(korisnikDetails.getEmail());
        korisnik.setUsername(korisnikDetails.getUsername());
        korisnik.setAge(korisnikDetails.getAge());

        return korisnikRepository.save(korisnik);
    }

    @Override
    public void delete(Long id) {
        korisnikRepository.deleteById(id);
    }

    @Override
    public Korisnik save(Korisnik korisnik) {
        return korisnikRepository.save(korisnik);
    }
}
