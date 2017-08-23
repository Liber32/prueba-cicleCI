import { Component, OnInit } from '@angular/core';
import { RegistroService } from '../../services/registro.service';
import { Registro } from '../../models/registro';
import { Router } from '@angular/router';
import { Response } from '../../models/response';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registro: Registro;

  constructor(
    private registroService: RegistroService,
    private router: Router) {
    this.registro = new Registro();
  }

  ngOnInit() {
  }

  public registrarUsuario() {
    this.registroService.registrarUsuario(this.registro).subscribe((response: Response) => {
      // Redireccionar.
      console.log(JSON.stringify(response));
      if (response.code === '202') {
        this.registroService.showMsTranslate("Registro finalizado", 'success', 5000);
        this.router.navigate(['/busqueda']);
      } else {
        this.registroService.showMsTranslate(`Error al registrar, ${response.type.toLowerCase()}`, 'danger', 5000);
      }
    });
  }

}
