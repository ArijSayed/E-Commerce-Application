import { Injectable } from "@angular/core";
import { Product } from "../models/product/product";


@Injectable({
    providedIn: 'root'
})

export class CartService {

    cart: Product[] = [];
    total: any = 0;
    quantity: any = 1;

    addToCart(product: Product) {
        this.cart.push(product);
    }

    getCart(): Product[] {
        return this.cart;
    }

    removeProduct(): void {

    }
    getCartTotal(): any {
        return this.total;
    }
    

}