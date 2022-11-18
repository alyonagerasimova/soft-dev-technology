import { Injectable } from '@angular/core';
import {Artist} from "../../types";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ArtistService {

  private url = "http://localhost:8080/home";

  getArtist(id : string): Observable<Artist>{
    return this.http.get<Artist>(`this.url/${id}`);
  }

  constructor(private http: HttpClient) { }

}
