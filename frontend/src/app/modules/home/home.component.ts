import { Component, OnInit } from '@angular/core';
import {Artist} from "../types";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.less']
})
export class HomeComponent implements OnInit {
  isLoading: boolean = false;
  artistsList: Artist[] = [];

  constructor(
    // private artistsService: ArtistsService
  ) { }

  ngOnInit(): void {
    // this.animalsService.getAnimalsData()
    //   .subscribe(animals => {
    //     this.animalsList = animals;
    //     this.loadingComplete = true;
    //   });
  }

}
