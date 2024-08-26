package com.example.transescolar.controller;


import com.example.transescolar.model.Serie;
import com.example.transescolar.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/series")
public class SerieController {

    @Autowired
    private SerieService serieService;

    @GetMapping
    public List<Serie> getAllSeries() {
        return serieService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Serie> getSerieById(@PathVariable Long id) {
        Optional<Serie> serie = serieService.findById(id);
        if (serie.isPresent()) {
            return ResponseEntity.ok(serie.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Serie createSerie(@RequestBody Serie serie) {
        return serieService.save(serie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Serie> updateSerie(@PathVariable Long id, @RequestBody Serie serieDetails) {
        Optional<Serie> serie = serieService.findById(id);
        if (serie.isPresent()) {
            Serie updatedSerie = serie.get();
            updatedSerie.setNome(serieDetails.getNome());
            return ResponseEntity.ok(serieService.save(updatedSerie));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSerie(@PathVariable Long id) {
        Optional<Serie> serie = serieService.findById(id);
        if (serie.isPresent()) {
            serieService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
