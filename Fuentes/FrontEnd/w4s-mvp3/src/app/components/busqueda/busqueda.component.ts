import { Component, OnInit } from '@angular/core';
import { BusquedaService } from '../../services/busqueda.service';

@Component({
  selector: 'app-busqueda',
  templateUrl: './busqueda.component.html',
  styleUrls: ['./busqueda.component.css']
})
export class BusquedaComponent implements OnInit {

  constructor(private busquedaService: BusquedaService) { }

  ngOnInit() {
  }

  private llenarUniversidades(){
    this.busquedaService.getUniversidades();
  }
}
