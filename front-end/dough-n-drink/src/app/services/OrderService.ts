import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/product';
import { ResponseViewModel } from '../models/response-view-model';


@Injectable({
    providedIn: 'root'
})
export class OrderService {
    chosenProduct: any;
    products: Product[] = [];


    constructor(private _http: HttpClient) { }

    getProductById(id: number): Observable<Product> {
        return this._http.get<Product>('http://localhost:8080/product/' + id);

    }

    getProducts(): Observable<Product[]> {
        return this._http.get<Product[]>('http://localhost:8080/product');
    }

    placeOrder(product: Product) {
        //this._http.post('http://localhost:8080/order',this.products);
        //ordercontainsproduct 3shan a7ot totalprice
    }

}