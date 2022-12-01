import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AppComponent} from "./app.component";
import {AdminComponent} from "./modules/admin/admin.component";
import {LoginComponent} from "./modules/auth/login/login.component";
import {RegisterComponent} from "./modules/auth/register/register.component";
import {WelcomeComponent} from "./modules/auth/welcome/welcome.component";
import {HomeComponent} from "./modules/home/home.component";
import {ProfileComponent} from "./modules/profile/profile.component";

const routes: Routes = [
  {path: "welcome", component: WelcomeComponent},
  {path: "auth/login", component: LoginComponent},
  {path: "auth/register", component: RegisterComponent},
  {path: "home", component: HomeComponent},
  {path: "admin", component: AdminComponent},
  {path: 'profile', component: ProfileComponent},
  {path: "", redirectTo: "welcome", pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
