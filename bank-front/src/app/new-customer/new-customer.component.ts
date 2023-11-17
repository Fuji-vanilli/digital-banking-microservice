import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CustomersService } from '../services/customers.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-customer',
  templateUrl: './new-customer.component.html',
  styleUrls: ['./new-customer.component.scss']
})
export class NewCustomerComponent implements OnInit{

  public customerForm! : FormGroup;

  constructor(private formBuilder: FormBuilder,
              private customerService: CustomersService,
              private route: Router) {}

  ngOnInit(): void {
    this.customerForm= this.formBuilder.group({
      code: this.formBuilder.control('', [Validators.required]),
      name: this.formBuilder.control('', [Validators.required]),
      email: this.formBuilder.control('', [Validators.required]),
      checked: this.formBuilder.control(false, [Validators.required])
    });
  }

  saveCustomer() {
    let customer= this.customerForm.value;
    this.customerService.saveProduct(customer).subscribe({
      next: customer=> {
        alert(JSON.stringify(customer));
        this.route.navigateByUrl("/customer")
      },
      error: err=> {
        console.log(err)
      }
    })
  }

}
