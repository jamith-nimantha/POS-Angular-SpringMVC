import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './components/login/login.component';
import {MainComponent} from './components/main/main.component';
import {DashboardComponent} from './components/dashboard/dashboard.component';
import {CustomerComponent} from './components/customer/customer.component';
import {ItemComponent} from './components/item/item.component';
import {OrderComponent} from './components/order/order.component';
import {PlaceOrderComponent} from "./components/place-order/place-order.component";

const routes: Routes = [
  {
    path: 'app', component: MainComponent, children: [
      // {path: '*', redirectTo: 'dashboard'},
      {path: 'place-order', component: PlaceOrderComponent},
      {path: 'dashboard', component: DashboardComponent},
      {path: 'customer', component: CustomerComponent},
      {path: 'item', component: ItemComponent},
      {path: 'order', component: OrderComponent}
    ]
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {path: '**', redirectTo: 'login'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
