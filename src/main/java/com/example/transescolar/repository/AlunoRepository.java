package com.example.transescolar.repository;

import com.example.transescolar.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByCpfResponsavel(String cpfResponsavel);
    //List<Aluno> findByIdadeAndCpfResponsavel(int idade, String cpf);

}
