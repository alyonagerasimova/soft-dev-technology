import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Artist, Playlist, Song} from "../types";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class HomeService {
  private url = "http://localhost:8080/home";

  public getData(): Observable<[Song[], Playlist[],Artist[]]>{
    return this.http.get<[Song[], Playlist[],Artist[]]>(this.url);
  }

  constructor(private http: HttpClient) { }
}
