import { Component, OnInit } from '@angular/core';
import { CustomersService } from '../services/customers.service';
import { Customer } from '../model/customer.model';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.scss']
})
export class CustomerComponent implements OnInit{

  customers!: Array<Customer>;

  constructor(private customerService: CustomersService) {}

  ngOnInit(): void {
    this.getCustomers();
  }
  
  getCustomers() {
    this.customerService.getCustomers().subscribe({
      next: response => {
        this.customers= response;
      },
      error: err => {
        console.log(err);
      }
    })
  }
  handleCheckCustomer(customer: Customer){
    this.customerService.checkCustomer(customer).subscribe({
      next: response=> {
        customer.checked= !customer.checked;
      },
      error: err=> {
        console.log(err);
      }  
    })
  }
  handleDeleteCustomer(customer: Customer) {
    if (confirm("Are you sure!?")) {
      this.customerService.deleteCustomer(customer).subscribe({
        next: data=> {
          this.customers= this.customers.filter(c=> c.id!= customer.id)
        }
      })
    }
  }


}
