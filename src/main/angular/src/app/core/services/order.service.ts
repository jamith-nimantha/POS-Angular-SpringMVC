import { Injectable } from '@angular/core';
import {OrderDetail} from '../dto/OrderDetail';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

export const MAIN_URL = 'http://localhost:8080';
const ORDER_URL = '/api/order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private httpClient: HttpClient) { }

  getCount(): Observable<number>{
    return this.httpClient.get<number>(MAIN_URL + ORDER_URL + '/count');
  }

  getAllOrders():Observable<Array<OrderDetail>>{
    return this.httpClient.get<Array<OrderDetail>>(MAIN_URL + ORDER_URL+ '/all');
  }

  saveOrder(orderDetail: OrderDetail): Observable<boolean>{
    return this.httpClient.post<boolean>(MAIN_URL + ORDER_URL + '/save', orderDetail);
  }

}
