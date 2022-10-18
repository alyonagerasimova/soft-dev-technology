import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userUrl = "http://localhost:8080/users/user";

  constructor(private http: HttpClient) { }

  getUserByName(username: string){
    const url = `${this.userUrl}?username=${username}`;
    return this.http.get(url, {responseType: "json"});
  }
}
