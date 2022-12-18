import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import baserUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private httpClient: HttpClient) { }

  public getCustomers(){
    return this.httpClient.get(`${baserUrl}/customers/`);
  }

  public agregarCustomers(customer:any){
    return this.httpClient.post(`${baserUrl}/customers/`,customer);
  }

  public eliminarCustomers(customerId:any){
    return this.httpClient.delete(`${baserUrl}/customers/${customerId}`);
  }

  public obtenerCustomers(customerId:any){
    return this.httpClient.get(`${baserUrl}/customers/${customerId}`);
  }

  public actualizarCustomers(customer:any){
    return this.httpClient.put(`${baserUrl}/customers/`,customer);
  }
}
