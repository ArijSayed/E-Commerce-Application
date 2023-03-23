import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { ResponseViewModel } from '../../models/response-view-model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { RegisterViewModel } from 'src/app/models/register-view-model';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  RegistrationForm : any;
  visible:boolean=false;

  constructor (private _http:HttpClient,private _formBuilder:FormBuilder,private _userService:UserService,private _router:Router){}
  // constructor(private _formBuilder:FormBuilder){}
  
  ngOnInit(): void {    
    this.RegistrationForm=this._formBuilder.group({
      fname:['',[Validators.required,Validators.minLength(3),Validators.maxLength(10)]],
      lname:['',[Validators.required,Validators.minLength(3),Validators.maxLength(10)]],
      email:['',[Validators.required,Validators.minLength(14),Validators.maxLength(40),Validators.email]],
      address:['',[Validators.required,Validators.minLength(10),Validators.maxLength(70)]],
      phone:['',[Validators.required,Validators.minLength(11),Validators.maxLength(15)]],
      password:['',[Validators.required,Validators.minLength(5),Validators.maxLength(15)]]

    })
  }


  users:User[]=[];

  add ():void{
    let registerViewModel = this.RegistrationForm.value as RegisterViewModel;

    if(!this.RegistrationForm.valid){
      this.visible=!this.visible;
    }else{
      // let user = new User();
 
      this._userService.register(registerViewModel)
      .subscribe(
        response=>{
          if(response.success){
         
            alert(response.message);
            this._router.navigateByUrl('/login');
          }
          else{

            alert(response.message);
          }
        }
      );
    }
   
    
  }



  reset (fname:string,lname:string,email:string,address:string,phone:string,password:string):void{
    let user = new User();
    user.fname=fname;
    user.lname=lname;
    user.email=email;
    user.address=address;
    user.phone=phone;
    user.password=password;
  }
}
