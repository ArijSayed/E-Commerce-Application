import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class ShareUserDataService {
 public userDataSubject = new Subject();
 public tokenSubject = new Subject();
  constructor() { }


  public setData(userData:User){
    this.userDataSubject.next(userData)
  }


  public getData(): Observable<any>{
    return this.userDataSubject.asObservable();
  }



  public setToken(token:string){
    this.tokenSubject.next(token);
  }

  public getToken(): Observable<any>{
    return this.tokenSubject.asObservable();
  }


}
