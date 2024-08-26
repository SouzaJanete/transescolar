package com.example.transescolar.service;


import com.example.transescolar.model.Serie;
import com.example.transescolar.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;

    public List<Serie> findAll() {
        return serieRepository.findAll();
    }

    public Optional<Serie> findById(Long id) {
        return serieRepository.findById(id);
    }

    public Serie save(Serie serie) {
        return serieRepository.save(serie);
    }

    public void deleteById(Long id) {
        serieRepository.deleteById(id);
    }
}
