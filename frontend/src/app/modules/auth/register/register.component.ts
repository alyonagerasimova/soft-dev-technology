import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {Location} from '@angular/common';
import {AuthService} from "../auth.service";
import {TokenService} from "../token.service";
import {AuthRegisterInfo} from "./AuthRegisterInfo";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.less']
})
export class RegisterComponent implements OnInit {

  public formModel!: FormGroup;
  private isRegister = false;
  private user!: AuthRegisterInfo;

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
        '',
        [Validators.required, Validators.minLength(2)],
      ],
      email: [
        '',
        [Validators.required, Validators.minLength(2)],
      ],
      password: ['', [
        Validators.required, Validators.minLength(2)]],
    });

    if (this.tokenStorage.getToken()) {
      this.isRegister = true;
      console.log("Get token");
    }
  }

  public goBack(): void {
    this.location.go('/welcome');
  }

  public onSave(): void {
      this.user = new AuthRegisterInfo(
        this.formModel.controls['username'].value,
        this.formModel.controls['email'].value,
        this.formModel.controls['password'].value);

      this.authService.signUp(this.user).subscribe(
        data => {
          this.isRegister = true;
          console.log("Login!");
        },
        error => {
          this.isRegister = false;
          console.log(error);
        }
      );
    // this.animalsService
    //   .updateAnimal({
    //     ...this.animal,
    //     ...this.formModel.value,
    //   })
    //   .subscribe(() => this.goBack());
  }

}
