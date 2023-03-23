import { Component, Injectable, OnInit } from '@angular/core';
import { ReactiveFormsModule,FormGroup,FormBuilder, Validators } from '@angular/forms';
import { LoginViewModel } from 'src/app/models/login-view-model';

import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserService } from 'src/app/services/user.service';
import { ShareUserDataService } from 'src/app/services/share-user-data.service';
import { Product } from 'src/app/models/product/product';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit{

  loginForm: FormGroup;
  visible:boolean=false;
  currentUser:User;
  auth_token:string;
  cartItems:Product[]=[];
  
 

  constructor(private _formBuilder:FormBuilder,private _userService:UserService,private _router:Router,private _http:HttpClient,private _sharedUserData: ShareUserDataService){}

  ngOnInit(): void {
      this.loginForm=this._formBuilder.group({
        email:['',[Validators.required]],
        password:['',[Validators.required]]
      })
  }
  

  login():void{
    let loginViewModel = this.loginForm.value as LoginViewModel;
   
    
    if(!this.loginForm.valid){
      this.visible=!this.visible;
    }else{
    this._userService.login(loginViewModel)
    .subscribe(
      
      response => {
        if(response.success){        
          this.auth_token =response.data.accessToken;
          this._userService.addToken(this.auth_token);
          localStorage.setItem("cart",JSON.stringify(this.cartItems));

          this._sharedUserData.setToken(this.auth_token);

          console.log(this.auth_token);
          this._userService.getUserById(response.data.id,this.getHeader(this.auth_token)).subscribe(
            response =>{
              
              if(response.success){
                this._sharedUserData.setData(response.data);
                this.currentUser = response.data;
                this._userService.addCurrentUser(this.currentUser);
                this._router.navigateByUrl('/body');
                
              }else{
                alert("something went wrong");
              }
            }
          )
            
        }else{
          alert(response.message);
        }
      }
    
    );
    }
  }





  getHeader(token:string):any{
    return new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Bearer ${token}`,
    });
  }


 


 






}
