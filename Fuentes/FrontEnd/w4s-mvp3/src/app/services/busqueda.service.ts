import { Injectable, Injector } from '@angular/core';
import { BaseService } from './base.service';
import { Http } from '@angular/http';
import { Response } from '../models/response';

@Injectable()
export class BusquedaService extends BaseService {

  constructor(private http: Http,injector: Injector) {
    super(injector);
  }

  public getUniversidades() {
    return this.http.get(`${this.baseUrl}/university/name`, { headers: this.headers })
      .map(
        response => response.json() as Response
      ).catch(this.handleError);
  }

  public getServicios() {
    return this.http.get(`${this.baseUrl}/search/name`, { headers: this.headers })
      .map(
        response => response.json() as Response
      ).catch(this.handleError);
  }

}
