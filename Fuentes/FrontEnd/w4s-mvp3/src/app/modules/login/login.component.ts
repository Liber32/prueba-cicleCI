import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';
import { response } from '../../models/response';

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

  public loginUsuario() {
    this.loginService.loginUsuario(this.email).subscribe((response: Response) => {
      // Redireccionar.
      if (Response.code === 200) {
        this.router.navigate(['/busqueda']);
      } else {
        this.loginService.showMsTranslate("Error al ", 'danger', 3000);
      }
    });
  }

  

}
