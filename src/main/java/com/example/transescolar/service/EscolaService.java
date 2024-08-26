package com.example.transescolar.service;


import com.example.transescolar.model.Escola;
import com.example.transescolar.repository.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EscolaService {

    @Autowired
    private EscolaRepository escolaRepository;

    public List<Escola> findAll() {
        return escolaRepository.findAll();
    }

    public Optional<Escola> findById(Long id) {
        return escolaRepository.findById(id);
    }

    public Escola save(Escola escola) {
        return escolaRepository.save(escola);
    }

    public void deleteById(Long id) {
        escolaRepository.deleteById(id);
    }
}
