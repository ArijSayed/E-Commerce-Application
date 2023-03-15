import { HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import { ShareProductDataService } from 'src/app/services/share-product-data.service';

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit{
  auth_token:any;
  products:any;
  product:any; 

  constructor (private productservice:ProductService ,private sharedProductData:ShareProductDataService){}
  ngOnInit(): void {
    this.auth_token=localStorage.getItem("token");
        
    this.productservice.getProducts(this.getHeader(this.auth_token)).subscribe(response=>{
    this.products=response.data;

    // this.sharedService.getData().subscribe(response=>{
    //   this.product=response;

    // })
  })
  
  

} 

getHeader(token:string):any{
  return new HttpHeaders({
    'Content-Type': 'application/json',
    Authorization: `Bearer ${token}`,
  });
}

  
}
