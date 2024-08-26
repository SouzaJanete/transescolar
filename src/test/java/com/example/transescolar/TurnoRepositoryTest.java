package com.example.transescolar;

import com.example.transescolar.model.Turno;
import com.example.transescolar.repository.TurnoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Propagation;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TurnoRepositoryTest {

    @Autowired
    private TurnoRepository turnoRepository;

    @Test
    @org.springframework.transaction.annotation.Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void testCreateAndFindTurno() {

        Turno turno = new Turno();
        turno.setNome("Matutino");
        turno = turnoRepository.save(turno);

        Optional<Turno> foundTurno = turnoRepository.findById(turno.getId());
        assertThat(foundTurno).isPresent();
        assertThat(foundTurno.get().getNome()).isEqualTo("Matutino");
    }

    @Test
    public void testUpdateTurno() {

        Turno turno = new Turno();
        turno.setNome("Vespertino");
        turno = turnoRepository.save(turno);

        turno.setNome("Noturno");
        Turno updatedTurno = turnoRepository.save(turno);

        Optional<Turno> foundTurno = turnoRepository.findById(updatedTurno.getId());
        assertThat(foundTurno).isPresent();
        assertThat(foundTurno.get().getNome()).isEqualTo("Noturno");
    }

    @Test
    public void testDeleteTurno() {

        Turno turno = new Turno();
        turno.setNome("Integral");
        turno = turnoRepository.save(turno);

        turnoRepository.delete(turno);

        Optional<Turno> foundTurno = turnoRepository.findById(turno.getId());
        assertThat(foundTurno).isNotPresent();
    }
}
