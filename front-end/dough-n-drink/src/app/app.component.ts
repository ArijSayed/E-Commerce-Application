import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './models/product';
import { ResponseViewModel } from './models/response-view-model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'dough-n-drink';
  
  constructor(private _httpClient:HttpClient)
  {

  }
  ngOnInit(){

  }
  products:any;
chosenProduct:any;
  searchForProduct(name:string){
    this.getProducts();
    this.chosenProduct=this.products.filter((product: { name:String; } ) =>this.products);
  }

  private getProducts():Observable<Product[]>{
    return this._httpClient.get<Product[]>('http://localhost:8080/product');
  }
}
