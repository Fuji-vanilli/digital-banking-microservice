import { Component, OnInit } from '@angular/core';
import { CustomersService } from '../services/customers.service';
import { Customer } from '../model/customer.model';
import { HttpResponse } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.scss']
})
export class CustomerComponent implements OnInit{

  customers!: Array<Customer>;
  keyword: string= "";
  totalPage: number= 1;
  currentPage: number= 1;
  pageSize: number= 5;

  constructor(private customerService: CustomersService,
              private route: Router) {}

  ngOnInit(): void {
    this.getCustomers();
  }
  
  getCustomers() {
    this.customerService.getCustomers(this.keyword,this.currentPage,this.pageSize).subscribe({
      next: (resp: HttpResponse<Object>) => {
        this.customers= resp.body as Customer[];
        let totalCustomers: number= parseInt(resp.headers.get('X-total-count')!);

        this.totalPage= Math.floor(totalCustomers / this.pageSize);
        if (this.totalPage % this.pageSize != 0) {
          this.totalPage+= 1;
        }
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
          this.customers= this.customers.filter(c=> c.code!= customer.code)

          this.getCustomers();
        }
      })
    }
  }
  handlePageCheck(current: number) {
    this.currentPage= current;
    this.getCustomers();
  }
  handleEdit(id: number) {
    this.route.navigateByUrl('/editCustomer/'+id);
  }

}
