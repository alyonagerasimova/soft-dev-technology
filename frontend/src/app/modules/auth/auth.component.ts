import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.less']
})
export class AuthComponent implements OnInit {

  public openForm: boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

  openLoginForm() {

  }

  openRegisterForm() {
    this.openForm = true;
    console.log(this.openForm);
  }
}
