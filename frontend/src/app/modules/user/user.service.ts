import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userUrl = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  getUserByName(username: string){
    const url = `/users/user${this.userUrl}?username=${username}`;
    return this.http.get(url, {responseType: "json"});
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(this.userUrl + "admin", {responseType: 'text'});
  }
}
