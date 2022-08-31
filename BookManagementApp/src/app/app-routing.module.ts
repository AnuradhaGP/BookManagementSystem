import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddBookComponent } from './Components/add-book/add-book.component';
import { BookDetailsComponent } from './Components/book-details/book-details.component';
import { DashboardComponent } from './Components/dashboard/dashboard.component';
import { LoginComponent } from './Components/login/login.component';
import { SignupComponent } from './Components/signup/signup.component';
import { UpdateBookComponent } from './Components/update-book/update-book.component';
import { AuthGuard } from './Gurd/auth.guard';

const routes: Routes = [
  {path:'' , redirectTo:'login', pathMatch:'full'},
  {path:'login',component:LoginComponent},
  {path:'signup',component:SignupComponent},
  {path:'dashboard',component:DashboardComponent, canActivate:[AuthGuard] ,children:[
    {path:'',redirectTo:'/dashboard/bookdetail',pathMatch:'full'},
    {path:'bookdetail',component:BookDetailsComponent},
    {path:'addbook',component:AddBookComponent},
    {path:'updatebook/:id',component:UpdateBookComponent}
    ]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
