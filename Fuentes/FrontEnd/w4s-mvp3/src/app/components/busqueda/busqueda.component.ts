import { Component, OnInit } from '@angular/core';
import { BusquedaService } from '../../services/busqueda.service';
import { Response } from '../../models/response';
import { University } from '../../models/university';

@Component({
  selector: 'app-busqueda',
  templateUrl: './busqueda.component.html',
  styleUrls: ['./busqueda.component.css']
})
export class BusquedaComponent implements OnInit {

  univerdidades: Array<University> = [];
  universidadSeleccionada: University;

  constructor(private busquedaService: BusquedaService) {
   }

  ngOnInit() {
    this.llenarUniversidades();
  }

  private llenarUniversidades(){
    this.busquedaService.getUniversidades().subscribe((response: Response) => {
      if (response.code === '200') {
        this.univerdidades = response.entity;
      } else {
        this.busquedaService.showMsTranslate(`Error al registrar, ${response.type.toLowerCase()}`, 'danger', 5000);
      }
    });
  }

  public buscar(){
    console.log(this.universidadSeleccionada);
  }

}
