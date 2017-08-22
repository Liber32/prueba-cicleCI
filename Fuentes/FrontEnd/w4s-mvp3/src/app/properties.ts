import { environment } from '../environments/environment';

export class Properties {
    static get baseUrl(){
        if (environment.production) {
            return 'rutaproduccion';
        } else {
            return 'http://192.168.3.218:8090/authentication';
        }
    }
    static get logUrl(){
        if (environment.production) {
            return 'urlServicioLogs';
        } else {
            return 'UrlServicioLogsDesarrollo';
        }
    }
}