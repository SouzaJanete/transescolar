package com.example.transescolar.controller;


import com.example.transescolar.model.Turno;
import com.example.transescolar.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @GetMapping("/{id}")
    public ResponseEntity<Turno> getTurnoById(@PathVariable Long id) {
        Optional<Turno> turno = turnoService.findById(id);
        if (turno.isPresent()) {
            return ResponseEntity.ok(turno.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Turno createTurno(@RequestBody Turno turno) {
        return turnoService.save(turno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turno> updateTurno(@PathVariable Long id, @RequestBody Turno turnoDetails) {
        Optional<Turno> turno = turnoService.findById(id);
        if (turno.isPresent()) {
            Turno updatedTurno = turno.get();
            updatedTurno.setNome(turnoDetails.getNome());
            return ResponseEntity.ok(turnoService.save(updatedTurno));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTurno(@PathVariable Long id) {
        Optional<Turno> turno = turnoService.findById(id);
        if (turno.isPresent()) {
            turnoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }
    }
