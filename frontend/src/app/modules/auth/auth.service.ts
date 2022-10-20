import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {JwtResponse, UserLogin, UserRegister} from "../types";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loginUrl = "http://localhost:8080/auth/login";
  private registerUrl = "http://localhost:8080/auth/register";

  attempAuth(credentials: UserLogin): Observable<JwtResponse>{
    return this.http.post<JwtResponse>(this.loginUrl, credentials);
  }

  signUp(info: UserRegister): Observable<string>{
    return this.http.post<string>(this.registerUrl, info);
  }

  constructor(private http: HttpClient) { }


}