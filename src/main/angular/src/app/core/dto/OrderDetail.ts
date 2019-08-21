import {Order} from './Order';
import {CartItem} from "./CartItem";

export class OrderDetail {
  order: Order = new Order();
  cartItems : CartItem[] = [];
}
