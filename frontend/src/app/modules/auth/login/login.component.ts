import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { ActivatedRoute } from "@angular/router";
import { Location } from "@angular/common";
import { UserLogin } from "../../types";
import { AuthService } from "../auth.service";
import { TokenService } from "../token.service";
import { AuthLoginInfo } from "./AuthLoginInfo";

@Component({
  selector: "app-login.component",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.less"]
})
export class LoginComponent implements OnInit {

  public formModel!: FormGroup;
  private isLogin = false;
  private user!: AuthLoginInfo;
  roles: string[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private location: Location,
    private authService: AuthService,
    private tokenStorage: TokenService) {
  }

  ngOnInit(): void {
    this.formModel = this.formBuilder.group({
      username: [
        "",
        [Validators.required, Validators.minLength(2)],
      ],
      password: [
        "",
        [Validators.required, Validators.minLength(2)]],
    });

    if (this.tokenStorage.getToken()) {
      this.isLogin = true;
      this.roles = this.tokenStorage.getUser().roles;
      console.log("Get token");
    }
  }

  public goBack(): void {
    this.location.go("/auth");
  }

  public onSubmit(): void {

    this.user = new AuthLoginInfo(this.formModel.controls["username"].value, this.formModel.controls["password"].value);

    this.authService.attempAuth(this.user)
      .subscribe(
        data => {
          this.tokenStorage.saveToken(data.jwt);
          localStorage.setItem("token", data.jwt);
          this.tokenStorage.saveUsername(data.username);
          this.isLogin = true;
          this.roles = this.tokenStorage.getUser().roles;
          this.reloadPage();
          console.log("Login!");
        },
        error => {
          this.isLogin = false;
          console.log(error);
        }
      );
  }

  reloadPage(): void {
    window.location.reload();
  }
}
