import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerComponent } from './customer/customer.component';
import { NewCustomerComponent } from './new-customer/new-customer.component';
import { HomeComponent } from './home/home.component';
import { EditCustomerComponent } from './edit-customer/edit-customer.component';

const routes: Routes = [
  { path: "home", component: HomeComponent},
  { path: "customer", component: CustomerComponent},
  { path: "newCustomer", component: NewCustomerComponent},
  { path: "editCustomer/:id", component: EditCustomerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
