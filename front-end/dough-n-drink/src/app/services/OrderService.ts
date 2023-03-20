import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { order } from '../models/order/order';
import { orderdetails } from '../models/order/orderdetails';
import { Order } from '../models/orders/Order';
import { Product } from '../models/product/product';
import { ResponseViewModel } from '../models/response-view-model';
import { User } from '../models/user';


@Injectable({
    providedIn: 'root'
})
export class OrderService {
    chosenProduct: any;
    products: Product[] = [];
    order: order
    user: User
    orderd: orderdetails


    constructor(private _http: HttpClient) { }

    getProductById(id: number): Observable<Product> {
        return this._http.get<Product>('http://localhost:8080/product/' + id);

    }

    getProducts(): Observable<Product[]> {
        return this._http.get<Product[]>('http://localhost:8080/product');
    }

    placeOrder(product: Product[], total: number, header: any) {
        //this.order.odate = new Date();
        //this.order.sdate = new Date();
        this.order.total = total;
        this.order.userid = this.user.user_id
        this.order.payment = "cash"
        //this._http.post('http://localhost:8080/order', this.order);
        this._http.post<ResponseViewModel>(`http://localhost:8080/order`, this.order, { headers: header });


        for (let i = 0; i < product.length; i++) {
            this.orderd.OrderId = this.order.OrderId
            this.orderd.productid = this.products[i].productId
            this.orderd.quantity = this.products[i].quantity
            this._http.post('http://localhost:8080/ocp', this.orderd);
        }
    }

    getAllOrders(header:any):  Observable<Order[]>{
        return this._http.get<Order[]>(`http://localhost:8080/orders`,{ headers:header });
    }

}