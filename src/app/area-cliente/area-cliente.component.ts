import {Component, NgIterable} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-area-cliente',
  standalone: true,
  imports: [
    FormsModule,
    CommonModule // Importando CommonModule para habilitar o uso de pipes como 'date'
  ],
  templateUrl: './area-cliente.component.html',
  styleUrls: ['./area-cliente.component.css']
})
export class AreaClienteComponent {
  cpf: string = '';
  pagamentosAbertos: any[] = [];
  pagamentosPagos: any[] = [];
  alunos: (NgIterable<unknown> & NgIterable<any>) | undefined | null;

  constructor(private http: HttpClient) {}

  consultarPagamentos() {
    if (this.cpf) {
      this.http.get<any[]>(`/api/pagamentos?cpf=${this.cpf}`).subscribe(data => {
        this.pagamentosAbertos = data.filter(pagamento => !pagamento.dataPagamento);
        this.pagamentosPagos = data.filter(pagamento => pagamento.dataPagamento);
      }, error => {
        console.error('Erro ao buscar pagamentos:', error);
      });
    }
  }
}
