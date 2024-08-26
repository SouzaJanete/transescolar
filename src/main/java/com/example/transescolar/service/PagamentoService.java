package com.example.transescolar.service;

import com.example.transescolar.model.Pagamento;
import com.example.transescolar.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<Pagamento> getAll() {
        return (List<Pagamento>) pagamentoRepository.findAll();
    }

    public Pagamento save (Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento getById(Long id) {
        return pagamentoRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        pagamentoRepository.deleteById(id);
    }

    public List<Pagamento> obterPagamentosPorCpf(String cpf) {
        return pagamentoRepository.findByResponsavelCpf(cpf);
    }
}
