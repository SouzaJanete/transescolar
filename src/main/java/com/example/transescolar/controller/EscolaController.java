package com.example.transescolar.controller;

import com.example.transescolar.model.Escola;
import com.example.transescolar.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/escolas")
public class EscolaController {

    @Autowired
    private EscolaService escolaService;

    @GetMapping
    public List<Escola> getAllEscolas() {
        return escolaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Escola> getEscolaById(@PathVariable Long id) {
        Optional<Escola> escola = escolaService.findById(id);
        if (escola.isPresent()) {
            return ResponseEntity.ok(escola.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Escola createEscola(@RequestBody Escola escola) {
        return escolaService.save(escola);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Escola> updateEscola(@PathVariable Long id, @RequestBody Escola escolaDetails) {
        Optional<Escola> escola = escolaService.findById(id);
        if (escola.isPresent()) {
            Escola updatedEscola = escola.get();
            updatedEscola.setNome(escolaDetails.getNome());
            updatedEscola.setEndereco(escolaDetails.getEndereco());
            return ResponseEntity.ok(escolaService.save(updatedEscola));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEscola(@PathVariable Long id) {
        escolaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
