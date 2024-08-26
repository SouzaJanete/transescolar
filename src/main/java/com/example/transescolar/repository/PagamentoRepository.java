package com.example.transescolar.repository;

import com.example.transescolar.model.Escola;
import com.example.transescolar.model.Pagamento;
import com.example.transescolar.service.EscolaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository  extends JpaRepository<Pagamento, Long> {
    List<Pagamento> findByResponsavelCpf(String cpf);

}
