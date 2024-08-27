import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AlunoService {
  private _apiUrl = 'http://localhost:8080/alunos'; // Defina o URL base da API

  constructor(private http: HttpClient) { }

  public getAlunos(): Observable<any[]> {
    return this.http.get<any[]>(`${this._apiUrl}`);
  }

  deleteAluno(id: number): Observable<any> {
    return this.http.delete<any>(`${this._apiUrl}/${id}`);
  }

  getAlunoById(id: number) {
    return new Observable()
  }

  updateAluno(aluno: any) {
    console.log(aluno)
    return new Observable()
  }

  createAluno(aluno: any) {
    console.log(aluno)
    return this.http.post(`${this._apiUrl}`, aluno);
  }
}
