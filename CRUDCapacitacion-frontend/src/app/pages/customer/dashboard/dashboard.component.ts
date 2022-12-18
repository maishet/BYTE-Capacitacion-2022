import { Component, OnInit } from '@angular/core';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  customers:any = [

  ]
  constructor(private customerService:CustomerService) { }

  ngOnInit(): void {
    this.customerService.getCustomers().subscribe(
      (dato:any) => {
        this.customers = dato;
        console.log(this.customers);
      },
      (error) => {
        console.log(error);
        //Swal.fire('Error !!','Error al cargar los customers','error');
        console.log("error al cargar los customers");
      }
    )
  }

}
