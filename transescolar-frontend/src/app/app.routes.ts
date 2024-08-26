import { Routes } from '@angular/router';
import {AreaClienteComponent} from "./area-cliente/area-cliente.component";

export const routes: Routes = [
  { path: 'area-cliente', component: AreaClienteComponent},
  { path: '', redirectTo: '/area-cliente', pathMatch: 'full' },
  ];
