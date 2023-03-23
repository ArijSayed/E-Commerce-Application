import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
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
import { ProfileComponent } from './components/profile/profile.component';
import { UserComponent } from './components/user/user.component';
import { ViewOrdersComponent } from './components/view-orders/view-orders.component';

import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  
  {path:'profile',component:ProfileComponent , canActivate:[AuthGuard]},
  {path:'contact',component:ContactComponent , canActivate:[AuthGuard]},
  {path:'drinks',component:DrinksComponent , canActivate:[AuthGuard]},
  {path:'pizza',component:PizzaComponent , canActivate:[AuthGuard]},
  {path:'body',component:BodyComponent , canActivate:[AuthGuard]},
  {path:'home',component:HomeComponent , canActivate:[AuthGuard]},
  {path:'about',component:AboutComponent , canActivate:[AuthGuard]},
  {path:'cart/:id',component:DetailsComponent , canActivate:[AuthGuard]},
  {path:'details/:id',component:DetailsComponent , canActivate:[AuthGuard]},
  {path:'desserts',component:DessertsComponent , canActivate:[AuthGuard]},
  {path:'cart',component:CartComponent , canActivate:[AuthGuard]},
  {path: "login", component:LoginComponent },
  {path:"logout",component:LogoutComponent },
  {path:"controlproduct",component:ControlproductComponent , canActivate:[AuthGuard]},
  {path:'',component:LoginComponent , canActivate:[AuthGuard]},
  {path:'registration',component:UserComponent },
  {path:'viewOrders',component:ViewOrdersComponent , canActivate:[AuthGuard]},


  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
