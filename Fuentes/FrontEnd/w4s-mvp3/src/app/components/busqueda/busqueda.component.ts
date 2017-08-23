import { Component, OnInit } from '@angular/core';
import { BusquedaService } from '../../services/busqueda.service';
import { Response } from '../../models/response';
import { University } from '../../models/university';
import { Router } from '@angular/router';

@Component({
  selector: 'app-busqueda',
  templateUrl: './busqueda.component.html',
  styleUrls: ['./busqueda.component.css']
})
export class BusquedaComponent implements OnInit {

  univerdidades: Array<University> = [];
  universidadSeleccionada: University;
  cllSeleccionado: String;
  numero: String;
  par1: String;
  par2: String;

  constructor(private busquedaService: BusquedaService,
    private router: Router) {
  }

  ngOnInit() {
    this.llenarUniversidades();
  }

  private llenarUniversidades() {
    this.busquedaService.getUniversidades().subscribe((response: Response) => {
      if (response.code === '200') {
        this.univerdidades = response.entity;
      } else {
        this.busquedaService.showMsTranslate(`Error al registrar, ${response.type.toLowerCase()}`, 'danger', 5000);
      }
    },
      error => {
        this.busquedaService.showMsTranslate(error, "danger", 5000);
      });
  }

  public validarForm(): boolean {
    return (this.numero !== null && this.par1 !== null && this.par2 !== null && this.universidadSeleccionada !== null);
  }

  public buscar() {
    window.localStorage.setItem("direccion",`${this.cllSeleccionado} ${this.numero} ${this.par1} ${this.par2}`);
    this.router.navigate(['/resultados']);
  }

}
