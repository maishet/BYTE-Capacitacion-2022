import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import baserUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http:HttpClient) { }

  public listarCustomers(){
    return this.http.get(`${baserUrl}/customers/`);
  }

  public saveCustomer(customer:any){
    return this.http.post(`${baserUrl}/customers/`,customer);
  }

  public updateCustomer(customer:any){
    return this.http.put(`${baserUrl}/customers/`,customer);
  }
  
  public getCustomer(customerId:any){
    return this.http.get(`${baserUrl}/customers/${customerId}`);
  }

  public deteleCustomer(customerId:any){
    return this.http.delete(`${baserUrl}/customers/${customerId}`);
  }
}
