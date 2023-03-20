import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AboutComponent } from './components/about/about.component';
import { BodyComponent } from './components/body/body.component';
import { CartComponent } from './components/cart/cart.component';
import { DessertsComponent } from './components/categories/desserts/desserts.component';
import { DrinksComponent } from './components/categories/drinks/drinks.component';
import { PizzaComponent } from './components/categories/pizza/pizza.component';
import { ContactComponent } from './components/contact/contact.component';
import { ControlproductComponent } from './components/controlproduct/controlproduct.component';
import { DetailsComponent } from './components/details/details.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { LogoutComponent } from './components/logout/logout.component';
import { UserComponent } from './components/user/user.component';

import { SearchPipe } from './search.pipe';
import { ViewOrdersComponent } from './components/view-orders/view-orders.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter/src/ng2-filter.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ProfileComponent } from './components/profile/profile.component';






@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    LogoutComponent,
    ControlproductComponent,
    ContactComponent,
    AboutComponent,
    PizzaComponent,
    DrinksComponent,
    DetailsComponent,
    DessertsComponent,
    CartComponent,
    BodyComponent,
    UserComponent,
    SearchPipe,
    ViewOrdersComponent,
    ProfileComponent



  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserAnimationsModule,
    // Ng2SearchPipeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
