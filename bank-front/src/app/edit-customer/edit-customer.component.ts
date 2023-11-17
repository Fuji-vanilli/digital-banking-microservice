import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CustomersService } from '../services/customers.service';
import { Customer } from '../model/customer.model';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.scss']
})
export class EditCustomerComponent implements OnInit{

  public customerForm! : FormGroup;
  idCustomer!: number;

  constructor(private customerService: CustomersService,
              private activatedRoute: ActivatedRoute,
              private route: Router,
              private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    this.idCustomer= this.activatedRoute.snapshot.params['id'];

    this.customerService.getCustomer(this.idCustomer).subscribe({
      next: value=> {
        this.customerForm= this.formBuilder.group({
          id: this.formBuilder.control(value.id),
          code: this.formBuilder.control(value.code),
          name: this.formBuilder.control(value.name),
          email: this.formBuilder.control(value.email),
          checked: this.formBuilder.control(value.checked)
        })
      },
      error: err=> {
        console.log(err);
      }
    })

  }

  updateCustomer() {
    let customer= this.customerForm.value;
    this.customerService.updateCustomer(customer).subscribe({
      next: value=> {
        this.route.navigateByUrl('/customer');
      }
    })
  }
  
}
