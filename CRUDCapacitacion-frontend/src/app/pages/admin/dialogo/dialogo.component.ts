import { AfterViewInit, Component, OnInit, Inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CustomerService } from 'src/app/service/customer.service';
import { PaisesService } from 'src/app/service/paises.service';
import {MatDialog, MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-dialogo',
  templateUrl: './dialogo.component.html',
  styleUrls: ['./dialogo.component.css'],
})
export class DialogoComponent implements OnInit, AfterViewInit {
  paises: any = [];
  region: string[] = ['África', 'América', 'Asia', 'Europa', 'Oceanía'];
  actionBtn: string = 'Guardar';
  clienteform!: FormGroup;
  constructor(
    private paisService: PaisesService,
    private formBuilder: FormBuilder,
    private cliente: CustomerService,
    private snack: MatSnackBar,
    @Inject(MAT_DIALOG_DATA) public editdata: any,
    public dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.clienteform = this.formBuilder.group({
      customerID: ['', Validators.required],
      companyName: ['', Validators.required],
      contactName: ['', Validators.required],
      contactTitle: [''],
      address: [''],
      city: [''],
      region: [''],
      postalCode: [''],
      country: [''],
      phone: [''],
      fax: [''],
    });

    //console.log(this.editdata); //obtener datos del cliente a editar
    if (this.editdata) {
      this.actionBtn = 'Actualizar';
      this.clienteform.patchValue(this.editdata); //actualizar datos del cliente
    }
  }

  ngAfterViewInit(): void {
    //obtener paises de manera asincrona con observable

    this.paisService.getPaises().subscribe(
      (data: any) => {
        this.paises = data;
        console.log(this.paises);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  guardarCliente(): void {
    console.log(this.clienteform.value);
    if(this.editdata){ //si existe datos del cliente a editar se actualiza
      if (this.clienteform.valid) {
        this.cliente.saveCustomer(this.clienteform.value)
        .subscribe({
          next: (data) => {
            console.log(data);
            this.snack.open('Cliente guardado', 'OK', {
              duration: 3000,
            });
            this.clienteform.reset();
            this.dialog.closeAll(); //cerrar dialogo
          },
          error: (error) => {
            console.log(error);
            this.snack.open('Error al guardar cliente', 'OK', {
              duration: 3000,
            });
          }
        });
      }
    } else { //si no existe datos del cliente a editar se guarda
      this.actualizarCliente();
    }

  }

  actualizarCliente(): void {
    if (this.clienteform.valid) {
      this.cliente.saveCustomer(this.clienteform.value)
      .subscribe({
        next: (data) => {
          console.log(data);
          this.snack.open('Cliente actualizado correctamente ', 'OK', {
            duration: 3000,
          });
          this.clienteform.reset();
          this.dialog.closeAll(); //cerrar dialogo
        },
        error: (error) => {
          console.log(error);
          this.snack.open('Error al guardar cliente', 'OK', {
            duration: 3000,
          });
        }
      });
    }
  }
}
