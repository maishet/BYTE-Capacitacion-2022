import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit {
  displayedColumns: string[] = ['customerID', 'companyName', 'contactName', 'contactTitle', 'address', 'city', 'region', 'postalCode', 'country', 'phone', 'fax'];
  customers: any = [];
  constructor(private customerService: CustomerService) {}

  ngOnInit(): void {
    this.customerService.listarCustomers().subscribe((data) => {
      this.customers = data;
      console.log(this.customers);
    }, (error) => {
      console.log(error);
    }
    );
  }
}
