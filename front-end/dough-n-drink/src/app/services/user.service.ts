import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { LoginViewModel } from '../models/login-view-model';
import { ResponseViewModel } from '../models/response-view-model';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  logged=new BehaviorSubject<boolean>(this.isLoggedIn());
  constructor(private _http:HttpClient) { }



  login(loginViewModel:LoginViewModel){
    return this._http.post<ResponseViewModel>('http://localhost:8080/api/auth/signin',loginViewModel);
  }


  getUserById(id:any,header:any){
    return this._http.get<ResponseViewModel>(`http://localhost:8080/users/${id}`,{ headers:header });
   }
 
   logout(){
    localStorage.removeItem("token");
    localStorage.removeItem("currentUser");
    this.changeLoggedStatus(false);
   }


  addToken(token:string){
    localStorage.setItem("token",token);
    
    this.changeLoggedStatus(false);
  }


addCurrentUser(userData:User){
  localStorage.setItem("currentUser",JSON.stringify(userData))
}

  changeLoggedStatus(status:boolean){
    this.logged.next(status);
  }


  isLoggedIn():boolean
  {
    //alert(localStorage.getItem("token"));
    return localStorage.getItem("token") !=null;
  }
}
