import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from '../Models/user';
import { UserService } from '../Services/user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  
  constructor(private userService:UserService, private router:Router){

  }
  canActivate():boolean {
    if(!this.userService.isLogged()){
      this.router.navigate(['/login']);
      return false;
    }
    else{
      return true;
    }
  }
  
}
