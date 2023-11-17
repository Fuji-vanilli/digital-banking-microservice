import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from '../model/customer.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CustomersService {

  constructor(private http: HttpClient) { }

  
  public getCustomers(keyword: string= "", page: number= 0, size: number= 5) {
    return this.http.get<HttpResponse<Array<Customer>>>(environment.backendCustomerHost+"/customers", {
      observe: 'response',
      params: {
        name_like: keyword,
        _page: page,
        _limit: size
      }
    });
  }
  public getCustomer(id: number): Observable<Customer> {
    return this.http.get<Customer>(environment.backendCustomerHost+"/customers/"+id);
  }

  public checkCustomer(customer: Customer): Observable<Customer> {
    return this.http.patch<Customer>(environment.backendCustomerHost+"/customers/"+customer.id, {checked: !customer.checked});
  }

  public updateCustomer(customer: Customer): Observable<Customer> {
    return this.http.put<Customer>(environment.backendCustomerHost+"/customers/"+customer.id, customer);
  }
  public deleteCustomer(customer: Customer) {
    return this.http.delete(environment.backendCustomerHost+"/customers/"+customer.id);
  }

  public saveProduct(customer: Customer) {
    return this.http.post<Customer>(environment.backendCustomerHost+"/customers", customer)
  }

}
