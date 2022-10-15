import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {Location} from '@angular/common';
import {User} from "../../../types";
import {switchMap} from "rxjs";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.less']
})
export class RegisterComponent implements OnInit {

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
      email: [
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
