package com.example.transescolar.service;

import com.example.transescolar.model.ConfiguracaoSistema;
import com.example.transescolar.repository.ConfiguracaoSistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfiguracaoSistemaService {

    @Autowired
    private ConfiguracaoSistemaRepository configuracaoSistemaRepository;

    public List<ConfiguracaoSistema> listarTodos() {
        return configuracaoSistemaRepository.findAll();
    }

    public ConfiguracaoSistema salvar(ConfiguracaoSistema configuracao) {
        return configuracaoSistemaRepository.save(configuracao);
    }

    public Optional<ConfiguracaoSistema> buscarPorChave(String chave) {
        return configuracaoSistemaRepository.findByChave(chave);
    }

    public void deletar(Long id) {
        configuracaoSistemaRepository.deleteById(id);
    }
}
