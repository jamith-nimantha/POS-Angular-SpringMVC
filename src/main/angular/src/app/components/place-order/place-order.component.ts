import { Component, OnInit } from '@angular/core';
import {OrderDetail} from "../../core/dto/OrderDetail";
import {Order} from "../../core/dto/Order";
import {Customer} from "../../core/dto/Customer";
import {Item} from "../../core/dto/Item";
import {PlaceOrder} from "../../core/dto/PlaceOrder";
import {OrderService} from "../../core/services/order.service";
import {AlertService} from "../../core/services/alert.service";
import {CustomerService} from "../../core/services/customer.service";
import {ItemService} from "../../core/services/item.service";
import {CartItem} from "../../core/dto/CartItem";

declare var $: any;


@Component({
  selector: 'app-place-order',
  templateUrl: './place-order.component.html',
  styleUrls: ['./place-order.component.css']
})
export class PlaceOrderComponent implements OnInit {
  orders: OrderDetail[] = [];
  // orderDetail: OrderDetail = new OrderDetail();
  // order: Order = new Order();
  customers: Customer[] = [];
  items: Item[] = [];
  selectedCustomer: Customer = new Customer();
  item: Item = new Item();
  placeOrder: PlaceOrder[] = [];
  qty: number = null;
  orderId = null;
  subTotal: number = Number(0.00);
  orderDate: string ;

  constructor(private orderService: OrderService, private alertService: AlertService,
              private customerService: CustomerService, private itemService: ItemService,
              ) {

  }

  ngOnInit() {
    $('.ui.dropdown')
      .dropdown({
        allowAdditions: false
      });
    this.getAllItems();
    this.getAllCustomers();
    this.orderDate = new Date().toISOString().split('T')[0];
  }

  onAdd() {
    if (this.item.code!==undefined) {
      if (this.qty!=null && this.qty>0) {
        if (this.item.qty>=this.qty) {
          const placed = new PlaceOrder();
          placed.item = this.item;
          placed.qty = this.qty;
          placed.total = this.item.price * this.qty;
          this.placeOrder.push(placed);
          this.subTotal += placed.total;
          this.items.splice(this.items.indexOf(this.item),1)
          this.clearItem();
        } else {
          this.alertService.showToaster("Stock Quantity is lower than requested !", "ERROR");
        }
      } else {
        this.alertService.showToaster("Quantity cannot be empty or Zero !", "ERROR");
      }
    } else {
      this.alertService.showToaster("No Item has selected !","ERROR");
    }
  }



  private clearItem() {
    this.item = new Item();
    this.qty = null;
  }

  private getAllCustomers() {
    this.customerService.getAllCustomers().subscribe(data => {
      this.customers = data;
    });
  }

  private getAllItems() {
    this.itemService.getAllItems().subscribe(data =>{
      this.items = data;
    });
  }

  private clearAll(){
    this.clearItem();
    this.getAllCustomers();
    this.getAllItems();
    this.selectedCustomer = new Customer();
    this.orderId = null;
    this.placeOrder = [];
    this.subTotal = Number(0.00);

  }

  onOrderEdit(placedOrder: PlaceOrder) {
    this.onOrderDelete(placedOrder);
    this.item = placedOrder.item;
    this.qty = placedOrder.qty;

  }

  onOrderDelete(placedOrder: PlaceOrder) {
    this.placeOrder.splice(this.placeOrder.indexOf(placedOrder),1);
    this.items.push(placedOrder.item);
  }

  onCheckout(){
    console.log(this.orderId);
    if (this.selectedCustomer.id!==undefined) {
      if (this.orderId!=null) {

        if (this.placeOrder.length>0) {
          const od = new OrderDetail();

          const order = new Order();
          order.id = this.orderId;
          order.date = this.orderDate;
          order.custId = this.selectedCustomer.id;

          let cart: CartItem[] = [];

          for (let i of this.placeOrder) {
            const item = new CartItem();
            item.code = i.item.code;
            item.qty = i.qty;
            cart.push(item);
          }

          od.cartItems = cart;
          od.order = order;

          this.orderService.saveOrder(od).subscribe(data =>{
            if (data){
              this.alertService.showToaster("Order Checkout Successfully","SUCCESS");
              this.clearAll();
            }else {
              this.alertService.showToaster("Order Checkout Failed","ERROR");
            }
          });
        } else {
          this.alertService.showToaster("Cart is empty !","ERROR")
        }
      } else {
        this.alertService.showToaster("Order ID is not selected","ERROR")
      }
    } else {
      this.alertService.showToaster("Customer is not selected","ERROR")
    }

  }

}
