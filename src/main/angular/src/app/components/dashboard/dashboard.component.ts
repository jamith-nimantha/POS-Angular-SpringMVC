import { Component, OnInit } from '@angular/core';
import {ItemService} from "../../core/services/item.service";
import {CustomerService} from "../../core/services/customer.service";
import {OrderService} from "../../core/services/order.service";

declare let $: any;

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  customers: number = 0;
  orders: number = 0;
  items: number = 0;

  constructor(private itemService: ItemService, private customerService: CustomerService,
              private orderService: OrderService) { }

  ngOnInit() {
    this.orderService.getCount().subscribe(data => {
      this.customers = data;
    });
    this.itemService.getCount().subscribe(data => {
      this.items = data;
    });
    this.orderService.getCount().subscribe(data => {
      this.orders = data;
    });
  }




}
