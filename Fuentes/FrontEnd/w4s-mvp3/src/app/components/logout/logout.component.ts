import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  public cerrarSesion() {
    this.destruirSesion();
    this.router.navigate(['/welcome']);
  }
  public iniciarSesion() {
    this.router.navigate(['/login']);
  }
  /**
    * Retorna true si se el navegador soporta LocalStorage.
    */
  public isStorage() {
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
   * Destruye la sesion en LocalStorage
   * @param estado 
   */
  public destruirSesion(){
    if(this.isStorage()){
      localStorage.removeItem("session_status");
    }
  }
  /**
 * Retorna true si la sesion del usuario esta iniciada
 * En otro caso diferente retorna false.
 */
  public isSesionInit() {
    let respuesta = false;
    if (this.isStorage()) {
      let sessionStatus = localStorage.getItem("session_status");
      if (sessionStatus == 'true') {
        respuesta = true;
      }
    }
    return respuesta;
  }
}
