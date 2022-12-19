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
    username : '',
    password : '',
  }
  constructor(private userService:UserService,private snack:MatSnackBar) { }
  ngOnInit(): void {
  }

  formSubmit(){
    console.log(this.user);
    if(this.user.username == '' || this.user.username == null){
      this.snack.open('El nombre de usuario es requerido !!','Aceptar',{
        duration : 3000,
        verticalPosition : 'top',
        horizontalPosition : 'right'
      });
      return;
    }

    // this.userService.añadirUsuario(this.user).subscribe(
    //   (data) => {
    //     console.log(data);
    //     Swal.fire('Usuario guardado','Usuario registrado con exito en el sistema','success');
    //   },(error) => {
    //     console.log(error);
    //     this.snack.open('Ha ocurrido un error en el sistema !!','Aceptar',{
    //       duration : 3000
    //     });
    //   }
    // )
  }
}
