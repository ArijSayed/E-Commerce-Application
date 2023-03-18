import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/product/product';
import { ResponseViewModel } from '../models/response-view-model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  products:any;
chosenProduct:any;

  constructor(private _http:HttpClient) { }

  addProduct(product:Product,header:any){
    return this._http.post<ResponseViewModel>(`http://localhost:8080/product`,product,{ headers:header });
  }


  updateProduct(product:Product,header:any){
    return this._http.put<ResponseViewModel>(`http://localhost:8080/product`,product,{ headers:header });
  }

  deleteProduct(product_name:String,header:any){
    return this._http.delete<ResponseViewModel>(`http://localhost:8080/product/${product_name}`,{ headers:header})
    
  }



  getProductByName(name:any,header:any){
    return this._http.get<ResponseViewModel>(`http://localhost:8080/product/name/${name}`,{ headers:header });
   }

   
  view(id:number,header:any){
    return this._http.get<ResponseViewModel>('http:localhost:8080/product/'+id,{ headers:header });
  }

  searchForProduct(name:string,header:any){
    this.getProducts(header);
    this.chosenProduct=this.products.filter((product: { name:String; } ) =>this.products);
  }

  getProducts(header:any){
    return this._http.get<ResponseViewModel>('http://localhost:8080/product',{ headers:header });
  }

  

  getProductsBySubCategoryId(id:number,header:any){
    return this._http.get<ResponseViewModel>('http://localhost:8080/product/subcategory/'+id,{ headers:header });
      
  }
 

getProductById(id:number,header:any){
  return this._http.get<ResponseViewModel>('http://localhost:8080/product/'+id,{ headers:header });
   
}



  }