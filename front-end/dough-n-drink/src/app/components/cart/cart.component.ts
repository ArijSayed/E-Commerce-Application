import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product/product';
import { ProductService } from 'src/app/services/product.service';
import { HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { order } from 'src/app/models/order/order';
import { OrderService } from 'src/app/services/OrderService';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  product: any;
  products: Product[] = [];
  total: any = 0;
  quantity: any = 1;
  totalnship: any = 0
  auth_token!: any
  _router: Router;
  p: any;
  


  constructor(public productService: ProductService, _router: Router, private order: OrderService) { }

  ngOnInit(): void {

    this.p = localStorage.getItem("cart");
    this.products = JSON.parse(this.p);


    this.getCartTotal();


  }

  getCartTotal(): any {
    this.total = 0;
    for (let x in this.products) {
      this.total += this.products[x].price * this.products[x].quantity
      console.log(this.total);
      if (this.total != 0) {
        this.totalnship = this.total + 10;
      }
      else {
        this.totalnship = 0
      }
      //console.log(this.quantity)
      // matensysh el quantity
    }
  }

  plusQuantity(id: number): any {
    this.products[id].quantity + 1
    this.getCartTotal()

  }

  minusQuantity(id: number): any {
    if (this.products[id].quantity == 1) {
      this.deleteProduct(id)
    }
    else
      this.products[id].quantity - 1
    this.getCartTotal()
  }

  deleteProduct(index: number) {
    this.products.splice(index, 1)
    this.getCartTotal()

    localStorage.setItem("cart", JSON.stringify(this.products));

  }

  clearCart() {
    this.products = []
    this.getCartTotal()
    localStorage.setItem("cart", JSON.stringify(this.products));

  }


  placeOrder() {
    alert("Order is added")
    this.order.placeOrder(this.products, this.total, this.getHeader(this.auth_token))
  }


  getHeader(token: string): any {
    return new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Bearer ${token}`,
    });
  }

}
