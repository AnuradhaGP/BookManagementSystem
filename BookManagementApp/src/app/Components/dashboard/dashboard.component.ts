import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Book } from 'src/app/Models/book';
import { User } from 'src/app/Models/user';
import { BookService } from 'src/app/Services/book.service';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  constructor(private userService:UserService,private router:Router) { }

  currentUser:User=<User>{};

  ngOnInit(): void {
    this.currentUser = this.userService.getCurrentUser();
  }

  logout(){
    this.userService.setCurrentUser(<User>{});
    this.userService.logControl();
    this.router.navigate(['/login']);
  }
  

 
}
