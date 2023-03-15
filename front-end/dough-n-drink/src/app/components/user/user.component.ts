import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user';
import { ResponseViewModel } from '../../models/response-view-model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  RegistrationForm : any;

  constructor (private _http:HttpClient,private _formBuilder:FormBuilder){}
  // constructor(private _formBuilder:FormBuilder){}
  
  ngOnInit(): void {    
    this.RegistrationForm=this._formBuilder.group({
      fName:['',[Validators.required,Validators.minLength(3),Validators.maxLength(10)]],
      lName:['',[Validators.required,Validators.minLength(3),Validators.maxLength(10)]],
      email:['',[Validators.required,Validators.minLength(14),Validators.maxLength(40),Validators.email]],
      address:['',[Validators.required,Validators.minLength(10),Validators.maxLength(70)]],
      phone:['',[Validators.required,Validators.minLength(11),Validators.maxLength(15)]],
      password:['',[Validators.required,Validators.minLength(5),Validators.maxLength(15)]]

    })
  }


  users:User[]=[];

  add (fname:string,lname:string,email:string,address:string,phone:string,password:string):void{
    let user = new User();
    user.fname=fname;
    user.lname=lname;
    user.email=email;
    user.address=address;
    user.phone=phone;
    user.password=password;
    this._http.post<ResponseViewModel>('http://localhost:8080/users/post',user)
    .subscribe(
      response=>{
        if(response.success){
          this.users.push(user);
          alert(response.message);
        }
        else
          alert(response.message);
      }
    );
    
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
