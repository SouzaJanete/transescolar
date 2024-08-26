import { bootstrapApplication } from '@angular/platform-browser';
import { provideRouter, withComponentInputBinding } from '@angular/router';
import { AppComponent } from './app/app.component';
import { AreaClienteComponent } from './app/area-cliente/area-cliente.component';

const routes = [
  { path: 'area-cliente', component: AreaClienteComponent },
  { path: '**', redirectTo: 'area-cliente' } // Redireciona para 'area-cliente' se a rota não for encontrada
];

bootstrapApplication(AppComponent, {
  providers: [
    provideRouter(routes, withComponentInputBinding()) // Configura o roteamento
  ]
}).catch(err => console.error(err));
