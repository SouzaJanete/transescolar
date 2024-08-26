package com.example.transescolar.controller;

import com.example.transescolar.model.Responsavel;
import com.example.transescolar.service.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/responsaveis")
public class ResponsavelController {

    @Autowired
    private ResponsavelService responsavelService;

    @GetMapping
    public List<Responsavel> listarTodos() {
        return responsavelService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Responsavel> buscarPorId(@PathVariable Long id) {
        Responsavel responsavel = responsavelService.buscarPorId(id);
        return responsavel != null ? ResponseEntity.ok(responsavel) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Responsavel salvar(@RequestBody Responsavel responsavel) {
        return responsavelService.salvar(responsavel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id) {
        responsavelService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}

