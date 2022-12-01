import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {JwtResponse, UserLogin, UserRegister} from "../types";
import {Observable} from "rxjs";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loginUrl = "http://localhost:8080/auth/login";
  private registerUrl = "http://localhost:8080/auth/register";

  login(credentials: UserLogin): Observable<JwtResponse>{
    return this.http.post<JwtResponse>(this.loginUrl, credentials, httpOptions);
  }

  register(info: UserRegister): Observable<string>{
    return this.http.post<string>(this.registerUrl, info, httpOptions);
  }

  constructor(private http: HttpClient) { }


}
