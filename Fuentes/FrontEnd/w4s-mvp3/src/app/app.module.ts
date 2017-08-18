import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';

import { LoginModule } from './modules/login/login.module';
import { LoginComponent } from './modules/login/login.component';
import { AuthGuard } from './_guard/auth.guard';
import { AppRoutingModule } from './app-routing.module';
import { BusquedaComponent } from './components/busqueda/busqueda.component';
import { WelcomeComponent } from './components/welcome/welcome.component';




@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    BusquedaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    LoginModule
  ],
  providers: [AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
