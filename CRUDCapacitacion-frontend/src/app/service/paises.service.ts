import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PaisesService {

  private url:string = "https://restcountries.com/v3.1/all"; //listado de paises

  paises:any = [];

  constructor(private http: HttpClient) { }

  getPaises(): Observable<any> {
    //de manera asincrona con observable
    return this.http.get<any>(this.url) //devuelve un observable que se puede suscribir
    //return this.http.get(this.url);
  }
}
