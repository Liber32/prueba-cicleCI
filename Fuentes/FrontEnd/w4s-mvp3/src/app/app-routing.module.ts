import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './modules/login/login.component';
import { AuthGuard } from './_guard/auth.guard';
import { BusquedaComponent } from './components/busqueda/busqueda.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { RegisterComponent } from './components/register/register.component';
import { ResultadosComponent } from './components/resultados/resultados.component';


const appRoutes: Routes = [
  { path: '', redirectTo: '/welcome', pathMatch: 'full' },
  { path: 'welcome', component: WelcomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'busqueda', component: BusquedaComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'resultados', component: ResultadosComponent },
  { path: '**', redirectTo:"/welcome"}
];


@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
