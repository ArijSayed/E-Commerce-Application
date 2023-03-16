import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Product } from 'src/app/models/product/product';
import { User } from 'src/app/models/user';
import { ProductService } from 'src/app/services/product.service';
import { ShareProductDataService } from 'src/app/services/share-product-data.service';
import { ShareUserDataService } from 'src/app/services/share-user-data.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit{
  firstName:string;
  lastName:string;
  isLogged=false;
  currentUser!:User;
  visible:boolean;
  constructor(private _router: Router,private _http:HttpClient,private _sharedUserData: ShareUserDataService,private _userService:UserService,private _sharedProductData:ShareProductDataService,private _productService:ProductService){}
  auth_token:any;
  products:any;
  pizzas:any;
  drinks:any;
  desserts:any;
  chosenProduct:any;
 
  

  ngOnInit()  {
    this.auth_token=localStorage.getItem("token");
    var userObject= localStorage.getItem("currentUser");
    this.currentUser = JSON.parse(userObject!);
    console.log(this.currentUser);
    
    this.adminButtonsStatus();
    console.log(this.currentUser.role);

    this._userService.logged
    .subscribe(
      status =>{
        this.isLogged =status;
      }
    );
    
  }

  
  callPizzaSubcategory(){
    this._productService.getProductsBySubCategoryId(1,this.getHeader(this.auth_token)).subscribe(response=>{
      this.pizzas=response.data;
      this. _sharedProductData.setData(this.pizzas);
    })
  }

  callDrinkSubcategory(){
    this._productService.getProductsBySubCategoryId(3,this.getHeader(this.auth_token)).subscribe(response=>{
      this.drinks=response.data;
      this. _sharedProductData.setData(this.drinks);
    })
  }

  callDessertSubcategory(){
    this._productService.getProductsBySubCategoryId(5,this.getHeader(this.auth_token)).subscribe(response=>{
      this.desserts=response.data;
      this. _sharedProductData.setData(this.desserts);
    })
  }
  
  
  searchForProduct(name:string){
    this.getProducts(this.getHeader(this.auth_token));
    this.chosenProduct=this.products.filter((product: { name:string; } ) =>this.products);
    console.log(this.products);
  }

  private getProducts(header:any):Observable<Product[]>{
    return this._http.get<Product[]>('http://localhost:8080/product',{ headers:header });
  }



  adminButtonsStatus(){
    if(this.currentUser.role=="ROLE_ADMIN"){
        this.visible = true;
    }
  }

  getHeader(token:string):any{
    return new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Bearer ${token}`,
    });
  }

  

}
