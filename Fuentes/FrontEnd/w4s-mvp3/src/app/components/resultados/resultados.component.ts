import { Component, OnInit } from '@angular/core';
import { Servicio } from '../../models/servicio';
import { BusquedaService } from '../../services/busqueda.service';
import { Response } from '../../models/response';

@Component({
  selector: 'app-resultados',
  templateUrl: './resultados.component.html',
  styleUrls: ['./resultados.component.css']
})
export class ResultadosComponent implements OnInit {

  servicios: Array<Servicio> = [];
  direccion: String;

  constructor(private busquedaService: BusquedaService) {

  }

  ngOnInit() {
    this.direccion = window.localStorage.getItem("direccion");
    this.listServicios();
  }

  private listServicios() {
    this.busquedaService.getServicios().subscribe((response: Response) => {
      if (response.code === '200') {
        this.servicios = response.entity;
      } else {
        this.busquedaService.showMsTranslate(`Error, ${response.type.toLowerCase()}`, 'danger', 5000);
      }
    },
      error => {
        this.busquedaService.showMsTranslate(error, "danger", 5000);
      });
  }

}
