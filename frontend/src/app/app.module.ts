import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import {RouterModule} from "@angular/router";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AppRoutingModule} from "./app-routing.module";
import {AuthModule} from "./modules/auth/auth.module";
import { HomeComponent } from './modules/home/home.component';
import { ArtistComponent } from './modules/components/artist/artist.component';
import { SongComponent } from './modules/components/song/song.component';
import { PlaylistComponent } from './modules/components/playlist/playlist.component';
import { AdminComponent } from './modules/admin/admin.component';
import { HeaderComponent } from './modules/components/header/header.component';
import { SidebarComponent } from './modules/components/sidebar/sidebar.component';
import { PlayerComponent } from './modules/components/player/player.component';
import { UserComponent } from './modules/user/user.component';

@NgModule({
  declarations: [AppComponent, HomeComponent, ArtistComponent, SongComponent, PlaylistComponent, AdminComponent, HeaderComponent, SidebarComponent, PlayerComponent, UserComponent],
  imports: [
    BrowserModule,
    RouterModule,
    AppRoutingModule,
    FormsModule,
    AuthModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
