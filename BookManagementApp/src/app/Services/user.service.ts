import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../Models/user';
import {HttpClient} from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class UserService {

  baseUrl = "http://localhost:3000/api/v1/user";
  constructor(private http:HttpClient) { }

  public currentUser=<User>{};

  loggedIn=false;

  logControl(){
    this.loggedIn=!this.loggedIn;
  }

  isLogged():boolean{
    return this.loggedIn;
  }

  setCurrentUser(user:User){
    this.currentUser=user;
  }

  getCurrentUser(){
    return this.currentUser;
  }

  registerUser(
      user:User
    ):Observable<any>{
    return this.http.post(this.baseUrl+"/save-user",{
      username: user.username,
      password: user.password,
      email:user.email,
      avatarUrl:user.avatarUrl,
    });
  }

  login(username:string, password:string):Observable<any>{
    return this.http.post(this.baseUrl+"/login",{
      username:username,
      password:password,
      email:'s',
      avatarUrl:'s',
    });
  }

}
