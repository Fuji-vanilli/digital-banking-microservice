import { Component } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {

  actions: Array<any>= [
    { title: 'Home', route: '/home', icon: 'house' },
    { title: 'Customer', route: '/customer', icon: 'arrow-down-up'},
    { title: 'Create', route: '/newCustomer', icon: 'plus-circle'}
  ];

  currentAction: any;

  setCurrentAction(action: any) {
    this.currentAction= action;
  }
}
