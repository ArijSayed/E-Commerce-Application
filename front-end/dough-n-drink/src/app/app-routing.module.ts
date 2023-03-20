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
  
  {path:'profile',component:ProfileComponent},
  {path:'contact',component:ContactComponent},
  {path:'drinks',component:DrinksComponent},
  {path:'pizza',component:PizzaComponent},
  {path:'body',component:BodyComponent},
  {path:'home',component:HomeComponent},
  {path:'about',component:AboutComponent},
  {path:'cart/:id',component:DetailsComponent},
  {path:'details/:id',component:DetailsComponent},
  {path:'desserts',component:DessertsComponent},
  {path:'cart',component:CartComponent},
  {path: "login", component:LoginComponent},
  {path:"logout",component:LogoutComponent},
  {path:"controlproduct",component:ControlproductComponent},
  {path:'',component:LoginComponent},
  {path:'registration',component:UserComponent},
  {path:'viewOrders',component:ViewOrdersComponent  }

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
