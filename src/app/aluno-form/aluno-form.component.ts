import { Component, OnInit } from '@angular/core';
// @ts-ignore

import { ActivatedRoute, Router } from '@angular/router';
import {NgForOf} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {AlunoService} from "../services/aluno.service";

@Component({
  selector: 'app-aluno-form',
  templateUrl: './aluno-form.component.html',
  standalone: true,
  imports: [
    NgForOf,
    FormsModule,
  ],
  styleUrls: ['./aluno-form.component.css']
})
export class AlunoFormComponent implements OnInit {
  aluno: any = {};
  escolas: any[] = [];
  turnos: any[] = [];
  series: any[] = [];

  constructor(
    private alunoService: AlunoService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    // Carregar dados para os selects
    this.loadEscolas();
    this.loadTurnos();
    this.loadSeries();

    // Verificar se é edição
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.alunoService.getAlunoById(+id).subscribe(data => {
        this.aluno = data;
      });
    }
  }

  loadEscolas(): void {
    // Chamar o serviço para carregar escolas
  }

  loadTurnos(): void {
    // Chamar o serviço para carregar turnos
  }

  loadSeries(): void {
    // Chamar o serviço para carregar séries
  }

  salvarAluno(): void {
    if (this.aluno.id) {
      this.alunoService.updateAluno(this.aluno).subscribe(() => {
        this.router.navigate(['/alunos']);
      });
    } else {
      this.alunoService.createAluno(this.aluno).subscribe(() => {
        this.router.navigate(['/alunos']);
      });
    }
  }
}
