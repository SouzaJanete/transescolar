package com.example.transescolar;

import com.example.transescolar.model.Escola;
import com.example.transescolar.repository.EscolaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;




@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EscolaRepositoryTest {

    @Autowired
    private EscolaRepository escolaRepository;

    @Test
    public void testCreateAndFindEscola() {
        Escola escola = new Escola();
        escola.setNome("Escola Teste");
        escola.setEndereco("Endereço Teste");
        escola = escolaRepository.save(escola);

        Optional<Escola> foundEscola = escolaRepository.findById(escola.getId());
        assertThat(foundEscola).isPresent();
        assertThat(foundEscola.get().getNome()).isEqualTo("Escola Teste");
    }
}
