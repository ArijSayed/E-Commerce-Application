import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/models/product';
import { ResponseViewModel } from 'src/app/models/response-view-model';
import { ProductService } from 'src/app/services/product.service';
import { SubcategoryComponent } from './subcategory.component';
// import {Home} from './../../components/home';
@Component({
  selector: 'app-home',
  templateUrl: 'home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit { 

  product:any;
  // product:Product=new Product;
constructor (private productservice:ProductService ,private _activatedroute:ActivatedRoute){}
ngOnInit(): void {

  this._activatedroute.paramMap
  .subscribe(
    parms=>{
      // let id=//parms.get("1")||'';
      // this.productservice.getbyid(1).subscribe( response=>{
      //   this.product=response;
      //   console.log(this.product)
      this.productservice.getProductById(1).subscribe(response=>{
        this.product=response;
        console.log(this.product);
      })
      });
    
    }
// ngOnInit(): void {
//   this._activatedroute.paramMap
//   .subscribe(
//     parms=>{
//       let id=//parms.get("1")||'';
//       this.productservice.getbyid(1).subscribe( response=>{
//         this.product=response;
//         console.log(this.product)
//       });
    
//     }
//   )}
//  this.productservice.view(1).subscribe(response=>{
//   this.product=response;
//  },
//  error=>{
//   alert("error occured");
// }
 
//  )



  // this._http.get<ResponseViewModel>('http://localhost:8080/product')
  // .subscribe(
  //   response=>{
    
  //     this.product=response.Data;
  //   },
  //   error=>{
  //     alert('error occurred');
  //   }
  // ); 
 
  

}
