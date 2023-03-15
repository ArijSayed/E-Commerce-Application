import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit, Input } from '@angular/core';

import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';

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
  
  constructor(private productService:ProductService, private route:ActivatedRoute){}
 
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
        
        })
      })
    }
  
    getHeader(token:string):any{
      return new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: `Bearer ${token}`,
      });
    }
  
    
}

