import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import {provideRouter, Routes, withHashLocation} from '@angular/router';
import { AlunoListComponent } from './app/aluno-list/aluno-list.component';
//import {routes} from "./app/app.routes";
import {HomeComponent} from "./app/home/home.component";
import {AlunoService} from "./app/services/aluno.service";
import {provideHttpClient} from "@angular/common/http";
import {AlunoFormComponent} from "./app/aluno-form/aluno-form.component";
export const routes: Routes = [
  { path: 'alunos', component: AlunoListComponent },
  { path: 'alunos/novo', component: AlunoFormComponent },
  { path: '', component: HomeComponent },
]
bootstrapApplication(AppComponent, {
  providers: [
    provideRouter(routes, withHashLocation()),
    provideHttpClient()
  ],
}).catch(err => console.error(err));
