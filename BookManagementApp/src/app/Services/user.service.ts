import { Injectable } from '@angular/core';
import { catchError, Observable, throwError} from 'rxjs';
import { User } from '../Models/user';
import {HttpClient} from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class UserService {

  baseUrl = "http://localhost:3000/api/v1/user";
  constructor(private http:HttpClient) { }

  //keep current user who logged in
  public currentUser=<User>{};

  loggedIn=false;

  //set login value according to the logged in or logged out
  logControl(){
    this.loggedIn=!this.loggedIn;
  }

  //check if logged in any user
  isLogged():boolean{
    return this.loggedIn;
  }

  //set current user
  setCurrentUser(user:User){
    this.currentUser=user;
  }

  //get current user details
  getCurrentUser(){
    return this.currentUser;
  }

  //save new user
  registerUser(
      user:User
    ):Observable<any>{
    return this.http.post(this.baseUrl+"/save-user",{
      username: user.username,
      password: user.password,
      email:user.email,
      avatarUrl:user.avatarUrl,
    }).pipe(catchError(err=>{
      return throwError(err);
    }));
    
  }

  //login
  login(username:string, password:string):Observable<any>{
    return this.http.post(this.baseUrl+"/login",{
      username:username,
      password:password,
      email:'s',
      avatarUrl:'s',
    });
  }


}
