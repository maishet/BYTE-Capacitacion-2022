import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HTTP_INTERCEPTORS } from "@angular/common/http";
import { LoginService } from "./login.service";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private loginService: LoginService) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (this.loginService.estaLogueado()) {
      const token = this.loginService.getToken();
      req = req.clone({
        setHeaders: {
          Authorization: `Bearer ${token}` // se agrega el token en el header de la petición
        }
        });
    }
    return next.handle(req);
    }
}

export const authInterceptorProviders = [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true } // se agrega el interceptor en el array de providers
];