import { Component, Input, OnInit } from '@angular/core';
import { ShareProductDataService } from 'src/app/services/share-product-data.service';


@Component({
  selector: 'app-pizza',
  templateUrl: './pizza.component.html',
  styleUrls: ['./pizza.component.css']
})
export class PizzaComponent implements OnInit {
 
  // @Input() product:any;
  
  pizzas:any;
  
  constructor(private _sharedProductData:ShareProductDataService ){}
 
  ngOnInit(): void {
  
    
        this._sharedProductData.getData().subscribe(response=>{
        this.pizzas=response;
        console.log(this.pizzas);  
        
        })
      // })
    }
           
    
    
}