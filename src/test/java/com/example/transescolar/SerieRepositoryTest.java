package com.example.transescolar;

import com.example.transescolar.model.Serie;
import com.example.transescolar.repository.SerieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class SerieRepositoryTest {

    @Autowired
    private SerieRepository serieRepository;

    @Test
    public void testCreateAndFindSerie() {

        Serie serie = new Serie();
        serie.setNome("Primeira Série");
        serie = serieRepository.save(serie);

        Optional<Serie> foundSerie = serieRepository.findById(serie.getId());
        assertThat(foundSerie).isPresent();
        assertThat(foundSerie.get().getNome()).isEqualTo("Primeira Série");
    }

    @Test
    public void testUpdateSerie() {

        Serie serie = new Serie();
        serie.setNome("Segunda Série");
        serie = serieRepository.save(serie);


        serie.setNome("Terceira Série");
        Serie updatedSerie = serieRepository.save(serie);


        Optional<Serie> foundSerie = serieRepository.findById(updatedSerie.getId());
        assertThat(foundSerie).isPresent();
        assertThat(foundSerie.get().getNome()).isEqualTo("Terceira Série");
    }

    @Test
    public void testDeleteSerie() {

        Serie serie = new Serie();
        serie.setNome("Quarta Série");
        serie = serieRepository.save(serie);

        serieRepository.delete(serie);

        Optional<Serie> foundSerie = serieRepository.findById(serie.getId());
        assertThat(foundSerie).isNotPresent();
    }
}
