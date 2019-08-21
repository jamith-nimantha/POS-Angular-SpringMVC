import { Injectable } from '@angular/core';
import {Customer} from '../dto/Customer';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

export const MAIN_URL = 'http://localhost:8080';
const CUSTOMER_URL = '/api/customer';

@Injectable({
  providedIn: 'root'
})

export class CustomerService {

  constructor(private httpClient: HttpClient) { }

  getAllCustomers(): Observable<Array<Customer>> {
    return this.httpClient.get<Array<Customer>>(MAIN_URL + CUSTOMER_URL + '/all');
  }

  getCount(): Observable<number>{
    return this.httpClient.get<number>(MAIN_URL + CUSTOMER_URL + '/count');
  }

  saveCustomer(customer: Customer): Observable<boolean> {
    return this.httpClient.post<boolean>(MAIN_URL + CUSTOMER_URL + '/save', customer);
  }

  editCustomer(customer: Customer): Observable<boolean> {
    console.log(customer);
    return this.httpClient.put<boolean>(MAIN_URL + CUSTOMER_URL + '/update', customer);
  }

  deleteCustomer(customer: Customer): Observable<boolean> {
    return this.httpClient.delete<boolean>(MAIN_URL + CUSTOMER_URL + '/delete/'+ customer.id);
  }


}
