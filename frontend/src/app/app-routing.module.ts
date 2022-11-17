import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AppComponent} from "./app.component";
import {LoginComponent} from "./modules/auth/login/login.component";
import {RegisterComponent} from "./modules/auth/register/register.component";
import {WelcomeComponent} from "./modules/auth/welcome/welcome.component";
import {HomeComponent} from "./modules/home/home.component";

const routes: Routes = [
  {path: "welcome", component: WelcomeComponent},
  {path: "auth/login", component: LoginComponent},
  {path: "auth/register", component: RegisterComponent},
  {path: "home", component: HomeComponent},
  {path: "", redirectTo: "welcome", pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
