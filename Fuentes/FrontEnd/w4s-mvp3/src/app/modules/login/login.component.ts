import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';
import { Response } from '../../models/response';
import { response } from '../../models/servicio';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email:string;

  constructor
  (
    private loginService: LoginService,
    private router: Router
  ) {
    this.email = "";
   }

  ngOnInit() {
  }
  /**
   * Retorna true si se el navegador soporta LocalStorage.
   */
  public isStorage(){
    let respuesta = false;
    if (window.localStorage) {
      respuesta = true;
      }
      else {
        throw new Error('Este navegador no soporta LocalStorage!');
      }
      return respuesta;
  }
  /**
   * Guarda en LocalStorage un estado de la sesion del usuario.
   */
  public guardarSesion() {
    if(this.isStorage()){
      localStorage.setItem("session_status",'true');    
    }
  }
  /**
   * Edita el estado de la sesion en LocalStorage
   * @param estado 
   */
  public editarSesion(estado:string){
    if(this.isStorage()){
      localStorage.setItem("session_status",estado);    
    }
  }
  /**
   * Retorna true si la sesion del usuario esta iniciada
   * En otro caso diferente retorna false.
   */
  public isSesionInit(){
    let respuesta = false;
    if(this.isStorage()){
      let sessionStatus = localStorage.getItem("session_status");
      if(sessionStatus == 'true'){
        respuesta = true;
      }
    }
    return respuesta;
  }
  /**
   * Envia una peticion get al microservicio de login
   * y verifica si el usuario inicio sesion correctamente.
   */
  public loginUsuario() {
    this.loginService.loginUsuario(this.email).subscribe((response: Response) => {
      // Redireccionar.
      if (response.code === '200') {
        this.router.navigate(['/busqueda']);
      } else {
        this.loginService.showMsTranslate("Error al iniciar sesión", 'danger', 3000);
      }
    });
  }

  

}
