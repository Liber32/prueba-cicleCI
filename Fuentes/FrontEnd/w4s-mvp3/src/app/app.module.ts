import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';

import { LoginModule } from './modules/login/login.module';
import { FlashMessagesModule, FlashMessagesService } from 'angular2-flash-messages';
import { LoginComponent } from './modules/login/login.component';
import { AuthGuard } from './_guard/auth.guard';
import { AppRoutingModule } from './app-routing.module';
import { BusquedaComponent } from './components/busqueda/busqueda.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { RegisterComponent } from './components/register/register.component';
import { RegistroService } from './services/registro.service';
import { Http } from '@angular/http';
import { LogoutComponent } from './components/logout/logout.component';
import { NavComponent } from './components/nav/nav.component';
import { LoginService } from './services/login.service';
import { BusquedaService } from './services/busqueda.service';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    BusquedaComponent,
    RegisterComponent,
    LogoutComponent,
    NavComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    AppRoutingModule,
    FlashMessagesModule,
    LoginModule,
    FormsModule
  ],

  providers: [AuthGuard,RegistroService,BusquedaService,FlashMessagesService,LoginService],

  bootstrap: [AppComponent]
})
export class AppModule { }
