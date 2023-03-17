import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from 'src/app/models/orders/Order';
// import { Order } from 'src/app/models/order/order';
import { OrderService } from 'src/app/services/OrderService';

@Component({
  selector: 'app-view-orders',
  templateUrl: './view-orders.component.html',
  styleUrls: ['./view-orders.component.css']
})
export class ViewOrdersComponent implements OnInit{

  auth_token:any;
  orders:Order[]=[];
  constructor(private _router:Router,private _http:HttpClient,private _ordersService:OrderService){}
  ngOnInit(): void {
    this.auth_token=localStorage.getItem("token");
    this.getAllOrders();
  }

  getAllOrders(){
    this._ordersService.getAllOrders(this.getHeader(this.auth_token)).subscribe(
      response =>{
        console.log(this.orders);
      
        this.orders=response
        
        
      }
    )

  }


  getHeader(token:string):any{
    return new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Bearer ${token}`,
    });
  }


}
