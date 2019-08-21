import { Component, OnInit } from '@angular/core';
import {OrderService} from '../../core/services/order.service';
import {AlertService} from '../../core/services/alert.service';
import {OrderDetail} from '../../core/dto/OrderDetail';
import {Order} from '../../core/dto/Order';
import {CartItem} from "../../core/dto/CartItem";
declare var $: any;

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  orders: OrderDetail[] = [];
  order: Order = new Order();
  modalOrder: OrderDetail  = new OrderDetail();
  modalSubTotal: number = Number(0.00);

  constructor(private orderService: OrderService, private alertService: AlertService) {
  }

  ngOnInit() {
    $('.ui.dropdown')
      .dropdown({
        allowAdditions: false
      });
    this.getAllOrders();
  }

  private getAllOrders() {
    this.orderService.getAllOrders().subscribe(data=>{
      this.orders = data;
    });
  }

  getTotal(order: CartItem[]): number{
    let total = 0 ;
    for (let o of order){
      total += o.qty * o.price;
    }
    return total;
  }

  openModalPlaceOrder(order: OrderDetail) {
    this.modalOrder = order;
    $('#orderModel').modal('show');

    for (let o of order.cartItems){
      this.modalSubTotal += o.price * o.qty;
    }
  }

}
