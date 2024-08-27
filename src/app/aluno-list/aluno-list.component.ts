import { Component, OnInit } from '@angular/core';
import { AlunoService } from '../services/aluno.service';
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-aluno-list',
  templateUrl: './aluno-list.component.html',
  standalone: true,
  imports: [
    NgForOf
  ],
  styleUrls: ['./aluno-list.component.css']
})
export class AlunoListComponent implements OnInit {
  alunos: any[] = [];

  constructor(private alunoService: AlunoService) {}

  ngOnInit(): void {
    this.loadAlunos();
  }

  loadAlunos(): void {
    this.alunoService.getAlunos().subscribe((data: any[]) => {
      this.alunos = data;
    });
  }

  editarAluno(id: number): void {
    // Navegar para a página de edição com o ID do aluno
  }

  deletarAluno(id: number): void {
    this.alunoService.deleteAluno(id).subscribe(() => {
      this.loadAlunos();
    });
  }
}
