import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../model/customer.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CustomersService {

  constructor(private http: HttpClient) { }

  
  public getCustomers(): Observable<Array<Customer>> {
    return this.http.get<Array<Customer>>("http://localhost:5550/customers");
  }

  public checkCustomer(customer: Customer): Observable<Customer> {
    return this.http.patch<Customer>("http://localhost:5550/customers/"+customer.id, {checked: !customer.checked});
  }
  public deleteCustomer(customer: Customer) {
    return this.http.delete("http://localhost:5550/customers/"+customer.id);
  }
  public saveProduct(customer: Customer) {
    return this.http.post<Customer>("http://localhost:5550/customers", customer)
  }
}
