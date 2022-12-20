import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from './../../service/user.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css']
})
export class RegistroComponent implements OnInit{
  public user = {
    name : '',
    clave : '',
  }
  constructor(private userService:UserService,private snack:MatSnackBar) { }
  ngOnInit(): void {
  }

  formSubmit(){
    console.log(this.user);
    if(this.user.name == '' || this.user.name == null){
      this.snack.open('El nombre de usuario es requerido !!','Aceptar',{
        duration : 3000,
        verticalPosition : 'top',
        horizontalPosition : 'right'
      });
      return;
    }

    this.userService.guardarUsuario(this.user).subscribe(
      (data) => {
        console.log(data);
        this.snack.open('Usuario registrado con éxito !!','Aceptar',{
          duration : 3000,
          verticalPosition : 'top',
          horizontalPosition : 'right'
        });
      },(error) => {
        console.log(error);
        this.snack.open('Ha ocurrido un error en el sistema !!','Aceptar',{
          duration : 3000
        });
      }
    )
  }
}
