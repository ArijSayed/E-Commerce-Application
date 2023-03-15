import { Component, Input, OnInit } from '@angular/core';
import { ShareProductDataService } from 'src/app/services/share-product-data.service';


@Component({
  selector: 'app-desserts',
  templateUrl: './desserts.component.html',
  styleUrls: ['./desserts.component.css']
})
export class DessertsComponent implements OnInit {
 
  @Input() product:any;
  
  desserts:any;
  
  constructor(private _sharedProductData:ShareProductDataService ){}
 
  ngOnInit(): void {
  
    this._sharedProductData.getData().subscribe(response=>{
      this.desserts=response;
    })
    
  }       
    
    
}