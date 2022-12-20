import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  hide = true;
  datoslogin = {
    "username" : '',
    "password" : '',
  }
  constructor(private snack:MatSnackBar, private service:LoginService, private router:Router) { } //inyeccion de dependencias

  ngOnInit(): void {
  }
  formSubmit(){
    console.log(this.datoslogin); //formt json
    // si es vacio
    if(this.datoslogin.username.trim() == '' || this.datoslogin.username.trim() == null ||
    this.datoslogin.password.trim() == '' || this.datoslogin.password.trim() == null){
      this.snack.open("Complete los campos", "OK", {
        duration: 3000,
      });
    }else{
      // si no es vacio, petición al servidor
      this.service.generateToken(this.datoslogin).subscribe(
        (data:any) => {
          console.log(data);// el token en json
          this.service.loginUser(data.token); //guardamos el token en el localStorage
          this.service.getActualUsuario().subscribe((user:any) => {
            this.service.setUser(user); //guardamos el usuario en el localStorage
            console.log(user);
            if(this.service.getUserRole() == 'ADMIN'){
              //redireccionamos al dashboard
              //window.location.href = '/admin'; //al path /customers
              this.router.navigate(['/admin']);
              this.service.loginStatusSubjec.next(true); //avisamos a los componentes que el usuario se logueo
            }else{
              this.service.logout(); //si no es admin, lo mandamos al login
            }
          })
        },(error) => {
          console.log(error);
          this.snack.open("Usuario o contraseña incorrectos", "OK", {
            duration: 3000,
          });
        }
      )

    }
  }

}
