import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Product } from '../models/product/product';

@Injectable({
  providedIn: 'root'
})
export class ShareProductDataService {

  
  public productSubject = new Subject();

  constructor() { }


  public setData(products:Product[]) {
   this.productSubject.next(products);
  }

  public getData(): Observable<any> {
   return this.productSubject.asObservable();
 }
}
