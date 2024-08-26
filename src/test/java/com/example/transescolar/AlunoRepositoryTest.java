package com.example.transescolar;


import com.example.transescolar.model.Aluno;
import com.example.transescolar.model.Pagamento;
import com.example.transescolar.repository.AlunoRepository;
import com.example.transescolar.repository.PagamentoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Propagation;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class AlunoRepositoryTest {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    private Aluno aluno;

    @BeforeEach
    public void setUp() {
        aluno = new Aluno();
        aluno.setNome("Vicente");
        aluno.setCpfResponsavel("000.000.000-00");
        aluno.setIdade(8);
        alunoRepository.save(aluno);
    }

    @Test
    @org.springframework.transaction.annotation.Transactional(propagation = Propagation.NOT_SUPPORTED)
        public void testCreateAndFindAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome("Micaela Souza");
        aluno.setIdade(15);
        aluno.setEndereco("Av Anapolis");
        alunoRepository.save(aluno);

        Aluno aluno2 = new Aluno();
        aluno2.setNome("Vicente Souza");
        aluno2.setIdade(8);
        aluno2.setEndereco("Av Brasília");
        alunoRepository.save(aluno2);

        Optional<Aluno> foundAluno1 = alunoRepository.findById(aluno.getId());
        assertThat(foundAluno1).isPresent();
        assertThat(foundAluno1.get().getNome()).isEqualTo("Micaela Souza");

        Optional<Aluno> foundAluno2 = alunoRepository.findById(aluno2.getId());
        assertThat(foundAluno2).isPresent();
        assertThat(foundAluno2.get().getNome()).isEqualTo("Vicente Souza");
    }

    @Test
    @org.springframework.transaction.annotation.Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void testBuscarAlunoComPagamentos() {
        // Supondo que você já tenha um aluno com pagamentos no banco de dados
        List<Pagamento> pagamentos = pagamentoRepository.findAll();
        assertFalse(pagamentos.isEmpty());

        Aluno alunoComPagamentos = alunoRepository.findById(pagamentos.get(0).getAluno().getId()).orElse(null);
        assertNotNull(alunoComPagamentos);
        assertEquals(pagamentos.size(), alunoComPagamentos.getPagamentos().size());
    }
}
