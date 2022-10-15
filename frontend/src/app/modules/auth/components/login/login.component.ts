import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {User} from "../../../types";
import {ActivatedRoute} from "@angular/router";
import {Location} from "@angular/common";

@Component({
  selector: 'app-login.component',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.less']
})
export class LoginComponent implements OnInit {

  public formModel!: FormGroup;
  public user!: User;

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private location: Location) {
  }

  ngOnInit(): void {
    this.formModel = this.formBuilder.group({
      username: [
        '',
        [Validators.required, Validators.minLength(2)],
      ],
      password: ['', [
        Validators.required, Validators.minLength(2)]],
    });
  }

  public goBack(): void {
    this.location.go('/auth');
  }

  public onSave(): void {
    // this.animalsService
    //   .updateAnimal({
    //     ...this.animal,
    //     ...this.formModel.value,
    //   })
    //   .subscribe(() => this.goBack());
  }


}
