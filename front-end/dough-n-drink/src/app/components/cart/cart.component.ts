import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product/product';
import { ProductService } from 'src/app/services/product.service';
import { HttpHeaders } from '@angular/common/http';

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

  constructor(public productService: ProductService) { }

  ngOnInit(): void {
    this.auth_token = localStorage.getItem("token");
    this.productService.getProductById(1, this.getHeader(this.auth_token)
    ).subscribe(response => {
      this.product = response;
      this.products.push(this.product);

      console.log(this.product);
    })
    this.productService.getProductById(2, this.getHeader(this.auth_token)
    ).subscribe(response => {
      this.product = response;
      this.products.push(this.product);

      console.log(this.product);
      this.getCartTotal();
    })


  }

  getCartTotal(): any {
    this.total = 0;
    for (let x in this.products) {
      this.total += this.products[x].price //+ this.products[x].quantity
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

  }

  clearCart() {
    this.products = []
    this.getCartTotal()
  }

  placeOrder() {

  }
  //  getCartProducts()
  //  {
  //    if("cart" in localStorage)
  //    {
  //     this.getCartProducts=JSON.parse(localStorage.getItem("cart")!)
  //    }
  //    console.log(this.getCartProducts)
  //  }


  getHeader(token: string): any {
    return new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Bearer ${token}`,
    });
  }

}
