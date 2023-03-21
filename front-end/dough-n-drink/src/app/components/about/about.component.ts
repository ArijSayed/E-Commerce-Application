import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Product } from 'src/app/models/product/product';
import { User } from 'src/app/models/user';
import { ProductService } from 'src/app/services/product.service';
import { ShareProductDataService } from 'src/app/services/share-product-data.service';
import { ShareUserDataService } from 'src/app/services/share-user-data.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent  {
  

}
