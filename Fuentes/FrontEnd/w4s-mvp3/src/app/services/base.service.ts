import { Headers } from '@angular/http';
import { Injector } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/throw';
import 'rxjs/Rx';
import { Properties } from '../properties';
import { FlashMessagesService } from 'angular2-flash-messages';
/**
 * Clase base para el manejo de errores y headers para las peticiones de los servicios creados
 * @author Héctor Bedoya Ortegón
 * @author Yonatan Franco
 * @author Ana María Gómez
 */
export class BaseService {

    protected baseUrl = Properties.baseUrl;
    private _headers = new Headers({ 'Content-Type': 'application/json' });
    protected alertService:FlashMessagesService ;

    constructor(injector: Injector) {
        this.alertService = injector.get(FlashMessagesService);
    }

    /**
    * Metodo que entrega los headers para realizar una peticion http
    * @return {Headers} headers para una petición http
    */
    get headers(): Headers {
        return this._headers;
    }

    /**
    * Metodo para el manejo de errores de una peticion en http
    * @param error response de error de una peticion http
    * @return {Observable} con el mensaje de error obtenido del response
    */
    handleError(error: Response | any): Observable<string> {
        let errMsg: string;
        errMsg = 'Ha ocurrido un error, contacte su administrador';
        return Observable.throw(errMsg);
    }
    
    /**
     * Método para traducir una etiqueta enviada y el tipo de mensaje a mostrar 
     * @param paramMs La etiqueta a traducir
     * @param tipo El tipo de mensaje a enviar (success, danger, warning, info)
     * @param timeoutVal El tiempo en milisegundos que durará el mensaje de alerta
     */
    showMsTranslate(param: string, tipo: string, timeoutVal: number) {
        this.alertService.show(param, { cssClass: `alert-${tipo}`, timeout: timeoutVal });
    }
}