import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import baserUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public loginStatusSubjec = new Subject<boolean>(); //creamos un observable para escuchar los cambios en el login

  constructor(private http: HttpClient) { }

    //generamos el token
    public generateToken(loginData:any){
      return this.http.post(`${baserUrl}/generate-token`,loginData);
    }
  
    public getActualUsuario(){
      return this.http.get(`${baserUrl}/actual-usuario`);
    }
  
    //iniciamos sesión y establecemos el token en el localStorage del navegador
    public loginUser(token:any){
      localStorage.setItem('token',token); //almacenamos el token en el localStorage
      return true;
    }
  
    public estaLogueado(){
      let tokenStr = localStorage.getItem('token'); //obtenemos el token del localStorage
      if(tokenStr == undefined || tokenStr == '' || tokenStr == null){
        return false;
      }else{
        return true; //si existe el token, el usuario esta logueado
      }
    }
  
    //cerramos sesion y eliminamos el token del localStorage
    public logout(){
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      return true;
    }
  
    //obtenemos el token
    public getToken(){
      return localStorage.getItem('token'); //obtenemos el token del localStorage
    }
  
    public setUser(user:any){
      localStorage.setItem('user', JSON.stringify(user)); //almacenamos el usuario en el localStorage como un string
    }
  
    public getUser(){
      let userStr = localStorage.getItem('user');
      if(userStr != null){
        return JSON.parse(userStr); //convertimos el string en un objeto json
      }else{
        this.logout();
        return null; //si no existe el usuario, lo mandamos al login
      }
    }
  
    public getUserRole(){
      let user = this.getUser();
      return user.authorities[0].authority; //usuario actual su autoridad, defecto es ADMIN
    }
}
