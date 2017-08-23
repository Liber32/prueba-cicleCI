import { Injectable, Injector } from '@angular/core';
import { Registro } from '../models/index';
import { Headers, Http } from '@angular/http';
import { BaseService } from './base.service';
import { Observable } from 'rxjs/Observable';
import { Response } from '../models/response';

@Injectable()
export class LoginService extends BaseService{

  constructor(private http: Http,injector: Injector) { 
      super(injector);
  }

  public loginUsuario(email:string){
    return this.http.get(`${this.baseUrl}/login?email=${email}`, { headers: this.headers })
      .map(
        response => response.json() as Response
      ).catch(this.handleError);
  }
}
