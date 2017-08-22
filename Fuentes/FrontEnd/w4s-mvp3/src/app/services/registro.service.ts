import { Injectable, Injector } from '@angular/core';
import { Registro } from '../models/index';
import { Headers, Http } from '@angular/http';
import { BaseService } from './base.service';
import { Observable } from 'rxjs/Observable';
import { response } from '../models/response';

@Injectable()
export class RegistroService extends BaseService {

  constructor(private http: Http,injector: Injector) {
    super(injector);
  }

  public registrarUsuario(registro: Registro) {
    return this.http.post(`${this.baseUrl}/register`, JSON.stringify(registro), { headers: this.headers })
      .map(
        response => response.json() as response
      ).catch(this.handleError);
  }

}
