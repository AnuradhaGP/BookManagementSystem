import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { User } from 'src/app/Models/user';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  //sign up form group
  signupForm:FormGroup = new FormGroup({
    username: new FormControl(null,[Validators.required]),
    password: new FormControl(null,[Validators.required]),
    email: new FormControl(null,[Validators.required,Validators.email]),
    avatarUrl: new FormControl(null,[Validators.required])
  });

  constructor(private userService:UserService,private _router:Router) { }

  ngOnInit(): void {
  }

  errorState=false;

  //sign up function
  signUp(){
      const user:User=new User(
        0,
        this.signupForm.get('username')?.value,
        this.signupForm.get('password')?.value,
        this.signupForm.get('email')?.value,
        this.signupForm.get('avatarUrl')?.value
      );

      this.userService.registerUser(user).subscribe(resp=>{
        alert(resp.data);
        this._router.navigate(['login']);
      },erro=>{
        console.log("errorr");
        this.errorState = true;
      });
         
        
      
     
     
  
    
  }

}
