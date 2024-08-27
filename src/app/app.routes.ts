import { Routes } from '@angular/router';
import { AreaClienteComponent } from './area-cliente/area-cliente.component';
import { ResponsavelListComponent } from './responsavel-list/responsavel-list.component';
import { ResponsavelFormComponent } from './responsavel-form/responsavel-form.component';
import { AlunoListComponent } from './aluno-list/aluno-list.component';
import { AlunoFormComponent } from './aluno-form/aluno-form.component';
import { PagamentoListComponent } from './pagamento-list/pagamento-list.component';
import { PagamentoFormComponent } from './pagamento-form/pagamento-form.component';
import {HomeComponent} from "./home/home.component";

export const routes: Routes = [
  { path: 'area-cliente', component: AreaClienteComponent },

  // Rotas para CRUD de Responsáveis
  { path: 'responsaveis', component: ResponsavelListComponent },
  { path: 'responsaveis/novo', component: ResponsavelFormComponent },
  { path: 'responsaveis/editar/:id', component: ResponsavelFormComponent },

  // Rotas para CRUD de Alunos
  { path: 'alunos', component: AlunoListComponent },
  { path: 'alunos/novo', component: AlunoFormComponent },
  { path: 'alunos/editar/:id', component: AlunoFormComponent },

  // Rotas para CRUD de Pagamentos
  { path: 'pagamentos', component: PagamentoListComponent },
  { path: 'pagamentos/novo', component: PagamentoFormComponent },
  { path: 'pagamentos/editar/:id', component: PagamentoFormComponent },

  // Rota padrão
  { path: '', component: HomeComponent },
  { path: '**', redirectTo: '/', pathMatch: 'full' }
];
