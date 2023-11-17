import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { CustomerComponent } from './customer/customer.component';
import { NavbarComponent } from './navbar/navbar.component';
import { NewCustomerComponent } from './new-customer/new-customer.component';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EditCustomerComponent } from './edit-customer/edit-customer.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    NavbarComponent,
    NewCustomerComponent,
    HomeComponent,
    EditCustomerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatToolbarModule,
    MatIconModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
