import { Injectable } from '@angular/core';
import {Artist} from "../../types";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";



@Injectable({
  providedIn: 'root'
})
export class ArtistService {

  private url = "http://localhost:8080/artists";

  constructor(private http: HttpClient) { }

  public getArtists(): Observable<Artist[]>{
    return this.http.get<Artist[]>(this.url);
  }

  getArtist(id : string): Observable<Artist>{
    return this.http.get<Artist>(`${this.url}/${id}`);
  }

  //   @PostMapping("/create")
  //   @PreAuthorize("hasRole('ADMIN')")
  //   public ArtistDto create(@RequestBody ArtistDto dto) {
  //   if (dto.getId() != null) {
  //   dto.setId(null);
  // }
  // return artistService.save(dto);
  // }
  //
  // @PutMapping("/{id}")
  // @PreAuthorize("hasRole('ADMIN')")
  // public ArtistDto update(@PathVariable String id,@RequestBody ArtistDto dto) {
  //   dto.setId(id);
  //   return artistService.save(dto);
  // }
  //
  // @DeleteMapping("/{id}")
  // @PreAuthorize("hasRole('ADMIN')")
  // public void delete(@PathVariable String id) {
  //   artistService.delete(id);
  // }

}
