import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import { AuthComponent } from './auth.component';
import {RegisterComponent} from "./components/register/register.component";
import {LoginComponent} from "./components/login/login.component";
import {httpInterceptorProviders} from "./auth-interceptor";
import {AuthService} from "./auth.service";
import {TokenService} from "./token.service";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AuthComponent,
    RegisterComponent,
    LoginComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  exports: [
    AuthComponent
  ],
  providers: [
    httpInterceptorProviders,
    AuthService,
    TokenService
  ]
})
export class AuthModule {
}
