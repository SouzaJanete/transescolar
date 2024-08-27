package com.example.transescolar.service;



import com.example.transescolar.model.Aluno;
import com.example.transescolar.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> buscarAlunosPorCpfResponsavel(String cpfResponsavel) {
        return alunoRepository.findByCpfResponsavel(cpfResponsavel);
    }

    public List<Aluno> buscarTodosOsAlunos() {
        return alunoRepository.findAll();
    }

  public Aluno salvar(Aluno aluno) {
      return alunoRepository.save(aluno);
  }
}
