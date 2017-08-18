import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

/**
 * Clase de Servicio utilizado para las operaciones de un Usuario
 * @author German Cañon
 * @author Oscar Marriaga
 */
@Injectable()
export class AuthGuard implements CanActivate {

    /**
     * Contructor del servicio para las inyecciones necesarias
     * @param router Servicio con las funcionalidades del Router
     */
    constructor(private router: Router) { }

    /**
     * Método encargado de ralizar la validación de permisos para acceder a una página (URL)
     * @param route La página o URL a validar
     * @param state 
     */
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const sesion = localStorage.getItem('sesion');
        const menu = localStorage.getItem('menuName');

        if (sesion) { // Si se inicio sesion se pasa a validar los permisos
           return true;
        } else { // No ha iniciado sesion y pasa a la pagina de login
            this.router.navigate(['/welcome'], { queryParams: { returnUrl: state.url }});
            return false;
        }

    }

}