// import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  template: `
  <router-outlet></router-outlet>
  `
})
export class AppComponent {
  title = 'DoughNDrink';

  constructor()
  {

  }
  ngOnInit(){
    
  }
}
