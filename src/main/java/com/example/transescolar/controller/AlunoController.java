package com.example.transescolar.controller;

import com.example.transescolar.model.Aluno;
import com.example.transescolar.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping("/alunos")
    public ResponseEntity<Aluno> addAluno(@RequestBody Aluno aluno) {
      if (aluno == null) {
       throw new RuntimeException("Post aluno is empty");
      }
      var r = alunoService.salvar(aluno);
      return ResponseEntity.ok(r);
    }

    @GetMapping("/alunos")
    public ResponseEntity<List<Aluno>> obterAlunos() {
        List<Aluno> alunos = alunoService.buscarTodosOsAlunos();
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/alunos/por-cpf")
    public ResponseEntity<List<Aluno>> obterAlunosPorCpfResponsavel(@RequestParam String cpfResponsavel) {
        List<Aluno> alunos = alunoService.buscarAlunosPorCpfResponsavel(cpfResponsavel);
        System.out.println("CPF recebido: " + cpfResponsavel);
        System.out.println("Alunos: " + alunos);
        return ResponseEntity.ok(alunos);
    }

    // Outros endpoints podem ser adicionados aqui
}
