import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
// import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { HomeComponent } from './components/home/home.component';
import { ContactComponent } from './contact/contact.component';

const routes: Routes = [
  {path:'contact',component:ContactComponent},

  {path:'home',component:HomeComponent},
  
  {path:'about',component:AboutComponent},
  {path:'',component:HomeComponent},
  // {path:'**',component:NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
