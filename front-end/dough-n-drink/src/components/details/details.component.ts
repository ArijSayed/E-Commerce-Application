import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit, Input } from '@angular/core';

import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/models/product/product';
import { ProductService } from 'src/app/services/product.service';
import { ShareProductDataService } from 'src/app/services/share-product-data.service';
import { Location } from '@angular/common';
import { ResponseViewModel } from '../../models/response-view-model';



@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  auth_token:any;
  product:any;
  products:any;
  id!:number;
  productsCart:Product[]=[];
  
  constructor(private productService:ProductService, private route:ActivatedRoute 
    ,private sharedService:ShareProductDataService){
    }
 
  ngOnInit(): void {
    this.auth_token=localStorage.getItem("token");
    this.route.params.subscribe(params=>{
      this.id=params['id'];
    })
  
    this.productService.getProductById(this.id,this.getHeader(this.auth_token)).subscribe(response=> {
        this.product=response.data;
        
        this.productService.getProductsBySubCategoryId(this.product.subCategory.subCategoryId,this.getHeader(this.auth_token)).subscribe(response=>{
        this.products=response.data;
        this.products=this.products.filter((item:any)=>item.productId!=this.product.productId);
        this.product.quantity=1;
        })
      })
      
    }
  
  
    getHeader(token:string):any{
      return new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: `Bearer ${token}`,
      });
    }
  
    increaseProducts(){
      this.product.quantity+=1;
      console.log(this.product);
    }
    
    decreaseProducts(){
      this.product.quantity-=1;
      console.log(this.product);
    }

    
    addToCart(product:Product){
      let checkArray=localStorage.getItem("product");
      if(checkArray==null){
      this.productsCart.push(product);
      localStorage.setItem("product",JSON.stringify(this.productsCart));
      }
      else {
      this.productsCart=JSON.parse(checkArray);
      this.productsCart.push(product);
      localStorage.setItem("product",JSON.stringify(this.productsCart));
      }
    }

}

