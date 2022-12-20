//import { LoginService } from './../../service/login.service';
import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isLoggedIn = false;
  user:any = null;

  constructor(public login:LoginService) { } //inyeccion de dependencias

  ngOnInit(): void {
    this.isLoggedIn = this.login.estaLogueado();
    this.user = this.login.getUser();
    this.login.loginStatusSubjec.asObservable().subscribe( //escuchamos los cambios en el login
      data => {
        this.isLoggedIn = this.login.estaLogueado();
        this.user = this.login.getUser();
      }
    )
  }

  public logout(){
    this.login.logout();
    window.location.reload();
  }

}
