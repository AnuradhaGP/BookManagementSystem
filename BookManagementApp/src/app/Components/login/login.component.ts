import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup = new FormGroup({
    username: new FormControl(null,[Validators.required]),
    password: new FormControl(null,[Validators.required])
  })

  constructor(private userService:UserService, private router:Router) { }

  ngOnInit(): void {
  }
  errorState=false;
  errorMsg ="";
  
  login(){
   this.errorState=false;
   
    this.userService.login(
      this.loginForm.get('username')?.value,
      this.loginForm.get('password')?.value
    ).subscribe(res=>{
      this.userService.setCurrentUser(res.data);
      this.userService.logControl();
      this.router.navigate(['dashboard']);
    }, err=>{
        this.errorState=true;
        this.errorMsg = "Invalid Credentials!";
    })
  }

}
