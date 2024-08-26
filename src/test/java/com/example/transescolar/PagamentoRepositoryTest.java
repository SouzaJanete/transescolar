package com.example.transescolar;


import com.example.transescolar.model.Aluno;
import com.example.transescolar.model.Pagamento;
import com.example.transescolar.repository.AlunoRepository;
import com.example.transescolar.repository.PagamentoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class PagamentoRepositoryTest {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    private Aluno aluno;
    private Pagamento pagamento;

    @BeforeEach
    public void setUp() {
        aluno = new Aluno();
        aluno.setNome("João Silva");
        aluno.setCpfResponsavel("12345678901");
        aluno.setNomeMae("Maria Silva");
        aluno.setIdade(8);
        alunoRepository.save(aluno);

        pagamento = new Pagamento();
        pagamento.setDataPagamento(LocalDate.now());
        pagamento.setValor(250.00);
        pagamento.setMesReferencia("Agosto 2024");
        pagamento.setDescricaoPagamento("Mensalidade de agosto");
        pagamento.setAluno(aluno);
        pagamentoRepository.save(pagamento);
    }

    @Test
    public void testSalvarPagamento() {
        Pagamento pagamentoSalvo = pagamentoRepository.save(pagamento);
        assertNotNull(pagamentoSalvo);
        assertEquals("Mensalidade de agosto", pagamentoSalvo.getDescricaoPagamento());
    }

    @Test
    public void testBuscarPorId() {
        Optional<Pagamento> pagamentoEncontrado = pagamentoRepository.findById(pagamento.getId());
        assertTrue(pagamentoEncontrado.isPresent());
        assertEquals(pagamento.getId(), pagamentoEncontrado.get().getId());
    }

    @Test
    public void testBuscarPorAluno() {
        List<Pagamento> pagamentos = pagamentoRepository.findAll();
        assertFalse(pagamentos.isEmpty());
        assertEquals(aluno.getId(), pagamentos.get(0).getAluno().getId());
    }

    @Test
    public void testDeletarPagamento() {
        pagamentoRepository.deleteById(pagamento.getId());
        Optional<Pagamento> pagamentoDeletado = pagamentoRepository.findById(pagamento.getId());
        assertFalse(pagamentoDeletado.isPresent());
    }
}