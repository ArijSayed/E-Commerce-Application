import { Component, Input, OnInit } from '@angular/core';
import { ShareProductDataService } from 'src/app/services/share-product-data.service';

// import { sharedService } from 'src/app/services/product.service';


@Component({
  selector: 'app-drinks',
  templateUrl: './drinks.component.html',
  styleUrls: ['./drinks.component.css']
})
export class DrinksComponent implements OnInit {
 
  @Input() product:any;
  
  drinks:any;
  
  constructor(private _sharedProductData:ShareProductDataService  ){}
 
  ngOnInit(): void {
  
    this._sharedProductData.getData().subscribe(response=> {
        this.drinks=response;
       
  })}
           
    
    
}