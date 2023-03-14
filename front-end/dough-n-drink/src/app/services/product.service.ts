import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, observable } from 'rxjs';
import { Product } from '../models/product';
import { ResponseViewModel } from '../models/response-view-model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
products:any;
chosenProduct:any;
  constructor(private _http:HttpClient) { }


  view(id:number):Observable<ResponseViewModel>{
    return this._http.get<ResponseViewModel>('http:localhost:8080/product/'+id);
  }

  searchForProduct(name:string){
    this.getProducts();
    this.chosenProduct=this.products.filter((product: { name:String; } ) =>this.products);
  }

  private getProducts():Observable<ResponseViewModel>{
    return this._http.get<ResponseViewModel>('http://localhost:8080/product');
  }



  
getbyid(id :number):Observable<Product>{
  return this._http.get<Product>('http:localhost:8080/product/'+id)
  
}

getProductById(id:number):Observable<Product>{
  return this._http.get<Product>('http://localhost:8080/product/'+id);
   
}
}
