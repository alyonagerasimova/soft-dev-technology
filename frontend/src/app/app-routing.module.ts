import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AppComponent} from "./app.component";
import {LoginComponent} from "./modules/auth/components/login/login.component";
import {RegisterComponent} from "./modules/auth/components/register/register.component";
import {AuthComponent} from "./modules/auth/auth.component";

const routes: Routes = [
  {path: "", component: AuthComponent},
  {path: "auth/login", component: LoginComponent},
  {path: "auth/register", component: RegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
