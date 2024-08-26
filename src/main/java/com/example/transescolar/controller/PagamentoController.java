package com.example.transescolar.controller;

import com.example.transescolar.model.Pagamento;
import com.example.transescolar.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    // Método para obter todos os pagamentos
    @GetMapping
    public List<Pagamento> getAll() {
        return pagamentoService.getAll();
    }

    // Método para salvar um novo pagamento
    @PostMapping
    public Pagamento save(@RequestBody Pagamento pagamento) {
        return pagamentoService.save(pagamento);
    }

    // Método para obter um pagamento específico por ID
    @GetMapping("/{id}")
    public Pagamento getById(@PathVariable Long id) {
        return pagamentoService.getById(id);
    }

    // Método para deletar um pagamento específico por ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pagamentoService.delete(id);
    }

    // Método para obter pagamentos por CPF
    @GetMapping("/buscar-por-cpf")
    public ResponseEntity<List<Pagamento>> getPagamentosPorCpf(@RequestParam String cpf) {
        List<Pagamento> pagamentos = pagamentoService.obterPagamentosPorCpf(cpf);
        return ResponseEntity.ok(pagamentos);
    }
}
