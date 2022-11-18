import { Component, OnInit } from '@angular/core';
import {Artist, Playlist, Song} from "../types";
import {HomeService} from "./home.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.less']
})
export class HomeComponent implements OnInit {
  isLoading: boolean = false;
  artistsList: Song [] = [];
  songsList: Song[] = [];
  playlistsList: Playlist[] = [];

  constructor(private homeService: HomeService) { }

  ngOnInit(): void {
    this.homeService.getData()
      .subscribe(data => {
        this.songsList = data[0];
        this.playlistsList = data[1];
        this.artistsList = data[2];
        console.log(this.artistsList)
        this.isLoading = true;
      });
  }

}
