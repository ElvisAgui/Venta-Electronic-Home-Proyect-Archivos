import { WindowRootComponent } from './../components-app/window-root/window-root.component';
import { ActivatedRouteSnapshot, Router, RouterStateSnapshot } from '@angular/router';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AutenticacionService {

  constructor(private router:Router) {

   }
   canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    if (WindowRootComponent.autenticado) {
      return true;
    }else{
      this.router.navigate([""]);
      return false;
    }
   }
}
