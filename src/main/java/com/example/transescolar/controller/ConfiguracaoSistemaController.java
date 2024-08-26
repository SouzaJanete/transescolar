package com.example.transescolar.controller;

import com.example.transescolar.model.ConfiguracaoSistema;
import com.example.transescolar.service.ConfiguracaoSistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/configuracoes")
public class ConfiguracaoSistemaController {

    @Autowired
    private ConfiguracaoSistemaService configuracaoSistemaService;

    @GetMapping
    public List<ConfiguracaoSistema> listarTodos() {
        return configuracaoSistemaService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<ConfiguracaoSistema> salvar(@RequestBody ConfiguracaoSistema configuracao) {
        ConfiguracaoSistema configuracaoSalva = configuracaoSistemaService.salvar(configuracao);
        return new ResponseEntity<>(configuracaoSalva, HttpStatus.CREATED);
    }

    @GetMapping("/{chave}")
    public ResponseEntity<ConfiguracaoSistema> buscarPorChave(@PathVariable String chave) {
        Optional<ConfiguracaoSistema> configuracao = configuracaoSistemaService.buscarPorChave(chave);
        return configuracao.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        configuracaoSistemaService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
