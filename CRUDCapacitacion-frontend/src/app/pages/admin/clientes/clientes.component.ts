import { AfterViewInit, Component, Inject, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialog } from '@angular/material/dialog';
import { CustomerService } from 'src/app/service/customer.service';
import { DialogoComponent } from '../dialogo/dialogo.component';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css'],
})
export class ClientesComponent implements AfterViewInit {
  constructor(
    private customerService: CustomerService,
    private dialog: MatDialog,
    private snack: MatSnackBar
  ) {}

  displayedColumns: string[] = [
    'customerID',
    'companyName',
    'contactName',
    'contactTitle',
    'address',
    'city',
    'region',
    'postalCode',
    'country',
    'phone',
    'fax',
    'acciones',
  ];
  customers: any = [];
  dataSource!: MatTableDataSource<any>;
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator;
  }

  ngOnInit(): void {
    this.getAllCustomers();
  }

  addCustomer(): void {
    this.dialog
      .open(DialogoComponent, {
        width: '30%',
      })
      .afterClosed()
      .subscribe((result) => {
        this.getAllCustomers();
      });
  }

  editCustomer(customer: any): void {
    this.dialog
      .open(DialogoComponent, {
        width: '30%',
        data: customer,
      })
      .afterClosed()
      .subscribe((result) => {
        this.getAllCustomers();
      });
  }

  deleteCustomer(customerid: String): void {
    this.customerService.deteleCustomer(customerid).subscribe({
      next: (data) => {
        console.log(data);
        this.getAllCustomers(); //actualizar tabla
        this.snack.open('Cliente eliminado', 'OK', {
          duration: 3000,
        });
      },
      error: (error) => {
        console.log(error);
      },
    });
  }

  getAllCustomers(): void {
    this.customerService.listarCustomers().subscribe({
      next: (data) => {
        console.log(data);
        this.customers = data;
        this.dataSource = new MatTableDataSource<any>(this.customers);
        this.dataSource.paginator = this.paginator;
      },
      error: (error) => {
        console.log(error);
      },
    });
  }
}
