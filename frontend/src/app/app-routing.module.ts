import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AppComponent} from "./app.component";
import {LoginComponent} from "./modules/auth/components/login/login.component";
import {RegisterComponent} from "./modules/auth/components/register/register.component";
import {AuthComponent} from "./modules/auth/auth.component";
import {MainPageComponent} from "./main-page/main-page.component";

const routes: Routes = [
  {path: "", component: AppComponent},
  {path: "welcome", component: AuthComponent},
  {path: "auth/login", component: LoginComponent},
  {path: "auth/register", component: RegisterComponent},
  {path: "home", component: MainPageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
